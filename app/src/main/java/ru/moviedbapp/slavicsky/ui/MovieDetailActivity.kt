package ru.moviedbapp.slavicsky.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.CollapsingToolbarLayout

import com.squareup.picasso.Picasso
import ru.moviedbapp.R
import ru.moviedbapp.slavicsky.data.Movie

class MovieDetailActivity : AppCompatActivity() {

    private var mMovie: Movie? = null
    private lateinit var backdrop: ImageView
    private lateinit var poster: ImageView
    private lateinit var rating: TextView
    private lateinit var title: TextView
    private lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        if (intent.hasExtra(EXTRA_MOVIE)) {
            mMovie = intent.getParcelableExtra(EXTRA_MOVIE)
        } else {
            throw IllegalArgumentException("Detail activity must receive a movie parcelable")
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        toolbarLayout.title = mMovie!!.title

        backdrop = findViewById<ImageView>(R.id.backdrop)
        title = findViewById<TextView>(R.id.movie_title)
        description = findViewById<TextView>(R.id.movie_description)
        poster = findViewById<ImageView>(R.id.movie_poster)
        rating = findViewById<TextView>(R.id.movie_rating)

        val button = findViewById<Button>(R.id.calendar_button)

        title.setText(mMovie!!.title)
        description.setText(mMovie!!.description)
        rating.text = "Average vote: " + mMovie!!.rating

        Picasso.get()
            .load(mMovie!!.getPoster())
            .into(poster)
        Picasso.get()
            .load(mMovie!!.backdrop)
            .into(backdrop)
    }

    fun onMyButtonClick(view: View) {
        startActivity(Intent(this, CalendarActivity::class.java))
    }

    companion object {
        const val EXTRA_MOVIE = "movie"
    }
}
