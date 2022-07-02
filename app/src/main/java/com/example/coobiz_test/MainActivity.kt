package com.example.coobiz_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = BMIFragment.newInstance()
        addFragment(fragment)
        this.title = "BMI CALCULATOR"
    }

    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.first_navigation -> {
                val fragment = BMIFragment.newInstance()
                addFragment(fragment)
                this.title = "BMI CALCULATOR"
                return@OnItemSelectedListener true
            }
            R.id.second_navigation -> {
                val fragment = SmallestNumberFragment.newInstance()
                addFragment(fragment)
                this.title = "FIND SMALLEST NUMBER"
                return@OnItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fr_content, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}