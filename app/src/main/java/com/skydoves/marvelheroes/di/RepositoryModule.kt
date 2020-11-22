package com.skydoves.marvelheroes.di

import com.skydoves.marvelheroes.repository.DetailRepository
import com.skydoves.marvelheroes.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {

  single { MainRepository(get(), get(), get()) }

  single { DetailRepository(get()) }
}
