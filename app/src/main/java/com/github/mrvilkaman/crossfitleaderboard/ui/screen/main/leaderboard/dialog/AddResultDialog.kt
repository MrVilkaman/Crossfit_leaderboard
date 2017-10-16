package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard.dialog


import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.ui.dialogs.CommonDialog
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter

class AddResultDialog(context: Context) : CommonDialog<BasePresenter<*>>(context) {

    override fun layout(): Int = 0

    override fun title(): Int = R.string.main_row_result_add

    override fun handleBuilder(builder: MaterialDialog.Builder): MaterialDialog.Builder {
        return builder
    }
}
