package com.example.introductiontofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabsActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs2)

        val vpAdapter = MyPagerAdapter2(this)
        val viewPager: ViewPager2 = findViewById(R.id.viewPager3)
        viewPager.adapter = vpAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout3)
        val images = arrayOf(R.drawable.one_icon_foreground, R.drawable.two_icon_foreground)

        TabLayoutMediator(tabLayout, viewPager
        ) { tab, position ->
            tab.text = "TAB ${(position + 1)}"
            tab.setIcon(images[position])
        }.attach()

    }


}