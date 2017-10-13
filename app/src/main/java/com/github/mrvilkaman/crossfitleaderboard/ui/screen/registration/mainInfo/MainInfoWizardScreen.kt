package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.mainInfo

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_info_registration_wizard.*


class MainInfoWizardScreen : BaseFragment<MainInfoWizardPresenter>(), MainInfoWizardView {

    override fun getLayoutId(): Int = R.layout.fragment_main_info_registration_wizard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val objects: Array<String> = resources.getStringArray(R.array.wod_count_list)
        val adapter = ArrayAdapter(context, R.layout.spinner_item_selected, objects)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        planets_spinner.adapter = adapter
    }
}