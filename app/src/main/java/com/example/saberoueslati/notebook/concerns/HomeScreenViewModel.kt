package com.example.saberoueslati.notebook.concerns

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.utils.Event
import com.example.saberoueslati.notebook.utils.ViewPagerOnPageSelected
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeScreenViewModel : ViewModel() {

    val swiped: MutableLiveData<Event<Int>> = MutableLiveData()
    val navbarClicked: MutableLiveData<Event<Int>> = MutableLiveData()

    val jumpScreen: BottomNavigationView.OnNavigationItemSelectedListener
        get() = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Reminders -> {
                    navbarClicked.value = Event(0)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.Notes -> {
                    navbarClicked.value = Event(1)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.Settings -> {
                    navbarClicked.value = Event(2)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    val swipe: ViewPagerOnPageSelected
        get() = ViewPagerOnPageSelected { position ->
            when (position) {
                0 -> swiped.value = Event(R.id.Reminders)
                1 -> swiped.value = Event(R.id.Notes)
                2 -> swiped.value = Event(R.id.Settings)
            }
        }
}