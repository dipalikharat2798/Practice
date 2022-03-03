package com.androdevdk.camerax_mvvm.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import com.androdevdk.camerax_mvvm.ApplicationClass
import com.androdevdk.camerax_mvvm.R
import com.androdevdk.camerax_mvvm.databinding.ActivityMainBinding
import com.androdevdk.camerax_mvvm.databinding.ActivityTestBinding
import com.androdevdk.camerax_mvvm.test.adapter.PersonAdapter
import com.androdevdk.camerax_mvvm.test.fragments.SecondFragment

class TestActivity : AppCompatActivity(), PersonAdapter.ItemClicked {
    private lateinit var activityTestBinding: ActivityTestBinding
    lateinit var applicationClass: ApplicationClass
    lateinit var secondFragment: SecondFragment
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityTestBinding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(activityTestBinding.root)

        fragmentManager = this.supportFragmentManager
        secondFragment = fragmentManager.findFragmentById(R.id.fragment2) as SecondFragment
    }

    override fun onItemClicked(index: Int) {
        applicationClass = ApplicationClass.instance
        activityTestBinding.fragment2.findViewById<TextView>(R.id.name_tv1)
            .setText(applicationClass.data[index].name)
//        activityTestBinding.fragment2.findViewById<TextView>(R.id.lastname_tv1)
//            .setText(applicationClass.data[index].lastname)
//        activityTestBinding.fragment2.findViewById<ImageView>(R.id.imageView1)
//            .setImageResource((applicationClass.data[index].image))
        // Log.d("TAG", "onItemClicked: "+applicationClass.data[index].name)
        secondFragment.notifydata(index)
    }
}