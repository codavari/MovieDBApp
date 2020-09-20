package ru.moviedbapp.codavari.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import ru.moviedbapp.codavari.api.MovieApiService
import ru.moviedbapp.codavari.models.entity.Movie

class MovieRepositoryImpl constructor(
    private val moviesService: MovieApiService
) : MovieRepository {

    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun getMovies(page: Int): Flow<List<Movie>> {
        return flow {

        }
    }

    override suspend fun refresh() =
        getMoviesFromRemote().let { changesChannel.send(Change.Refreshed(it)) }

    @ExperimentalCoroutinesApi
    private val changesChannel = BroadcastChannel<Change>(Channel.CONFLATED)

    private suspend fun getMoviesFromRemote(page: Int): List<Movie> {
        return withContext(Dispatchers.IO) {
            moviesService.fetchMovies(page).map(responseToDomain)
        }
    }

}