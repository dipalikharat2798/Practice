package com.androdevdk.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import java.io.File

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), LeftFragment.LeftData, RightFragment.RightData {
    lateinit var fragmentManager: FragmentManager
    lateinit var rightFragment: RightFragment
    lateinit var leftFragment: LeftFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = this.supportFragmentManager
        rightFragment = fragmentManager.findFragmentById(R.id.fragment1) as RightFragment
        leftFragment = fragmentManager.findFragmentById(R.id.fragment) as LeftFragment
    }


    override fun sendLeftdata(name: String) {
        rightFragment.setRightData(name.toString())
    }

    override fun sendrightdata(rname: String) {
        leftFragment.setLDataToRightfrag(rname + "")
    }
    companion object {

        /** Use external media if it is available, our app's file directory otherwise */
        fun getOutputDirectory(context: Context): File {
            val appContext = context.applicationContext
            val mediaDir = context.externalMediaDirs.firstOrNull()?.let {
                File(it, appContext.resources.getString(R.string.app_name)).apply { mkdirs() }
            }
            return if (mediaDir != null && mediaDir.exists())
                mediaDir else appContext.filesDir
        }
    }
}