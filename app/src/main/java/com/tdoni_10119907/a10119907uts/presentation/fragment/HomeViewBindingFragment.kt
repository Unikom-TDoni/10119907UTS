package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.tdoni_10119907.a10119907uts.databinding.FragmentHomeBinding
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class HomeViewBindingFragment : ViewBindingFragment<FragmentHomeBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding = FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}