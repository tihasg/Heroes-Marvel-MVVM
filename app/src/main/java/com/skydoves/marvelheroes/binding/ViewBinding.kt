package com.skydoves.marvelheroes.binding

import android.graphics.drawable.Drawable
import android.view.View
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.skydoves.androidveil.VeilLayout

@BindingAdapter("loadImage")
fun bindLoadImage(view: AppCompatImageView, url: String) {
  Glide.with(view.context)
    .load(url)
    .into(view)
}

@BindingAdapter("withVeil", "loadImageWithVeil")
fun bindLoadImageWithVeil(view: AppCompatImageView, veilLayout: VeilLayout, url: String) {
  Glide.with(view.context)
    .load(url)
    .listener(
      object : RequestListener<Drawable> {
        override fun onLoadFailed(
          e: GlideException?,
          model: Any?,
          target: Target<Drawable>?,
          isFirstResource: Boolean
        ): Boolean {
          veilLayout.unVeil()
          return false
        }

        override fun onResourceReady(
          resource: Drawable?,
          model: Any?,
          target: Target<Drawable>?,
          dataSource: DataSource?,
          isFirstResource: Boolean
        ): Boolean {
          veilLayout.unVeil()
          return false
        }
      }
    )
    .into(view)
}

@BindingAdapter("onBackPressed")
fun bindOnBackPressed(view: View, onBackPressedDispatcherOwner: OnBackPressedDispatcherOwner) {
  view.setOnClickListener { onBackPressedDispatcherOwner.onBackPressedDispatcher.onBackPressed() }
}
