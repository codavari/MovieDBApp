package ru.moviedbapp.codavari.repository

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import ru.moviedbapp.codavari.api.MovieApiService
import ru.moviedbapp.codavari.models.entity.Movie
import ru.moviedbapp.codavari.models.network.MovieResponse
import ru.moviedbapp.codavari.states.MovieContract
import ru.moviedbapp.codavari.util.DataState
import ru.moviedbapp.codavari.util.StateEvent

class MovieRepositoryImpl constructor(
    private val moviesService: MovieApiService
) : MovieRepository {

    @FlowPreview
    override fun getNowPlaying(
        stateEvent: StateEvent
    ): Flow<DataState<MovieContract.MovieStateEvent>> =
        object : NetworkBoundResource<MovieResponse, List<Movie>, MovieViewState>(
            dispatcher = Dispatchers.IO,
            stateEvent = stateEvent,
            apiCall = {
                moviesService.getNowPlaying()
            },
            cacheCall = {
                movieDao.getMovies()
            }
        ) {

            override suspend fun updateCache(networkObject: MovieResponse) {
                val movies = networkObject.results
                withContext(Dispatchers.IO) {
                    launch {
                        movieDao.insertList(movies)
                    }

                }

            }

            override fun handleCacheSuccess(resultObj: List<Movie>): DataState<MovieViewState> {
                return DataState.data(
                    response = null,
                    data = MovieViewState(
                        movies = resultObj
                    ),
                    stateEvent = stateEvent
                )
            }

        }.result

    override suspend fun refresh() {

    }

    suspend fun refresh(page: Int) =
        getMoviesFromRemote(page).let { changesChannel.send(Change.Refreshed(it)) }

    @ExperimentalCoroutinesApi
    private val changesChannel = BroadcastChannel<Change>(Channel.CONFLATED)

    private suspend fun getMoviesFromRemote(page: Int): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesService.fetchMovies(page).map(responseToDomain)
        }
    }
}