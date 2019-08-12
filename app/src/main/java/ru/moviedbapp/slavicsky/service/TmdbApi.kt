package ru.moviedbapp.slavicsky.service

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import ru.moviedbapp.slavicsky.data.MovieResult

interface TmdbApi{
    @GET("movie/popular")
    fun getPopularMovie(): Deferred<Response<MovieResult>>
}