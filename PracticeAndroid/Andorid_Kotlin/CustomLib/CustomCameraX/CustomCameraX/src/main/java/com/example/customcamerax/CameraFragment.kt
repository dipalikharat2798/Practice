package com.example.customcamerax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.customcamerax.databinding.FragmentCameraBinding

class CameraFragment : Fragment() {
    private var _fragmentCameraBind: FragmentCameraBinding? = null
    private val fragmentCameraBinding get() = _fragmentCameraBind!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentCameraBind= FragmentCameraBinding.inflate(inflater,container,false)
        return fragmentCameraBinding.root
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentCameraBinding.viewFinder.post()
    }

}