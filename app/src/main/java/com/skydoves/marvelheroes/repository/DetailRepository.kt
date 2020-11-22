package com.skydoves.marvelheroes.repository

import com.skydoves.marvelheroes.persistence.PosterDao

class DetailRepository constructor(
  private val posterDao: PosterDao
) : Repository {

  fun getPosterById(id: Long) = posterDao.getPoster(id)
}
