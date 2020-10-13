package ru.moviedbapp.codavari.view.movies

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.fragment_movie_list.*
import ru.moviedbapp.R
import ru.moviedbapp.codavari.models.entity.Movie

class MoviesFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private lateinit var adapter: MovieAdapter
    private var requestManager: RequestManager? = null


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
    }

    private fun subscribeUI() {

        moviesViewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            if (viewState != null) {
                adapter.apply {
                    viewState.movies?.let {

                        differ.submitList(it)
                        Log.d(TAG, "subscribeObservers: differ")
                    }
                }
            }
        })
    }
}