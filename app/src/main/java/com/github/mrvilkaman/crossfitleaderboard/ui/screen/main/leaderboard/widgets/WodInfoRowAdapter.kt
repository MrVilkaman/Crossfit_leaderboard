package com.github.mrvilkaman.crossfitleaderboard.ui.screen.main.leaderboard.widgets

import android.view.View
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.main.WodInfoModel
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseVH
import com.github.mrvilkaman.presentationlayer.fragments.core.ItemListener
import com.github.mrvilkaman.presentationlayer.fragments.core.MySimpleBaseAdapter
import com.github.mrvilkaman.presentationlayer.utils.ui.UIUtils
import kotlinx.android.synthetic.main.item_wod_info_row.view.*


class WodInfoRowAdapter : MySimpleBaseAdapter<WodInfoModel, WodInfoModelVH>() {
    override fun getHolder(view: View): WodInfoModelVH = WodInfoModelVH(view)

    override fun getLayoutId(): Int = R.layout.item_wod_info_row
}


class WodInfoModelVH(view: View) : BaseVH<WodInfoModel>(view) {

    override fun setListeners(view: View, onClick: ItemListener<WodInfoModel>?, onLongClick: ItemListener<WodInfoModel>?) {
        super.setListeners(view, onClick, onLongClick)

        view.wod_add_btn.setOnClickListener {
            onLongClick?.click(item)
        }
    }

    override fun bind(item: WodInfoModel, position: Int, payloads: MutableSet<String>?) {

        itemView.wod_username.text = item.userName
        val score = item.score

        if (score != null) {
            UIUtils.changeVisibility(itemView.wod_score, true)
            UIUtils.changeVisibility(itemView.wod_add_btn, false)
            itemView.wod_score.wod_score.text = score.toString()
            itemView.wod_add_btn.setText(R.string.main_row_result_change)
        } else {
            UIUtils.changeVisibility(itemView.wod_score, false)
            itemView.wod_add_btn.setText(R.string.main_row_result_add)
            UIUtils.changeVisibility(itemView.wod_add_btn, true)
        }
    }
}