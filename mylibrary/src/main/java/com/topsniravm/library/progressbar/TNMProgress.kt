package com.topsniravm.library.progressbar

import android.app.Activity

class TNMProgress {

    private var progressBar: TNMProgressBar? = null

    fun show(
        mActivity: Activity, imageURL: String?,
        imageDrawable: Int?, defaultImageDrawable: Int, shapeType: Int
    ) {
        try {
            if (progressBar != null) {
                if (progressBar!!.isShowing) {
                    //
                } else {
                    progressBar!!.show()
                }
            } else {
                if (!mActivity.isFinishing) {
                    progressBar =
                        TNMProgressBar(mActivity, imageURL, imageDrawable, defaultImageDrawable)
                    progressBar!!.show()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun hide() {
        try {
            try {
                if (progressBar != null && progressBar!!.isShowing) {
                    progressBar!!.dismiss()
                }
            } catch (e: IllegalArgumentException) {
                // Handle or log or ignore
            } catch (e: Exception) {
                // Handle or log or ignore
            } finally {
                progressBar = null
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}