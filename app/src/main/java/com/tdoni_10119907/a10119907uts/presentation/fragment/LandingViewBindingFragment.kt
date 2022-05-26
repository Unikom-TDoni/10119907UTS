package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.tdoni_10119907.a10119907uts.R
import com.tdoni_10119907.a10119907uts.databinding.FragmentLandingBinding
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class LandingViewBindingFragment : ViewBindingFragment<FragmentLandingBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding = FragmentLandingBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewPager()
        initDotIndicator()
        initButton()
    }

    private fun initViewPager() =
        binding.viewPager.apply {
            adapter = object : FragmentStateAdapter(this@LandingViewBindingFragment) {
                override fun getItemCount(): Int = 3
                override fun createFragment(position: Int): Fragment =
                    LandingContentViewBindingFragment.newInstance(position)
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when (position) {
                        2 -> {
                            binding.btnNext.visibility = View.VISIBLE
                            binding.dotIndicator.visibility = View.INVISIBLE
                        }
                        else -> {
                            if (binding.dotIndicator.visibility == View.INVISIBLE) {
                                binding.btnNext.visibility = View.INVISIBLE
                                binding.dotIndicator.visibility = View.VISIBLE
                            }
                        }
                    }
                    super.onPageSelected(position)
                }
            })
        }

    private fun initButton() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_landingViewBindingFragment_to_mainMenuViewBindingFragment)
        }
    }

    private fun initDotIndicator() =
        binding.dotIndicator.attachTo(binding.viewPager)
}