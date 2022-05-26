package com.tdoni_10119907.a10119907uts.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tdoni_10119907.a10119907uts.databinding.ItemFriendListBinding
import com.tdoni_10119907.a10119907uts.domain.Friend

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class FriendListRecyclerViewAdapter(private val friends: Array<Friend>) :
    RecyclerView.Adapter<FriendListRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemFriendListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemFriendListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        binding.txtViewName.text = friends[position].name
        binding.imgViewProfilePhoto.setImageResource(friends[position].photo)
    }

    override fun getItemCount(): Int = 5
}