package ru.moviedbapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filmList = ArrayList<Film>().apply {

            add(0, Film("jopa", 8.8, "jopa", R.drawable.asuka1))
            add(1, Film("jopa", 8.8, "jopa", R.drawable.asuka2))
            add(2, Film("jopa", 8.8, "jopa", R.drawable.asuka3))
            add(3, Film("jopa", 8.8, "jopa", R.drawable.asuka4))
            add(4, Film("jopa", 8.8, "jopa", R.drawable.asuka5))
            add(5, Film("jopa", 8.8, "jopa", R.drawable.asuka6))
            add(6, Film("jopa", 8.8, "jopa", R.drawable.asuka7))
        }

        val recyclerView = recyclerview_id

        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerViewAdapter(this@MainActivity, filmList)
        }
        recyclerView.layoutManager = GridLayoutManager(this, 3)
    }
}
