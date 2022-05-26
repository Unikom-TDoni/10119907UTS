package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.viewbinding.ViewBinding
import com.tdoni_10119907.a10119907uts.databinding.FragmentMainMenuBinding
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class MainMenuViewBindingFragment : ViewBindingFragment<FragmentMainMenuBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding = FragmentMainMenuBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomNavView()
    }

    private fun initBottomNavView(){
        binding.bottomNavView.setupWithNavController(
            NavHostFragment.findNavController(
                binding.fragmentContainerView.getFragment()
            )
        )
    }
}