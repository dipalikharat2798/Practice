package com.androdevdk.test1app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

internal class CustomAdapter(private var itemsList: List<String>,private var context:Context) :
    RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
     //   var itemTextView: TextView = view.findViewById(R.id.itemTextView)
        private var textView: TextView? = null

        // We'll use this field to showcase matching the holder from the test.
        private var mIsInTheMiddle = false

        fun ViewHolder(v: View) {
            textView = v.findViewById<View>(R.id.itemTextView) as TextView
        }

        fun getTextView(): TextView? {
            return textView
        }

        fun getIsInTheMiddle(): Boolean {
            return mIsInTheMiddle
        }

        fun setIsInTheMiddle(isInTheMiddle: Boolean) {
            mIsInTheMiddle = isInTheMiddle
        }
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(viewHolder: MyViewHolder, position: Int) {
        if (position == itemsList.size / 2 /* calculate middle element position */) {
            viewHolder.setIsInTheMiddle(true)
            viewHolder.getTextView()?.setText(context.getResources().getString(R.string.middle))
        } else {
            viewHolder.setIsInTheMiddle(false)
            viewHolder.getTextView()?.setText(itemsList.get(position))
        }
    }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}