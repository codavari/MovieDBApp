package ru.moviedbapp.codavari.data.remote

import ru.moviedbapp.codavari.models.entity.Movie

data class MovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)