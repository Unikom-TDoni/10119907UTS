package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.R.attr.defaultValue
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.tdoni_10119907.a10119907uts.R
import com.tdoni_10119907.a10119907uts.databinding.FragmentLandingContentBinding
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class LandingContentViewBindingFragment : ViewBindingFragment<FragmentLandingContentBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding =
        FragmentLandingContentBinding::inflate

    companion object {
        private const val bundleKey = "Position"
        fun newInstance(position: Int): LandingContentViewBindingFragment {
            val fragment = LandingContentViewBindingFragment()
            val bundle = Bundle()
            bundle.putInt(bundleKey, position)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeContentBasedOnPosition(requireArguments())
    }

    private fun changeContentBasedOnPosition(bundle: Bundle) =
        when (val position = bundle.getInt(bundleKey, defaultValue)) {
            in 0..3 -> {
                binding.txtViewBackground.text =
                    resources.getStringArray(R.array.txt_view_landing_background)[position]
                binding.txtViewDesc.text =
                    resources.getStringArray(R.array.txt_view_landing_desc)[position]
                binding.txtViewTittle.text =
                    resources.getStringArray(R.array.txt_view_landing_tittle)[position]
            }
            else -> throw IndexOutOfBoundsException()
        }
}