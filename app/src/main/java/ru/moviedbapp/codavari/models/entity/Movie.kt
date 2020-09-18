package ru.moviedbapp.codavari.models.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize
import ru.moviedbapp.codavari.models.Keyword

@Parcelize
@Entity(primaryKeys = [("id")])
data class Movie(
    var page: Int,
    var keywords: List<Keyword>? = ArrayList(),
    val posterPath: String?,
    val releaseDate: String?,
    val genreIds: List<Int>,
    val id: Int,
    val originalTitle: String,
    val originalLanguage: String,
    val title: String,
    val backdropPath: String?,
    val popularity: Float,
    val voteCount: Int,
    val voteAverage: Float
) : Parcelable