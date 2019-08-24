package ru.moviedbapp.slavicsky.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.moviedbapp.R
import ru.moviedbapp.slavicsky.adapters.MoviesAdapter
import ru.moviedbapp.slavicsky.data.Movie
import ru.moviedbapp.slavicsky.service.ApiFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar?>(R.id.toolbar)
        setSupportActionBar(toolbar)

        mRecyclerView = findViewById(R.id.recyclerView)
        mRecyclerView.layoutManager = GridLayoutManager(this, 2)
        mAdapter = MoviesAdapter(this)
        mRecyclerView.adapter = mAdapter

        val movieService = ApiFactory.tmdbApi
        val call = movieService.getPopularMovies()

        call.enqueue(object : Callback<MutableList<Movie>> {
            override fun onFailure(call: Call<MutableList<Movie>>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<MutableList<Movie>>,
                                    response: Response<MutableList<Movie>>) {
                mAdapter.mMovieList = response.body()!!
            }
        })

/*        fun getPopularMovies() {
        }*/

        fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.menu_main, menu)
            return true
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            val id = item.itemId


            return if (id == R.id.action_settings) {
                true
            } else super.onOptionsItemSelected(item)
        }


    }
}