package ru.moviedbapp.slavicsky

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import ru.moviedbapp.R
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filmList = ArrayList<Film>().apply {
            add(0, Film("aaa", 2.0, "nge", R.drawable.asuka1))
            add(0, Film("aaa", 8.0, "nge", R.drawable.asuka2))
            add(0, Film("aaa", 7.0, "nge", R.drawable.asuka3))
        }

        val recyclerView = recyclerview_id

        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter(this@MainActivity, filmList)
        }
        recyclerView.layoutManager = GridLayoutManager(this, 3)
    }
}
