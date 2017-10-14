package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.teaminfo


import android.os.Bundle
import android.view.View
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment
import kotlinx.android.synthetic.main.layout_teaminfowizardscreen_fragment.*

class TeamInfoWizardScreenFragment : BaseFragment<TeamInfoWizardPresenter>(), TeamInfoWizardView {

    override fun getLayoutId(): Int = R.layout.layout_teaminfowizardscreen_fragment

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registration_wizard_btn_finish.setOnClickListener{
            presenter.onClickFinish()
        }
    }

    companion object {
        fun open(): TeamInfoWizardScreenFragment {
            return TeamInfoWizardScreenFragment()
        }
    }


}