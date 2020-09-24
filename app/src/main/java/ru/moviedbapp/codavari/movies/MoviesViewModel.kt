package ru.moviedbapp.codavari.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import ru.moviedbapp.codavari.data.repository.MovieRepository

class MoviesViewModel @ViewModelInject constructor(private val repository: MovieRepository) : ViewModel(){

}