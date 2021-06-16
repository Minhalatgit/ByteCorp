package com.bytecorp.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter(private val context: Context, private val list: ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(LayoutInflater.from(context).inflate(R.layout.post_item, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list[position]
        Picasso.get()
            .load(item.postImage)
            .placeholder(R.drawable.google_icon)
            .into(holder.itemView.postImage)
        holder.itemView.postHeading.text = item.postHeading
        holder.itemView.postContent.text = item.postContent
    }
}