package com.startuph.startup.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.startuph.startup.R
import com.startuph.startup.model.ItemDataModel

class ItemListAdapter : RecyclerView.Adapter<ItemListAdapter.ViewHolder> {
    lateinit var context: Context
    var mList: MutableList<ItemDataModel> = mutableListOf<ItemDataModel>()
    lateinit var activity: ItemListAdapter.ImageItemClicked

    constructor()
    constructor(
        context: Context,
        mList: MutableList<ItemDataModel>,
    ) : this() {
        this.context = context
        this.mList = mList
        this.activity = context as ImageItemClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.itemlist_recycler, parent, false)
        return ItemListAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemDataModel = mList[position]
        holder.imageView.setImageResource(itemDataModel.image)
        holder.header.setText(itemDataModel.textHeader)
        holder.description.setText(itemDataModel.description)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_iv)
        val header: TextView = itemView.findViewById(R.id.header_tv)
        val description: TextView = itemView.findViewById(R.id.description_tv)
    }

    public interface ImageItemClicked {
        fun onImageItemClicked(index: Int, catureaStatus: Boolean)
        //fun onClick(pos: Int, aView: View)
    }
}