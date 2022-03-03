package com.androdevdk.camerax_mvvm.test.fragments

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.androdevdk.camerax_mvvm.ApplicationClass
import com.androdevdk.camerax_mvvm.R
import com.androdevdk.camerax_mvvm.databinding.FragmentCameraBinding
import com.androdevdk.camerax_mvvm.databinding.FragmentFirstBinding
import com.androdevdk.camerax_mvvm.test.TestActivity
import com.androdevdk.camerax_mvvm.test.adapter.PersonAdapter


class FirstFragment : Fragment() {
    private var _fragmentFirstBinding: FragmentFirstBinding? = null
    private val fragmentFirstBinding get() = _fragmentFirstBinding!!
    var adapter: PersonAdapter? = null
    lateinit var applicationClass: ApplicationClass
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentFirstBinding = FragmentFirstBinding.inflate(inflater, container, false)
        return fragmentFirstBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applicationClass = ApplicationClass.instance
        fragmentFirstBinding.recycler.layoutManager = LinearLayoutManager(requireContext())
        adapter = PersonAdapter(
            requireContext(),
            applicationClass.data
        )
        fragmentFirstBinding.recycler.adapter = adapter
    }

    companion object {

    }
}