package com.tdoni_10119907.a10119907uts.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.tdoni_10119907.a10119907uts.R
import com.tdoni_10119907.a10119907uts.databinding.ItemMusicGalleryBinding
import com.tdoni_10119907.a10119907uts.domain.Music

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class MusicGalleryRecyclerViewAdapter(private val musics: Array<Music>) :
    RecyclerView.Adapter<MusicGalleryRecyclerViewAdapter.ViewHolder>() {

    private var lastActiveMusicId = -1
    private var lastActiveButtonImage: ShapeableImageView? = null

    inner class ViewHolder(val binding: ItemMusicGalleryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemMusicGalleryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        (position + 1).toString().also { binding.txtViewNumber.text = it }
        binding.txtViewSongName.text = musics[position].name
        binding.txtViewArtistName.text = musics[position].artistName
        binding.imgViewThumbnail.setImageResource(musics[position].thumbnail)
        binding.imgViewMediaControl.setOnClickListener {
            when (lastActiveMusicId) {
                position -> {
                    lastActiveMusicId = -1
                    lastActiveButtonImage = null
                    musics[position].music.pause()
                    binding.imgViewMediaControl.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                }
                else -> {
                    musics[position].music.start()
                    if (lastActiveMusicId != -1) musics[lastActiveMusicId].music.stop()

                    binding.imgViewMediaControl.setImageResource(R.drawable.ic_baseline_pause_24)
                    lastActiveButtonImage?.setImageResource(R.drawable.ic_baseline_play_arrow_24)

                    lastActiveButtonImage = binding.imgViewMediaControl
                    lastActiveMusicId = holder.adapterPosition
                }
            }
        }
    }

    override fun getItemCount(): Int = 5
}