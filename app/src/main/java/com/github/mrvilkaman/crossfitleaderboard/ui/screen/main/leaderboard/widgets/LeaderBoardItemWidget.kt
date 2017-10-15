package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard.widgets


import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.View
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.main.WodInfoModel
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseCustomView
import kotlinx.android.synthetic.main.item_main_leaderboard.view.*

class LeaderBoardItemWidget : BaseCustomView<LeaderBoardItemPresenter> {

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onViewCreate(inflate: View, context: Context, attrs: AttributeSet?) {


        item_recyclerview.layoutManager = LinearLayoutManager(context)
        val adapter = WodInfoRowAdapter()
        item_recyclerview.adapter = adapter

        adapter.items = arrayListOf(
                WodInfoModel("User 1"),
                WodInfoModel("User 2"),
                WodInfoModel("User 3")
        )
    }

    override fun getLayoutId(): Int = R.layout.item_main_leaderboard
}
