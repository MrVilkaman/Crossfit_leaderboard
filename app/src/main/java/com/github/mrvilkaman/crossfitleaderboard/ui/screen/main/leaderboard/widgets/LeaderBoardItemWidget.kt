package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard.widgets


import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.CrossfitWod
import com.github.mrvilkaman.crossfitleaderboard.ui.dialogs.TextDialog
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseCustomView
import kotlinx.android.synthetic.main.item_main_leaderboard.view.*

class LeaderBoardItemWidget : BaseCustomView<LeaderBoardItemPresenter> {

    private lateinit var adapter: WodInfoRowAdapter

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onViewCreate(inflate: View, context: Context, attrs: AttributeSet?) {


        item_recyclerview.layoutManager = LinearLayoutManager(context)
        adapter = WodInfoRowAdapter()
        item_recyclerview.adapter = adapter

        adapter.setOnLongClick {
            val titleId = if (it.score == null) R.string.main_row_result_add else R.string.main_row_result_change
            val preFill = it.score?.toString() ?: ""
            TextDialog.createNumber(context, titleId, preFill) {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }.show()
        }
    }

    override fun getLayoutId(): Int = R.layout.item_main_leaderboard

    fun bindWod(wodItem: CrossfitWod) {
        adapter.wodItem = wodItem;
        adapter.items = wodItem.results
    }
}
