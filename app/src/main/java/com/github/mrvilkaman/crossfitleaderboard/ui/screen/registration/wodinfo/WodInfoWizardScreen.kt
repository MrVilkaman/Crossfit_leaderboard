package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo


import android.os.Bundle
import android.support.transition.TransitionManager
import android.view.View
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodItem
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_layout_wodinfoscreen_wizard.*

class WodInfoWizardScreen : BaseFragment<WodInfoWizardPresenter>(), WodInfoWizardView {

    override fun getLayoutId(): Int = R.layout.fragment_layout_wodinfoscreen_wizard

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registration_wizard_next.setOnClickListener {
            val array = ArrayList<WodItem>()

            val wodCount = wod_content.childCount
            (0 until wodCount)
                    .map { wod_content.getChildAt(it) as WodInfoItemWidget }
                    .mapTo(array) { it.getData() }

            hideKeyboard()
            presenter.onClickNextStep(array)
        }
    }

    override fun createWodViews(wodCount: Int) {
        TransitionManager.beginDelayedTransition(parent)
        wod_content.removeAllViews()
        for (i in 0 until wodCount) {
            wod_content.addView(WodInfoItemWidget(context, i + 1))
        }
    }

    override fun showWodError(errorMessageTextId: Int, number: Int) {
        val wodInfoItemWidget = wod_content.getChildAt(number) as WodInfoItemWidget
        wodInfoItemWidget.setError(errorMessageTextId)
    }

    companion object {
        fun open(): WodInfoWizardScreen = WodInfoWizardScreen()
    }

}