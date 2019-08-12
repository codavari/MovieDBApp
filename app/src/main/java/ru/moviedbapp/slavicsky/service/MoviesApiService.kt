package ru.moviedbapp.slavicsky.service

import retrofit2.Callback
import retrofit2.http.GET
import ru.moviedbapp.slavicsky.data.MovieResult

/**
 * Created by jose on 10/6/15.
 */
interface MoviesApiService {
    @GET("/movie/popular")
    fun getPopularMovies(cb: Callback<MovieResult>)
}
