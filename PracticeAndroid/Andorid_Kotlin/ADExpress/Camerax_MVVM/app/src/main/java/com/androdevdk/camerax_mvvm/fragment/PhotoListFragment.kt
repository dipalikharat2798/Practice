package com.androdevdk.camerax_mvvm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.androdevdk.camerax_mvvm.ApplicationClass
import com.androdevdk.camerax_mvvm.adapter.CameraImageAdapter
import com.androdevdk.camerax_mvvm.databinding.FragmentPhotoListBinding

class PhotoListFragment : Fragment() {
    private var _fragmentPhotoListBinding: FragmentPhotoListBinding? = null
    private val fragmentPhotoListBinding get() = _fragmentPhotoListBinding!!
    var adapter: CameraImageAdapter? = null
    lateinit var applicationClass: ApplicationClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentPhotoListBinding = FragmentPhotoListBinding.inflate(inflater, container, false)
        return fragmentPhotoListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applicationClass = ApplicationClass.instance
        fragmentPhotoListBinding.recycler.layoutManager = LinearLayoutManager(requireContext())
        adapter = CameraImageAdapter(requireContext(), applicationClass.imageData)
        fragmentPhotoListBinding.recycler.adapter = adapter
    }

    public fun notifyAdapter() {
        adapter?.notifyDataSetChanged()
    }

    public fun toast(index:Int){
        Toast.makeText(requireContext(),"Index recieved in Rightfragment :"+index,Toast.LENGTH_SHORT).show()

    }
    override fun onDestroy() {
        _fragmentPhotoListBinding = null
        super.onDestroy()
    }

    companion object {

    }
}