package com.skydoves.marvelheroes.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PosterDetails(
  val id: Long,
  val rootId: Long,
  val name: String,
  val plot: String,
  val poster: String
) : Parcelable
