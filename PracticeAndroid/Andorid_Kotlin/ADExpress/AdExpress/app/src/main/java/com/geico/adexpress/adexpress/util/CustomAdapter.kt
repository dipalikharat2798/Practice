package com.geico.adexpress.adexpress.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.geico.adexpress.adexpress.R


class CustomAdapter(private val mList: List<String>,private val context:Context) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        if (position == mList.size/2){
            holder.setIsInTheMiddle(true)
            holder.textView.text = context.getString(R.string.middle)
        }else {
            holder.setIsInTheMiddle(false)
            // sets the text to the textview from our itemHolder class
            holder.textView.text = ItemsViewModel
        }

        holder.textView.setOnClickListener {
            Toast.makeText(context,"position"+position, Toast.LENGTH_SHORT).show()
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textView: TextView = itemView.findViewById(R.id.textView)

        private var mIsInTheMiddle = false


        fun getIsInTheMiddle(): Boolean {
            return mIsInTheMiddle
        }

        fun setIsInTheMiddle(isInTheMiddle: Boolean) {
            mIsInTheMiddle = isInTheMiddle
        }
    }
}
