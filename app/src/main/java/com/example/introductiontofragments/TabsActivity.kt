package com.example.introductiontofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import layout.MyPagerAdapter

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        val vpAdapter = MyPagerAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = vpAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        val images = arrayOf(R.drawable.one_icon_foreground, R.drawable.two_icon_foreground)

        for (i in 0..1) {
            tabLayout.getTabAt(i)!!.setIcon(images[i])
            tabLayout.getTabAt(i)!!.text = vpAdapter.getPageTitle(i)
        }


    }
}