package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tdoni_10119907.a10119907uts.databinding.FragmentProfileBinding
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment
import com.tdoni_10119907.a10119907uts.presentation.dialog.AboutDialogFragment

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class ProfileViewBindingFragment : ViewBindingFragment<FragmentProfileBinding>(),
    OnMapReadyCallback {
    override val bindingInflater: (LayoutInflater) -> ViewBinding = FragmentProfileBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMap()
        initButton()
    }

    private fun initButton() {
        binding.btnMail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("doni.10119907@mahasiswa.unikom.ac.id"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Contact")
            intent.resolveActivity(requireContext().packageManager)?.let {
                startActivity(intent)
            }
        }
        binding.btnPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,  Uri.parse("https://api.whatsapp.com/send?phone=+6289629758463"))
            startActivity(intent)
        }

        binding.btnInstagram.setOnClickListener {
            try {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/theodorusdoni53"))
                intent.setPackage("com.instagram.android")
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("http://instagram.com/theodorusdoni53")
                    )
                )
            }
        }

        binding.btnAbout.setOnClickListener {
            AboutDialogFragment().show(parentFragmentManager, "")
        }
    }

    private fun initMap() {
        val mapFragment = binding.fragmentContainerViewMap.getFragment() as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val home = LatLng(-7.752400, 110.450580)
        googleMap.addMarker(
            MarkerOptions()
                .position(home)
                .title("Home")
        )
        googleMap.uiSettings.setAllGesturesEnabled(false)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home,15f))
    }
}