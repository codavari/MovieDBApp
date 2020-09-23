package ru.moviedbapp.codavari.repository

import ru.moviedbapp.codavari.states.MovieViewState
import ru.moviedbapp.codavari.states.MovieViewState.MovieDetailFields
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.moviedbapp.codavari.api.MovieApiService
import ru.moviedbapp.codavari.db.MovieDao
import ru.moviedbapp.codavari.models.entity.Movie
import ru.moviedbapp.codavari.models.network.MovieResponse
import ru.moviedbapp.codavari.util.DataState
import ru.moviedbapp.codavari.util.StateEvent
import javax.inject.Inject

private const val TAG = "MovieRepositoryImpl"

@FlowPreview
class MovieRepositoryImpl @Inject constructor(
    val service: MovieApiService,
    val movieDao: MovieDao
) : MovieRepository {

    @FlowPreview
    override fun getNowPlaying(
        page: Int,
        stateEvent: StateEvent
    ): Flow<DataState<MovieViewState>> =
        object : NetworkBoundResource<MovieResponse, List<Movie>, MovieViewState>(
            dispatcher = IO,
            stateEvent = stateEvent,
            apiCall = {
                service.fetchMovies(page)
            },
            cacheCall = {
                movieDao.getMovies()
            }
        ) {

            override suspend fun updateCache(networkObject: MovieResponse) {
                val movies = networkObject.results
                withContext(IO) {
                    launch {
                        movieDao.insertList(movies)
                    }

                }

            }

            override fun handleCacheSuccess(resultObj: List<Movie>): DataState<MovieViewState> {
                return DataState.data(
                    response = null,
                    data = MovieViewState(movies = resultObj),
                    stateEvent = stateEvent
                )
            }
        }.result

    override fun getMovieDetail(movieId: Int, stateEvent: StateEvent):
            Flow<DataState<MovieViewState>> =
        object : NetworkBoundResource<Movie, Movie, MovieViewState>(
            dispatcher = IO,
            stateEvent = stateEvent,
            apiCall = { service.fetchMovieDetail(movieId) },
            cacheCall = {
                movieDao.getMovie(movieId)
            }

        ) {


            override suspend fun updateCache(networkObject: Movie) {

                withContext(IO){
                    movieDao.insert(networkObject)
                }
            }

            override fun handleCacheSuccess(resultObj: Movie): DataState<MovieViewState> {
                return DataState.data(
                    response = null,
                    data = MovieViewState(
                        movieDetailFields = MovieDetailFields(
                            movieEntity = resultObj,
                            movieId = movieId
                        )
                    ),
                    stateEvent = stateEvent
                )
            }

        }.result

    override suspend fun refresh() {
        TODO("Not yet implemented")
    }


}