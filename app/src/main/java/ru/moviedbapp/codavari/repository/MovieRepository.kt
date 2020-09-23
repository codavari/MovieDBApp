package ru.moviedbapp.codavari.repository

import kotlinx.coroutines.flow.Flow
import ru.moviedbapp.codavari.models.entity.Movie
import ru.moviedbapp.codavari.states.MovieViewState
import ru.moviedbapp.codavari.util.DataState
import ru.moviedbapp.codavari.util.StateEvent

interface MovieRepository {

  fun getNowPlaying(
    page: Int,
    stateEvent: StateEvent
  ): Flow<DataState<MovieViewState>>

  fun getMovieDetail(
    movieId: Int,
    stateEvent: StateEvent
  ): Flow<DataState<MovieViewState>>

  suspend fun refresh()

}