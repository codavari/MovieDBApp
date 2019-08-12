package ru.moviedbapp.slavicsky.data

data class Movie(
    val title: String,
    var vote_average: Double,
    var description: String,
    var thumbnail: Int
)

data class MovieResult(
    val results: List<Movie>
)