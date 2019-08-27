package ru.moviedbapp.slavicsky.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import com.squareup.moshi.Json

class Movie(parcel: Parcel) : Parcelable {
    @field:Json(name = "title")
    var title: String? = parcel.readString()
    @field:Json(name = "poster_path")
    private var poster: String? = parcel.readString()
    @field:Json(name = "overview")
    var overview: String? = parcel.readString()
    @field:Json(name = "backdrop_path")
    var backdrop: String? = parcel.readString()
    @field:Json(name = "vote_average")
    var voteAverage: Double = parcel.readDouble()

    fun getPoster(): String {
        return "http://image.tmdb.org/t/p/w500" + poster!!
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(title)
        parcel.writeString(poster)
        parcel.writeString(overview)
        parcel.writeString(backdrop)
        parcel.writeString(voteAverage.toString())
    }

    companion object {
        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(`in`: Parcel): Movie {
                return Movie(`in`)
            }
            override fun newArray(size: Int): Array<Movie?> {
                return arrayOfNulls(size)
            }
        }
    }
}

data class MovieResponse(@field:Json(name="results") internal val jopa: List<Movie>):Parcelable{

    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(Movie.CREATOR) as List<Movie>)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(jopa)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieResponse> {
        override fun createFromParcel(parcel: Parcel): MovieResponse {
            return MovieResponse(parcel)
        }

        override fun newArray(size: Int): Array<MovieResponse?> {
            return arrayOfNulls(size)
        }
    }
}





