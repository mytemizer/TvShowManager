package com.example.tvshowmanager.ui.listtvshow

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tvshowmanager.R
import com.example.tvshowmanager.databinding.ItemTvShowListItemBinding
import com.example.tvshowmanager.util.gone
import com.example.tvshowmanager.util.makeTextColored

class TvShowListAdapter : ListAdapter<TvShowViewState, TvShowViewHolder>(DIFF_CALLBACK) {


    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TvShowViewState> =
            object : DiffUtil.ItemCallback<TvShowViewState>() {
                override fun areItemsTheSame(
                    oldItem: TvShowViewState,
                    newItem: TvShowViewState,
                ): Boolean {
                    return oldItem.areItemsTheSame(newItem)
                }

                override fun areContentsTheSame(
                    oldItem: TvShowViewState,
                    newItem: TvShowViewState,
                ): Boolean {
                    return oldItem.areContentsTheSame(newItem)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding =
            ItemTvShowListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(item)
        }
    }

}


class TvShowViewHolder(
    private val binding: ItemTvShowListItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TvShowViewState) {
        binding.apply {
            tvTitle.text = item.title

            val context = tvReleaseDate.context

            if (item.releaseDate.isEmpty().not()) {
                val boldReleaseDate = context.getString(R.string.tv_show_item_release_date_bold)
                val releaseDateText = String.format(context.getString(R.string.tv_show_item_release_date), item.releaseDate)
                tvReleaseDate.makeTextColored(releaseDateText, 0, boldReleaseDate.length, Color.BLACK)

            } else tvReleaseDate.gone()

            item.seasons?.let {
                val boldSeasonsText = context.getString(R.string.tv_show_item_seasons_bold)
                val seasonsText = String.format(context.getString(R.string.tv_show_item_seasons), it.toInt())
                tvSeasons.makeTextColored(seasonsText, 0, boldSeasonsText.length, Color.BLACK)
            } ?: tvSeasons.gone()
        }
    }
}