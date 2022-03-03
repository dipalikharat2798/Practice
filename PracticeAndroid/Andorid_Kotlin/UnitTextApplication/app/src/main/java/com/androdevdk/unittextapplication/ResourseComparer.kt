package com.androdevdk.unittextapplication

import android.content.Context

class ResourseComparer {
    fun isEqual(context: Context, resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}