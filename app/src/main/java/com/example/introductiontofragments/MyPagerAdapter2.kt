package com.example.introductiontofragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter2(fa: FragmentActivity): FragmentStateAdapter(fa) {

    private val items = 2

    override fun createFragment(position: Int): Fragment {
        val ret = when(position) {
            0 -> Fragment11.newInstance("frag11", "Page # 1")
            else -> Fragment12.newInstance("frag12", "Page # 1")
        }
        return ret
    }

    override fun getItemCount(): Int {
        return items
    }
}