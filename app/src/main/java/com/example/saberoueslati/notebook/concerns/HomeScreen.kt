package com.example.saberoueslati.notebook.concerns

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.eftimoff.viewpagertransformers.CubeOutTransformer
import com.example.saberoueslati.notebook.R
import com.example.saberoueslati.notebook.concerns.notelist.NoteListFragment
import com.example.saberoueslati.notebook.concerns.reminderlist.ReminderListFragment
import com.example.saberoueslati.notebook.concerns.settings.SettingsFragment
import com.example.saberoueslati.notebook.databinding.NavigationBinding
import com.example.saberoueslati.notebook.utils.EventObserver
import com.example.saberoueslati.notebook.utils.FragmentPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class HomeScreen : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val binding = DataBindingUtil.setContentView<NavigationBinding>(this, R.layout.activity_home_screen)
        viewModel = ViewModelProviders.of(this).get(HomeScreenViewModel::class.java)
        binding.viewModel = viewModel
        bottomNavigationView = binding.navigation
        bottomNavigationView.selectedItemId = R.id.Notes

        val fragments: MutableList<Fragment> = Vector<Fragment>()
        fragments.add(ReminderListFragment.newInstance())
        fragments.add(NoteListFragment.newInstance())
        fragments.add(SettingsFragment.newInstance())

        val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, fragments)

        viewPager = binding.fragmentHolder
        viewPager.adapter = pagerAdapter
        viewPager.setPageTransformer(true, CubeOutTransformer())
        viewPager.currentItem = 1

        viewModel.navbarClicked.observe(this, EventObserver { it ->
            viewPager.currentItem = it
        })
        viewModel.swiped.observe(this, EventObserver { it ->
            bottomNavigationView.selectedItemId = it
        })
    }
}
