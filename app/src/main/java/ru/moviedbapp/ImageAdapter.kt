package ru.moviedbapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

import com.squareup.picasso.Picasso

class ImageAdapter(private val context: Context)//        inflater = LayoutInflater.from(context);
    : BaseAdapter() {

    var imageUrls = arrayOf(
        "https://klike.net/uploads/posts/2019-01/1547367959_4.jpg",
        "https://klike.net/uploads/posts/2019-01/1547367940_5.jpg",
        "https://klike.net/uploads/posts/2019-01/1547367988_6.jpg",
        "https://cdn.gratisography.com/photos/440H.jpg",
        "https://cdn.gratisography.com/photos/441H.jpg",
        "https://cdn.gratisography.com/photos/442H.jpg",
        "https://cdn.gratisography.com/photos/443H.jpg",
        "https://cdn.gratisography.com/photos/444H.jpg",
        "https://cdn.gratisography.com/photos/445H.jpg",
        "https://cdn.gratisography.com/photos/446H.jpg"
    )

    override fun getCount(): Int {
        return imageUrls.size
    }

    override fun getItem(i: Int): Any {
        return imageUrls[i]
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View? {
        var view = view
        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.gridview_item, viewGroup, false)
        }

        Picasso.get()
            .load(imageUrls[i]).placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .fit()
            .centerCrop()
            .into(view as ImageView?)

        return view
    }
}

