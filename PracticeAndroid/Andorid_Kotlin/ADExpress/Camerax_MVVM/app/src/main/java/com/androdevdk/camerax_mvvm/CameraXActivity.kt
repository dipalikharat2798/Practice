package com.androdevdk.camerax_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.fragment.app.FragmentManager
import com.androdevdk.camerax_mvvm.adapter.CameraImageAdapter
import com.androdevdk.camerax_mvvm.databinding.ActivityCameraXBinding
import com.androdevdk.camerax_mvvm.fragment.CameraXFragment
import com.androdevdk.camerax_mvvm.fragment.PhotoListFragment
import com.androdevdk.camerax_mvvm.test.fragments.SecondFragment

class CameraXActivity : AppCompatActivity(), CameraImageAdapter.ItemClicked {
    private lateinit var activityCameraXBinding: ActivityCameraXBinding
    private lateinit var cameraXFragment: CameraXFragment
    private lateinit var photoListFragment: PhotoListFragment
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCameraXBinding = ActivityCameraXBinding.inflate(layoutInflater)
        setContentView(activityCameraXBinding.root)
        fragmentManager = this.supportFragmentManager
        cameraXFragment = fragmentManager.findFragmentById(R.id.camerax_frag) as CameraXFragment
        photoListFragment = fragmentManager.findFragmentById(R.id.photolist_frag) as PhotoListFragment
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onItemClicked(index: Int) {
        cameraXFragment.setImage(index)
    }

    public fun senddatatoPhotolist(index: Int) {
       photoListFragment.toast(index)
    }
}