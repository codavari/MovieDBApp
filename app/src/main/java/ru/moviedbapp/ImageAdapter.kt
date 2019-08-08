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
        "https://i.pinimg.com/564x/52/d7/83/52d783fd3ccc89812e01cc0427a4678f.jpg",
        "https://i.pinimg.com/564x/32/a3/4d/32a34d46a5c8f8e43c3035b0086e5f11.jpg",
        "https://i.pinimg.com/564x/ea/2f/c1/ea2fc13a941e18030cb3f23f7aa1687c.jpg",
        "https://ih1.redbubble.net/image.555630533.9884/mp,840x830,matte,f8f8f8,t-pad,750x1000,f8f8f8.jpg",
        "https://cdn.gratisography.com/photos/446H.jpg",
        "https://picstatio.com/large/701953/lying-down-soryu-asuka-langley.jpg",
        "https://pp.userapi.com/c848632/v848632231/1e0e63/whZ3A_ANtok.jpg",
        "https://cdn.imgbin.com/21/15/9/imgbin-asuka-langley-soryu-anime-evangelion-anime-PY4fTxcJb1EggN0aMgqMT0qhg.jpg",
        "https://pp.userapi.com/c855016/v855016199/8f58b/7ArD6USyow0.jpg"
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

