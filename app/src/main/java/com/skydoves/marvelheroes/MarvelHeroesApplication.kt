@file:Suppress("unused")

package com.skydoves.marvelheroes

import android.app.Application
import com.skydoves.marvelheroes.di.networkModule
import com.skydoves.marvelheroes.di.persistenceModule
import com.skydoves.marvelheroes.di.repositoryModule
import com.skydoves.marvelheroes.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MarvelHeroesApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@MarvelHeroesApplication)
      modules(networkModule)
      modules(persistenceModule)
      modules(repositoryModule)
      modules(viewModelModule)
    }

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
    }
  }
}
