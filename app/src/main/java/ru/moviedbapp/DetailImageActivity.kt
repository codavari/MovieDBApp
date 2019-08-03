package ru.moviedbapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_image.*
import java.util.Objects
import androidx.core.app.NotificationCompat.getExtras



class DetailImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)

        val intent = intent

        val position = intent.extras!!.getInt("position")

        val imageAdapter = ImageAdapter(this)

        val detailImageView = detail_imageView

        Picasso.get()
            .load(imageAdapter.imageUrls[position]).placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .fit()
            .centerInside()
            .into(detailImageView)

    }
}