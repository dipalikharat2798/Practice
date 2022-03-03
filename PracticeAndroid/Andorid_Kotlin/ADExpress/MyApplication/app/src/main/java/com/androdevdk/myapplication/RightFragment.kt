package com.androdevdk.myapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


class RightFragment : Fragment() {
    lateinit var rightData: RightData
    lateinit var textView: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_right, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        rightData = context as RightData
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView = view.findViewById<TextView>(R.id.tvr)
        textView.setOnClickListener(listener)
    }

    public fun setRightData(name: String) {
        textView.setText(name + "")
    }

    public interface RightData {
        fun sendrightdata(rname: String)
    }
    val listener= View.OnClickListener { view ->
        when (view.getId()) {
            R.id.tvr -> {
                Toast.makeText(requireContext(), "right", Toast.LENGTH_SHORT).show()
                rightData.sendrightdata("RightToLeft")
            }
        }
    }
}