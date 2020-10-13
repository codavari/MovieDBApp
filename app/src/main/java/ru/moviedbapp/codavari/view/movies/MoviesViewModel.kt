package ru.moviedbapp.codavari.view.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import ru.moviedbapp.codavari.data.repository.MovieRepository
import ru.moviedbapp.codavari.models.entity.Movie
import ru.moviedbapp.codavari.states.MovieStateEvent
import ru.moviedbapp.codavari.states.MovieViewState
import ru.moviedbapp.codavari.util.*
import ru.moviedbapp.codavari.util.ErrorHandling.INVALID_STATE_EVENT
import ru.moviedbapp.codavari.view.BaseViewModel

@ExperimentalCoroutinesApi
@FlowPreview
class MoviesViewModel @ViewModelInject constructor(private val repository: MovieRepository) :
    BaseViewModel<MovieViewState>() {

    private val _movies = MutableLiveData<DataState<ArrayList<Movie>>>()
    val moviesResponse: LiveData<DataState<ArrayList<Movie>>> = _movies

    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()

    fun fetch(id: Int, stateEvent: StateEvent) {
        viewModelScope.launch {
            repository.getNowPlaying(id, stateEvent)
        }
    }

    override fun handleNewData(data: MovieViewState) {

        data.movies.let { movies ->
            movies?.let {
                setMoviesData(it)
            }
        }

        data.movieDetailFields.let { movieDetailFields ->
            movieDetailFields.movieEntity?.let {
                setMovieDetail(it)
            }


        }

    }

    private fun setMoviesData(movies: List<Movie>) {
        val update = getCurrentViewStateOrNew()
        update.movies = movies
        setViewState(update)
    }

    private fun setMovieDetail(movieEntity: Movie) {
        val update = getCurrentViewStateOrNew()
        update.movieDetailFields.movieEntity = movieEntity
        setViewState(update)
    }


    override fun initNewViewState(): MovieViewState {
        return MovieViewState()
    }


    override fun onCleared() {
        super.onCleared()
        cancelActiveJobs()
    }

    fun getMovieId(): Int {
        return getCurrentViewStateOrNew().movieDetailFields.movieId ?: 0
    }

    fun setMovieId(movieId: Int) {
        val update = getCurrentViewStateOrNew()
        val movieDetailFields = update.movieDetailFields
        movieDetailFields.movieId = movieId
        update.movieDetailFields = movieDetailFields
        setViewState(update)
    }


    override fun setStateEvent(stateEvent: StateEvent) {
        if (!isJobAlreadyActive(stateEvent)) {
            val job: Flow<DataState<MovieViewState>> = when (stateEvent) {

                is MovieStateEvent.NowPlayingEvent -> {
                    repository.getNowPlaying(
                        stateEvent = stateEvent,
                        page = moviePageLiveData.value as Int
                    )

                }

                is MovieStateEvent.MovieDetailEvent -> {
                    repository.getMovieDetail(
                        stateEvent = stateEvent,
                        movieId = getMovieId()
                    )
                }

                else -> {
                    flow {
                        emit(
                            DataState.error<MovieViewState>(
                                response = Response(
                                    message = INVALID_STATE_EVENT,
                                    uiComponentType = UIComponentType.Toast(),
                                    messageType = MessageType.Error()
                                ),
                                stateEvent = stateEvent
                            )
                        )
                    }
                }
            }
            launchJob(stateEvent, job)
        }
    }

    fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)

}