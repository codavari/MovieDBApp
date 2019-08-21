package ru.moviedbapp.slavicsky.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

import com.google.gson.annotations.SerializedName

class Movie : Parcelable {
    var title: String? = null
    @SerializedName("poster_path")
    private var poster: String? = null
    @SerializedName("overview")
    var description: String? = null
    @SerializedName("backdrop_path")
    var backdrop: String? = null
    @SerializedName("vote_average")
    var rating: Double? = null

    constructor() {}

    internal constructor(`in`: Parcel) {
        title = `in`.readString()
        poster = `in`.readString()
        description = `in`.readString()
        backdrop = `in`.readString()
        rating = `in`.readDouble()
    }

    fun getPoster(): String {
        return "http://image.tmdb.org/t/p/w500" + poster!!
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(title)
        parcel.writeString(poster)
        parcel.writeString(description)
        parcel.writeString(backdrop)
        parcel.writeString(rating!!.toString())
    }

    class MovieResult(val results: List<Movie>)

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
