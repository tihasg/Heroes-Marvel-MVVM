package com.skydoves.marvelheroes.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Poster(
  @PrimaryKey val id: Long,
  val name: String,
  val color: String,
  val quote: String,
  val poster: String,
  val details: List<PosterDetails>
) : Parcelable
