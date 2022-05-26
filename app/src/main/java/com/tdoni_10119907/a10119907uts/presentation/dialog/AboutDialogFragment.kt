package com.tdoni_10119907.a10119907uts.presentation.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.tdoni_10119907.a10119907uts.BuildConfig
import com.tdoni_10119907.a10119907uts.databinding.DialogAboutBinding

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class AboutDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = DialogAboutBinding.inflate(layoutInflater)
        ("Ver: " + BuildConfig.VERSION_NAME).also { binding.txtViewVersion.text = it }
        return AlertDialog.Builder(requireActivity())
            .setView(binding.root)
            .setCancelable(false)
            .create()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        this.dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}