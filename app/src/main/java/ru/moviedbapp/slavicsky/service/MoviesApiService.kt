package ru.moviedbapp.slavicsky.service

import retrofit2.Callback
import retrofit2.http.GET
import ru.moviedbapp.slavicsky.data.Movie

/**
 * Created by jose on 10/6/15.
 */
interface MoviesApiService {
    @GET("/discover/movie?api_key=<<api_key>>&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=false&page=1&year=2019")
    fun getPopularMovies(cb: Callback<Movie.MovieResult>)
}
