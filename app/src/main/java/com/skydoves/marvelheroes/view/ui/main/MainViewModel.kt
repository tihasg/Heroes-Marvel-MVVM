package com.skydoves.marvelheroes.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.skydoves.marvelheroes.base.LiveCoroutinesViewModel
import com.skydoves.marvelheroes.model.Poster
import com.skydoves.marvelheroes.repository.MainRepository
import timber.log.Timber

class MainViewModel constructor(
  private val mainRepository: MainRepository
) : LiveCoroutinesViewModel() {

  private var posterFetchingLiveData: MutableLiveData<Boolean> = MutableLiveData(true)
  val posterListLiveData: LiveData<List<Poster>>

  private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
  val toastLiveData: LiveData<String> get() = _toastLiveData

  init {
    Timber.d("injection MainViewModel")

    posterListLiveData = posterFetchingLiveData.switchMap {
      launchOnViewModelScope {
        mainRepository.loadMarvelPosters(disposables) { _toastLiveData.postValue(it) }
      }
    }
  }
}
