
package ru.moviedbapp.slavicsky.service

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import ru.moviedbapp.slavicsky.data.Movie

interface TmdbApi{
    @GET("/discover/movie?api_key=<<api_key>>&language=en-US&sort_by=popularity.desc&include_adult=true&include_video=false&page=1&year=2019")
    fun getPopularMovies() : Call<MutableList<Movie>>
}

