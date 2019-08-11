package com.zabochen.fugaapp.ui.main

import android.os.Bundle
import androidx.navigation.Navigation
import com.zabochen.fugaapp.R
import com.zabochen.fugaapp.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUi()
    }

    private fun setUi() {
        // Toolbar
        setSupportActionBar(activityMain_toolbar)

        // Navigation Controller
        val navigationController = Navigation.findNavController(this, R.id.activityMain_fragment_navigationHost)

        // Bottom Navigation
        activityMain_bottomNavigationView.apply {
            setOnNavigationItemSelectedListener { item ->
                if (!navigationController.popBackStack(item.itemId, false)) navigationController.navigate(item.itemId)
                return@setOnNavigationItemSelectedListener true
            }
        }
    }
}
