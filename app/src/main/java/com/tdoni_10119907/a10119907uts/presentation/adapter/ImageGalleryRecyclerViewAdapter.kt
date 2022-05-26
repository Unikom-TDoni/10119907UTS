package com.tdoni_10119907.a10119907uts.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tdoni_10119907.a10119907uts.R
import com.tdoni_10119907.a10119907uts.databinding.ItemPhotoGalleryBinding

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class ImageGalleryRecyclerViewAdapter :
    RecyclerView.Adapter<ImageGalleryRecyclerViewAdapter.ViewHolder>() {

    private val imageGalleryResources = arrayOf(
        R.drawable.img_gallery_1,
        R.drawable.img_gallery_2,
        R.drawable.img_gallery_3,
        R.drawable.img_gallery_4,
        R.drawable.img_gallery_5,
        R.drawable.img_gallery_6,
        R.drawable.img_gallery_7,
        R.drawable.img_gallery_8,
    )

    inner class ViewHolder(val binding: ItemPhotoGalleryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemPhotoGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding.imgViewPhoto.setImageResource(imageGalleryResources[position])
    }

    override fun getItemCount(): Int = 8
}