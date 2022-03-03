package com.androdevdk.camerax_mvvm

import android.app.Application
import android.content.ClipData
import com.androdevdk.camerax_mvvm.model.Image
import com.androdevdk.camerax_mvvm.test.models.ItemModel

class ApplicationClass : Application() {
    public val data = ArrayList<ItemModel>()
    public val imageData = ArrayList<Image>()

    override fun onCreate() {
        super.onCreate()
        instance=this
        data.add(ItemModel(R.drawable.overlayimg, "one", "one"))
        data.add(ItemModel(R.drawable.thankyou, "two", "two"))
        data.add(ItemModel(R.drawable.overlayimg, "three", "three"))

        imageData.add(Image(R.drawable.overlayimg))
        imageData.add(Image(R.drawable.square_overlay))
        imageData.add(Image(R.drawable.overlayimg))
        imageData.add(Image(R.drawable.square_overlay))
        imageData.add(Image(R.drawable.overlayimg))
    }
    companion object {
        lateinit var instance: ApplicationClass
            private set
    }
}