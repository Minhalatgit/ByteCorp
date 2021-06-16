package com.bytecorp.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class ItemAdapter(private val context: Context, private val list: ArrayList<Item>) :
    RecyclerView.Adapter<ItemAdapter.Holder>() {

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        Holder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = list[position]
        Picasso.get()
            .load(item.imageUrl)
            .placeholder(R.drawable.google_icon)
            .into(holder.itemView.itemImage)
        holder.itemView.itemName.text = item.name
        holder.itemView.itemPrice.text = item.price
    }
}