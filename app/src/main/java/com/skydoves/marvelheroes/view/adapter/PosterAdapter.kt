package com.skydoves.marvelheroes.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.skydoves.marvelheroes.R
import com.skydoves.marvelheroes.databinding.ItemPosterBinding
import com.skydoves.marvelheroes.model.Poster
import com.skydoves.marvelheroes.view.ui.details.PosterDetailActivity

class PosterAdapter : RecyclerView.Adapter<PosterAdapter.PosterViewHolder>() {

  private val items = mutableListOf<Poster>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val binding = DataBindingUtil.inflate<ItemPosterBinding>(
      inflater,
      R.layout.item_poster,
      parent,
      false
    )
    return PosterViewHolder(binding).apply {
      binding.root.setOnClickListener { view ->
        val position =
          adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return@setOnClickListener
        PosterDetailActivity.startActivity(
          view.context,
          binding.transformationLayout,
          items[position]
        )
      }
    }
  }

  fun updatePosterList(posters: List<Poster>) {
    items.clear()
    items.addAll(posters)
    notifyDataSetChanged()
  }

  override fun getItemCount(): Int = items.size

  override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
    holder.binding.apply {
      poster = items[position]
      veil = itemVeilLayout
      executePendingBindings()
    }
  }

  fun getPoster(index: Int): Poster = items[index]

  class PosterViewHolder(val binding: ItemPosterBinding) :
    RecyclerView.ViewHolder(binding.root)
}
