package com.example.saberoueslati.notebook.utils

import androidx.viewpager.widget.ViewPager

//TODO IMPORTANT
// ViewPagerOnPageSelected.kt
class ViewPagerOnPageSelected(private val pageSelected: (Int) -> Unit = {}) : ViewPager.OnPageChangeListener {

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        pageSelected(position)
    }

    override fun onPageScrollStateChanged(state: Int) {}
}

// ViewPagerOnPageScrolled.kt
class ViewPagerOnPageScrolled(private val pageScrolled: (Int, Float, Int) -> Unit = { _, _, _ -> }) :
    ViewPager.OnPageChangeListener {

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        pageScrolled(position, positionOffset, positionOffsetPixels)
    }

    override fun onPageSelected(position: Int) {}

    override fun onPageScrollStateChanged(state: Int) {}
}

// ViewPagerScrollStateChanged.kt
class ViewPagerScrollStateChanged(private val pageScrollStateChanged: (Int) -> Unit = {}) :
    ViewPager.OnPageChangeListener {

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {}

    override fun onPageScrollStateChanged(state: Int) {
        pageScrollStateChanged(state)
    }
}