package com.example.introductiontofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SwipeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_tabs2)

        val vpAdapter = MySwipeAdapter(this)
        val viewPager: ViewPager2 = requireView().findViewById(R.id.swipe_fragment_view_pager2)
        viewPager.adapter = vpAdapter

        val tabLayout: TabLayout = requireView().findViewById(R.id.tab_layout_swipe)
        val images = arrayOf(R.drawable.one_icon_foreground, R.drawable.two_icon_foreground)

        TabLayoutMediator(tabLayout, viewPager
        ) { tab, position ->
            tab.text = "TAB ${(position + 1)}"
            tab.setIcon(images[position])
        }.attach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_swipe, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SwipeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}