package com.androdevdk.camerax_mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.androdevdk.camerax_mvvm.R
import com.androdevdk.camerax_mvvm.model.Image

class CameraImageAdapter : RecyclerView.Adapter<CameraImageAdapter.ViewHolder> {
    lateinit var context: Context
    lateinit var mList: List<Image>
    lateinit var activity: CameraImageAdapter.ItemClicked

    constructor()
    constructor(context: Context, mList: List<Image>) : this() {
        this.context = context
        this.mList = mList
        activity = context as ItemClicked
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_list, parent, false)
        return CameraImageAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]
        holder.imageView.setImageResource(itemsViewModel.image)
        holder.itemView.setOnClickListener() {
            activity.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_img)
    }

    public interface ItemClicked {
        fun onItemClicked(index: Int)
    }
}