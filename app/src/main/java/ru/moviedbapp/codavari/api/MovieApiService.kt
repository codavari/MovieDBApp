package ru.moviedbapp.codavari.api

import retrofit2.http.GET
import retrofit2.http.Path
import ru.moviedbapp.codavari.data.remote.MovieResponse
import ru.moviedbapp.codavari.models.entity.Movie

interface MovieApiService {
    @GET("/3/movie/now_playing")
    fun fetchMovies(page: Int): MovieResponse

    @GET("/3/movie/{movie_id}")
    fun fetchMovieDetail(@Path("movie_id") movieId: Int): Movie
}