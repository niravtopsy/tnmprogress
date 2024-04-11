package com.topsniravm.library.progressbar

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.topsniravm.library.databinding.CustomProgressbarBinding

class TNMProgressBar(
    private val mActivity: Activity, private val imageURL: String?,
    private val imageDrawable: Int?, private val defaultImageDrawable: Int
) : Dialog(mActivity) {

    private lateinit var binding: CustomProgressbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        CustomProgressbarBinding.inflate(layoutInflater)

        setContentView(binding.root)

        if (imageURL != null) {
            if (imageURL.isNotEmpty()) {
                Glide.with(mActivity)
                    .load(imageURL)
                    .apply(
                        RequestOptions.placeholderOf(defaultImageDrawable)
                            .error(defaultImageDrawable)
                    )
                    .into(binding.imageProgressAppIcon)

            } else {
                if (imageDrawable != null) {
                    binding.imageProgressAppIcon.setImageResource(imageDrawable)
                } else {
                    binding.imageProgressAppIcon.setImageResource(defaultImageDrawable)
                }
            }
        } else {
            if (imageDrawable != null) {
                binding.imageProgressAppIcon.setImageResource(imageDrawable)
            } else {
                binding.imageProgressAppIcon.setImageResource(defaultImageDrawable)
            }
        }

    }

    init {
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        setCancelable(false)
    }
}