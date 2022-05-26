package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.viewbinding.ViewBinding
import com.tdoni_10119907.a10119907uts.databinding.FragmentImageGalleryBinding
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment
import com.tdoni_10119907.a10119907uts.presentation.adapter.ImageGalleryRecyclerViewAdapter

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class ImageGalleryViewBindingFragment : ViewBindingFragment<FragmentImageGalleryBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding =
        FragmentImageGalleryBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(
            2,
            StaggeredGridLayoutManager.VERTICAL,
        )
        binding.recyclerView.adapter = ImageGalleryRecyclerViewAdapter()
    }
}