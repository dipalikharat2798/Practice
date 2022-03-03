package com.androdevdk.camerax_mvvm.test.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androdevdk.camerax_mvvm.ApplicationClass
import com.androdevdk.camerax_mvvm.R
import com.androdevdk.camerax_mvvm.databinding.FragmentSecondBinding
import com.androdevdk.camerax_mvvm.databinding.FragmentThirdBinding
import com.androdevdk.camerax_mvvm.test.TestActivity

class SecondFragment : Fragment() {
    private var _fragmentSecondBinding: FragmentSecondBinding? = null
    private val fragmentSecondBinding get() = _fragmentSecondBinding!!
    lateinit var applicationClass: ApplicationClass
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentSecondBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return fragmentSecondBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applicationClass=ApplicationClass.instance
    }

    public fun notifydata(index:Int){
        fragmentSecondBinding.lastnameTv1.setText(applicationClass.data[index].lastname+" updated")
        fragmentSecondBinding.nameTv1.setText(applicationClass.data[index].name+" updated")
    }
    companion object {
    }
}