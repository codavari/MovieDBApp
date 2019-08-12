package ru.moviedbapp.slavicsky.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import ru.moviedbapp.slavicsky.data.Movie
import ru.moviedbapp.slavicsky.RecyclerViewAdapter
import ru.moviedbapp.slavicsky.service.MoviesApiService
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.moviedbapp.slavicsky.data.MovieResult
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    internal lateinit var movies: ArrayList<MovieResult>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ru.moviedbapp.R.layout.activity_main)

        movies = ArrayList()
        val recyclerView = recyclerview_id

        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter(this@MainActivity, movies)
        }
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        getPopularMovies()
    }

    private fun getPopularMovies() {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MoviesApiService::class.java)
        service.getPopularMovies(object : Callback<MovieResult> {
            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
                Toast.makeText(this@MainActivity, "An error occurred during networking", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {

            }
        })
    }
}
