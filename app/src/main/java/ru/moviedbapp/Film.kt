package ru.moviedbapp

class Film internal constructor(title: String, rating: Double?, description: String, thumbnail: Int) {

    internal var title: String? = title
    var rating: Double? = 0.0
    internal var description: String? = description
    var thumbnail: Int = 0
}