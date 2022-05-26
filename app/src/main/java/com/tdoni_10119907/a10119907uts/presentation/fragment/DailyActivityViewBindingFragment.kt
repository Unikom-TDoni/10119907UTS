package com.tdoni_10119907.a10119907uts.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.tdoni_10119907.a10119907uts.R
import com.tdoni_10119907.a10119907uts.databinding.FragmentDailyActivityBinding
import com.tdoni_10119907.a10119907uts.domain.DailyActivity
import com.tdoni_10119907.a10119907uts.domain.Friend
import com.tdoni_10119907.a10119907uts.modules.ViewBindingFragment
import com.tdoni_10119907.a10119907uts.presentation.adapter.DailyActivityRecyclerViewAdapter
import com.tdoni_10119907.a10119907uts.presentation.adapter.FriendListRecyclerViewAdapter

// 5/26/2022
// 10119907
// T DONI INDRAPRASTA PRADANA
// IF10K
class DailyActivityViewBindingFragment : ViewBindingFragment<FragmentDailyActivityBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding =
        FragmentDailyActivityBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val photoFriends = arrayOf(
            R.drawable.img_abraham,
            R.drawable.img_aris,
            R.drawable.img_fauzan,
            R.drawable.img_edwin,
            R.drawable.img_riko,
        )

        binding.recyclerViewFriendList.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.recyclerViewDailyActivity.layoutManager = LinearLayoutManager(context)

        binding.recyclerViewDailyActivity.adapter = DailyActivityRecyclerViewAdapter(
            Array(6) {
                DailyActivity(
                    resources.getStringArray(R.array.txt_view_activity_hour)[it],
                    resources.getStringArray(R.array.txt_view_activity_name)[it],
                )
            })

        binding.recyclerViewFriendList.adapter = FriendListRecyclerViewAdapter(
            Array(5) {
                Friend(
                    resources.getStringArray(R.array.txt_view_friend_name)[it],
                    photoFriends[it]
                )
            }
        )
    }
}