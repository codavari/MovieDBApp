package ru.moviedbapp.codavari.repository

import kotlinx.coroutines.flow.Flow
import ru.moviedbapp.codavari.models.entity.Movie

interface MovieRepository {

  fun getMovies(page: Int): Flow<List<Movie>>

  suspend fun refresh()

}