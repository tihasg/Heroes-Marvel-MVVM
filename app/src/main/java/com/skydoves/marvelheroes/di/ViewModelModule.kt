package com.skydoves.marvelheroes.di

import com.skydoves.marvelheroes.view.ui.details.PosterDetailViewModel
import com.skydoves.marvelheroes.view.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

  viewModel { MainViewModel(get()) }

  viewModel { PosterDetailViewModel(get()) }
}
