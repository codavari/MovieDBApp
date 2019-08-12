package ru.moviedbapp.slavicsky

class Film internal constructor(title: String, rating: Double, description: String, var thumbnail: Int) {

    internal var title: String? = title
    internal var rating: Double? = rating
    internal var description: String? = description
}