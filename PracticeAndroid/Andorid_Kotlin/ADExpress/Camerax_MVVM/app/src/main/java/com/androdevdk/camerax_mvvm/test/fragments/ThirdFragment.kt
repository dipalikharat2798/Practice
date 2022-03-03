package com.androdevdk.camerax_mvvm.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androdevdk.camerax_mvvm.R
import com.androdevdk.camerax_mvvm.databinding.FragmentCameraBinding
import com.androdevdk.camerax_mvvm.databinding.FragmentThirdBinding
import com.androdevdk.camerax_mvvm.test.adapter.PersonAdapter

class ThirdFragment : Fragment() {
    private var _fragmentThirdBinding: FragmentThirdBinding? = null
    private val fragmentThirdBinding get() = _fragmentThirdBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentThirdBinding = FragmentThirdBinding.inflate(inflater, container, false)
        return fragmentThirdBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    companion object {

    }
}