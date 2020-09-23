package ru.moviedbapp.codavari.api

import retrofit2.http.GET
import ru.moviedbapp.codavari.models.network.MovieResponse

interface MovieApiService {
    @GET("/3/movie/now_playing")
    fun fetchMovies(page: Int): MovieResponse
}