package ru.moviedbapp.slavicsky.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.moviedbapp.R
import ru.moviedbapp.slavicsky.data.Movie
import ru.moviedbapp.slavicsky.ui.MainActivity
import ru.moviedbapp.slavicsky.ui.MovieDetailActivity
import ru.moviedbapp.slavicsky.viewholders.MovieViewHolder
import java.util.ArrayList

class MoviesAdapter(private val mContext: Context) : RecyclerView.Adapter<MovieViewHolder>() {
    lateinit var mMovieList: MutableList<Movie>
    private val mInflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun getItemCount(): Int {
        return if (::mMovieList.isInitialized) {
            mMovieList.size
        } else 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = mInflater.inflate(R.layout.row_movie, parent, false)
        val viewHolder = MovieViewHolder(view)
        view.setOnClickListener {
            val position = viewHolder.adapterPosition
            val intent = Intent(mContext, MovieDetailActivity::class.java)
            intent.putExtra(MovieDetailActivity.EXTRA_MOVIE, mMovieList[position])
            mContext.startActivity(intent)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = mMovieList[position]
        Picasso.get()
            .load(movie.getPoster())
            .placeholder(R.color.colorAccent)
            .into(holder.imageView)
    }

    fun setMovieList(movieList: List<Movie>) {
        this.mMovieList = ArrayList()
        this.mMovieList.addAll(movieList)
        notifyDataSetChanged()
    }
}