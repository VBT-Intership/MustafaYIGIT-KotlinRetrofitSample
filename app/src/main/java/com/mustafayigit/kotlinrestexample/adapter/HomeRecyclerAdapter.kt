package com.mustafayigit.kotlinrestexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mustafayigit.kotlinrestexample.R
import com.mustafayigit.kotlinrestexample.data.response.Version
import kotlinx.android.synthetic.main.adapter_item_version.view.*


class HomeRecyclerAdapter(
    private val onClickEvent: (version: Version) -> Unit
) : ListAdapter<Version, HomeViewHolder>(AdapterCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HomeViewHolder(parent, onClickEvent)

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) =
        holder.bind(getItem(position))

}

class AdapterCallback : DiffUtil.ItemCallback<Version>() {
    override fun areItemsTheSame(oldItem: Version, newItem: Version) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Version, newItem: Version) = oldItem.id == newItem.id
}

class HomeViewHolder(
    container: ViewGroup,
    private val onClickEvent: (version: Version) -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(container.context)
        .inflate(
            R.layout.adapter_item_version,
            container,
            false
        )
) {
    fun bind(version: Version) {
        itemView.apply {
            Glide.with(context)
                .load(version.image)
                .into(versionImage)

            versionName.text = version.name
            versionNumber.text = version.number.toString()

            itemView.setOnClickListener { onClickEvent(version) }

        }
    }
}