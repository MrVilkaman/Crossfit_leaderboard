package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo


import android.os.Bundle
import android.view.View
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_layout_wodinfoscreen_wizard.*

class WodInfoWizardScreen : BaseFragment<WodInfoWizardPresenter>(), WodInfoWizardView {

    override fun getLayoutId(): Int = R.layout.fragment_layout_wodinfoscreen_wizard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun createWodViews(wodCount: Int) {
        wod_content.removeAllViews()
        for (i in 0 until wodCount){
            wod_content.addView(WodInfoItemWidget(context,i+1))
        }
    }

    companion object {
        fun open(): WodInfoWizardScreen = WodInfoWizardScreen()
    }

}