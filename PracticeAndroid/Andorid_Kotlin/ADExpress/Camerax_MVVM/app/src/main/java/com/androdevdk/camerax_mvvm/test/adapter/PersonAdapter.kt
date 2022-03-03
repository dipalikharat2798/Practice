package com.androdevdk.camerax_mvvm.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.androdevdk.camerax_mvvm.R
import com.androdevdk.camerax_mvvm.test.TestActivity
import com.androdevdk.camerax_mvvm.test.models.ItemModel

class PersonAdapter(
) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {
    lateinit var context: Context
    lateinit var mList: List<ItemModel>
    lateinit var activity: ItemClicked

    constructor(context: Context, mList: ArrayList<ItemModel>) : this() {
        this.context = context
        this.mList = mList
        activity = context as ItemClicked
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.itemimageview_tv)
        val nameitem: TextView = itemView.findViewById(R.id.itemname_tv)
        val lastname: TextView = itemView.findViewById(R.id.itemsurname_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return PersonAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.nameitem.setText(ItemsViewModel.name)
        holder.lastname.setText(ItemsViewModel.lastname)
        holder.itemView.setOnClickListener() {
            activity.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    public interface ItemClicked {
        fun onItemClicked(index: Int)
    }
}