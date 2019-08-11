package com.zabochen.fugaapp.ui.preferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zabochen.data.preferences.AppPreferences
import com.zabochen.fugaapp.R
import com.zabochen.fugaapp.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_preferences.*
import kotlinx.android.synthetic.main.fragment_preferences.view.*

class PreferencesFragment : BaseFragment(R.layout.fragment_preferences) {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var appPref: AppPreferences

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.sharedPreferences = context.getSharedPreferences("app_pref", Context.MODE_PRIVATE)
        this.appPref = AppPreferences(sharedPreferences)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_preferences, container, false)
        view.fragmentPreferences_switch_blackThemeState.apply {
            isChecked = appPref.blackThemeState!!
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentPreferences_switch_blackThemeState.apply {
            setOnCheckedChangeListener { buttonView, isChecked ->
                appPref.blackThemeState = isChecked
            }
        }
    }

}