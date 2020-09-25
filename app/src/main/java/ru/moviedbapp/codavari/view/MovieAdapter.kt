package ru.moviedbapp.codavari.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleObserver
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import kotlinx.android.synthetic.main.item_film.view.*
import ru.moviedbapp.codavari.api.Api
import ru.moviedbapp.codavari.models.entity.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>(), LifecycleObserver {

    private val movies = ArrayList<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(viewType, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindData(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var movie: Movie

        @Throws(Exception::class)
        fun bindData(data: Any) {
            if (data is Movie) {
                movie = data
                drawItem()
            }
        }

        private fun drawItem() {
            itemView.run {
                item_poster_title.text = movie.title
                movie.posterPath?.let {
                    Glide.with(context)
                        .load(Api.getPosterPath(it))
                        .listener(
                            GlidePalette.with(Api.getPosterPath(it))
                                .use(BitmapPalette.Profile.VIBRANT)
                                .intoBackground(item_poster_palette)
                                .crossfade(true))
                        .into(item_poster)
                }
            }
        }
    }
}
