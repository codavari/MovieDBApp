package ru.moviedbapp.codavari.view.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import ru.moviedbapp.R
import ru.moviedbapp.codavari.states.MovieStateEvent
import ru.moviedbapp.codavari.util.Response
import ru.moviedbapp.codavari.util.StateMessageCallback
import ru.moviedbapp.codavari.view.UICommunicationListener
import timber.log.Timber

@AndroidEntryPoint
@FlowPreview
@ExperimentalCoroutinesApi
class MoviesFragment : Fragment(), UICommunicationListener {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
    private lateinit var adapter: MovieAdapter
    lateinit var uiCommunicationListener: UICommunicationListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initUI()
        moviesViewModel.setStateEvent(MovieStateEvent.NowPlayingEvent)
        subscribeUI()
        return inflater.inflate(R.layout.fragment_movie_list, container)
    }

    private fun initUI() {
        rv_movies_list.layoutManager = LinearLayoutManager(requireContext())
        rv_movies_list.adapter = MovieAdapter()
    }

    override fun displayProgressBar(isLoading: Boolean) {

    }

    private fun subscribeUI() {
        moviesViewModel.numActiveJobs.observe(viewLifecycleOwner, {
            uiCommunicationListener.displayProgressBar(moviesViewModel.areAnyJobsActive())
        })

        moviesViewModel.viewState.observe(viewLifecycleOwner, { viewState ->
            if (viewState != null) {
                adapter.apply {
                    viewState.movies?.let {
                        differ.submitList(it)
                        Timber.d("subscribeObservers: differ")
                    }
                }
            }
        })
    }

    override fun onResponseReceived(
        response: Response,
        stateMessageCallback: StateMessageCallback
    ) {
        TODO("Not yet implemented")
    }

    override fun expandAppBar() {
        TODO("Not yet implemented")
    }
}