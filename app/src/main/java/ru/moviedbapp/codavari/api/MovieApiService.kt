package ru.moviedbapp.codavari.api

import retrofit2.http.GET

interface MovieApiService {

    @GET("/3/movie/now_playing?api_key=2e72ede56dafd083afd4001bb508238b&language=en-US")
    fun fetchMovies(page: Int)
}