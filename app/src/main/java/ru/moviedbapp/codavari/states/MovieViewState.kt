package ru.moviedbapp.codavari.states

import ru.moviedbapp.codavari.models.entity.Movie

data class MovieViewState(
    var movies: List<Movie>? = null,
    var movieDetailFields: MovieDetailFields = MovieDetailFields()

) {


    data class MovieDetailFields(
        var movieEntity: Movie? = null,
        var movieId: Int? = null
    )


}


