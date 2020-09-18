package ru.moviedbapp.codavari.models.network

import ru.moviedbapp.codavari.models.entity.Movie

data class DiscoverMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
)