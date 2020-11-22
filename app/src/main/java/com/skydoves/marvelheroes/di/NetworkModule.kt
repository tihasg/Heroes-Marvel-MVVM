package com.skydoves.marvelheroes.di

import com.skydoves.marvelheroes.model.Poster
import com.skydoves.marvelheroes.network.MarvelClient
import com.skydoves.marvelheroes.network.MarvelService
import com.skydoves.marvelheroes.network.RequestInterceptor
import com.skydoves.sandwich.ResponseDataSource
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

  single {
    OkHttpClient.Builder()
      .addInterceptor(RequestInterceptor())
      .build()
  }

  single {
    Retrofit.Builder()
      .client(get<OkHttpClient>())
      .baseUrl("https://gist.githubusercontent.com/skydoves/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()
  }

  single { get<Retrofit>().create(MarvelService::class.java) }

  single { MarvelClient(get()) }

  single { ResponseDataSource<List<Poster>>() }
}
