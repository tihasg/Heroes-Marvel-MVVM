package com.skydoves.marvelheroes.view.ui.main

import android.os.Bundle
import com.skydoves.marvelheroes.R
import com.skydoves.marvelheroes.base.DatabindingActivity
import com.skydoves.marvelheroes.databinding.ActivityMainBinding
import com.skydoves.marvelheroes.view.adapter.PosterAdapter
import com.skydoves.transformationlayout.onTransformationStartContainer
import org.koin.android.viewmodel.ext.android.getViewModel

class MainActivity : DatabindingActivity() {

  private val binding: ActivityMainBinding by binding(R.layout.activity_main)

  override fun onCreate(savedInstanceState: Bundle?) {
    onTransformationStartContainer()
    super.onCreate(savedInstanceState)
    binding.apply {
      lifecycleOwner = this@MainActivity
      adapter = PosterAdapter()
      vm = getViewModel()
    }
  }
}
