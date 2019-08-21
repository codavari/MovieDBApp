package ru.moviedbapp.slavicsky.service

import ru.moviedbapp.slavicsky.AppConstants

object ApiFactory{
    val tmdbApi : TmdbApi = RetrofitFactory.retrofit(AppConstants.TMDB_BASE_URL)
        .create(TmdbApi::class.java)
}