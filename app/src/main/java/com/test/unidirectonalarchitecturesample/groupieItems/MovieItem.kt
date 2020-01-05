package com.test.unidirectonalarchitecturesample.groupieItems


import android.content.Context
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.test.unidirectonalarchitecturesample.R
import com.test.unidirectonalarchitecturesample.models.Result
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.movielist.view.*


class MovieItem(private val movie:Result,private val ctx:Context?): Item(){

    override fun getLayout(): Int {
        return R.layout.movielist
    }
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
      viewHolder.itemView.movieName.text=movie.title
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+movie.poster_path).resize(200, 200)
            .centerCrop().into(viewHolder.itemView.moviepic)

        viewHolder.itemView.setOnClickListener {
          Toast.makeText(ctx,viewHolder.itemView.movieName.text,Toast.LENGTH_LONG).show()
        }
    }


}
