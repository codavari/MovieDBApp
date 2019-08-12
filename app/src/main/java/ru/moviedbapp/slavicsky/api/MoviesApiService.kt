package ru.moviedbapp.slavicsky.api

import retrofit2.Callback
import retrofit2.http.GET
import ru.moviedbapp.slavicsky.Film

/**
 * Created by jose on 10/6/15.
 */
interface MoviesApiService {
    @GET("/movie/popular")
    fun getPopularMovies(cb: Callback<Film>)
}
