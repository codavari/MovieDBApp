package ru.moviedbapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridView = images_gridview

        gridView.adapter = ImageAdapter(this)

        gridView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this.applicationContext, DetailImageActivity::class.java).also {
                it.putExtra("position", i)
                startActivity(it)
            }
        }
    }
}
