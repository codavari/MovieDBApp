package ru.moviedbapp.codavari.repository

import kotlinx.coroutines.flow.Flow
import ru.moviedbapp.codavari.models.entity.Movie

interface MovieRepository {

  fun getNowPlaying(page: Int): Flow<List<Movie>>

  suspend fun refresh()

}