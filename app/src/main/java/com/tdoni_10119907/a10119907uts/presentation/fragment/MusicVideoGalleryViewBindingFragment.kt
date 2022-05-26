package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.tdoni_10119907.a10119907uts.R
import com.tdoni_10119907.a10119907uts.databinding.FragmentMusicVideoGalleryBinding
import com.tdoni_10119907.a10119907uts.domain.Music
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment
import com.tdoni_10119907.a10119907uts.presentation.adapter.MusicGalleryRecyclerViewAdapter

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class MusicVideoGalleryViewBindingFragment :
    ViewBindingFragment<FragmentMusicVideoGalleryBinding>() {

    private lateinit var musicMediaPlayer: Array<MediaPlayer>

    override val bindingInflater: (LayoutInflater) -> ViewBinding =
        FragmentMusicVideoGalleryBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        musicMediaPlayer = generateMusicMedia()
        initVideoView()
        initMusicRecyclerView()
    }

    private fun initMusicRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        val thumbnailId = arrayOf(
            R.drawable.img_thumbnail_aimer,
            R.drawable.img_thumbnail_bea_miller,
            R.drawable.img_thumbnail_iu,
            R.drawable.img_thumbnail_yama,
            R.drawable.img_thumbnail_yvette_young,
        )

        binding.recyclerView.adapter = MusicGalleryRecyclerViewAdapter(Array(5) {
            Music(
                resources.getStringArray(R.array.txt_view_song_name)[it],
                thumbnailId[it],
                resources.getStringArray(R.array.txt_view_artist_name)[it],
                musicMediaPlayer[it]
            )
        })
    }

    private fun initVideoView() {
        binding.videoView.setVideoURI(Uri.parse("android.resource://" + requireActivity().packageName.toString() + "/" + R.raw.video_arcane))
        binding.videoView.start()
        binding.videoView.setOnPreparedListener { it.isLooping = true }
    }

    private fun generateMusicMedia() =
        arrayOf(
            MediaPlayer.create(context, R.raw.aimer_twinkle_twinkle_little_star),
            MediaPlayer.create(context, R.raw.bea_miller_playground),
            MediaPlayer.create(context, R.raw.iu_celebrity),
            MediaPlayer.create(context, R.raw.yama_oz),
            MediaPlayer.create(context, R.raw.yvette_young_a_map_a_string_a_light),
        )

    override fun onDestroyView() {
        for (item in musicMediaPlayer) item.release()
        super.onDestroyView()
    }
}