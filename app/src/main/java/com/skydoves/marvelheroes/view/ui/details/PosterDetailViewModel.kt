package com.skydoves.marvelheroes.view.ui.details

import com.skydoves.marvelheroes.base.LiveCoroutinesViewModel
import com.skydoves.marvelheroes.repository.DetailRepository

class PosterDetailViewModel(
  private val repository: DetailRepository
) : LiveCoroutinesViewModel() {

  fun getPoster(id: Long) = repository.getPosterById(id)
}
