package ru.moviedbapp.codavari.view.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie_list.*
import ru.moviedbapp.R

class MoviesFragment : Fragment() {

    val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initUI()
        return inflater.inflate(R.layout.fragment_movie_list, container)
    }

    private fun initUI() {
        rv_movies_list.layoutManager = LinearLayoutManager(requireContext())
        rv_movies_list.adapter = MovieAdapter()
        moviesViewModel
    }
}