package ru.moviedbapp.codavari.view.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.moviedbapp.codavari.data.repository.MovieRepository
import ru.moviedbapp.codavari.models.entity.Movie
import ru.moviedbapp.codavari.util.DataState
import ru.moviedbapp.codavari.util.StateEvent

class MoviesViewModel @ViewModelInject constructor(private val repository: MovieRepository) : ViewModel(){

    private val _movies = MutableLiveData<DataState<ArrayList<Movie>>>()
    val moviesResponse : LiveData<DataState<ArrayList<Movie>>> = _movies

    fun fetch(id: Int, stateEvent: StateEvent){
        viewModelScope.launch{
            repository.getNowPlaying(id, stateEvent)
        }
    }
}