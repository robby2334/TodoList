package com.robbie.todolist.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.tabs.TabLayoutMediator
import com.robbie.todolist.R
import com.robbie.todolist.databinding.ActivityMainBinding
import com.robbie.todolist.ui.taskform.TaskFromActivity
import com.robbie.todolist.ui.tasklist.adapter.TaskListFragment
import com.robbie.todolist.utils.views.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle)

        //adding fragment to adapter
        viewPagerAdapter.addFragment(TaskListFragment.newInstance(false),"Undone Task")
        viewPagerAdapter.addFragment(TaskListFragment.newInstance(true),"Done Task")
        binding.vpTask.adapter = viewPagerAdapter

        //setting title for tab layout
        TabLayoutMediator(binding.tlTask,binding.vpTask,true){tab, pos ->
            tab.text = viewPagerAdapter.getPageTitle(pos)
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_add_task -> {
                startActivity(Intent(this,TaskFromActivity::class.java))
                true
            }
            R.id.menu_about -> {
                true
            }
            else ->{
                true
            }
        }
    }



}