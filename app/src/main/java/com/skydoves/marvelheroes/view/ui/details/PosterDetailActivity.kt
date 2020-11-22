package com.skydoves.marvelheroes.view.ui.details

import android.content.Context
import android.os.Bundle
import com.skydoves.bundler.bundle
import com.skydoves.bundler.intentOf
import com.skydoves.marvelheroes.R
import com.skydoves.marvelheroes.base.DatabindingActivity
import com.skydoves.marvelheroes.databinding.ActivityPosterDetailBinding
import com.skydoves.marvelheroes.extensions.onTransformationEndContainerApplyParams
import com.skydoves.marvelheroes.model.Poster
import com.skydoves.marvelheroes.view.adapter.PosterSeriesAdapter
import com.skydoves.transformationlayout.TransformationCompat
import com.skydoves.transformationlayout.TransformationLayout
import org.koin.android.viewmodel.ext.android.getViewModel

class PosterDetailActivity : DatabindingActivity() {

  private val binding: ActivityPosterDetailBinding by binding(R.layout.activity_poster_detail)
  private val posterId: Long by bundle(EXTRA_POSTER_ID, 0)

  override fun onCreate(savedInstanceState: Bundle?) {
    onTransformationEndContainerApplyParams()
    super.onCreate(savedInstanceState)
    binding.apply {
      poster = getViewModel<PosterDetailViewModel>().getPoster(posterId)
      lifecycleOwner = this@PosterDetailActivity
      dispatcher = this@PosterDetailActivity
      adapter = PosterSeriesAdapter(plot)
    }
  }

  companion object {
    private const val EXTRA_POSTER_ID = "EXTRA_POSTER_ID"

    fun startActivity(
      context: Context,
      transformationLayout: TransformationLayout,
      poster: Poster
    ) = context.intentOf<PosterDetailActivity> {
      putExtra(EXTRA_POSTER_ID to poster.id)
      TransformationCompat.startActivity(transformationLayout, intent)
    }
  }
}
