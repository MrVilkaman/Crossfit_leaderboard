package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo


import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodType
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseCustomView
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import kotlinx.android.synthetic.main.item_wod_info_view.view.*

class WodInfoItemWidget : BaseCustomView<BasePresenter<*>> {

    @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {

    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onViewCreate(inflate: View, context: Context, attrs: AttributeSet?) {
//        registration_wizard_wod_title

        registration_wizard_wod_number.text = resources.getString(R.string.wod_wizard_title,1)

        // Инициализация spinner для выбора типа
        val objects: Array<WodType> = WodType.values()
        val adapter = TestAdapter(context, objects)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        registration_wizard_wod_type.adapter = adapter
        registration_wizard_wod_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                presenter.onWodCountChanged(objects[position])
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.item_wod_info_view
}

private class TestAdapter(context: Context, objects: Array<WodType>) :
        ArrayAdapter<WodType>(context, R.layout.spinner_item_selected, objects) {
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.spinner_item_selected, parent, false)

        val item = getItem(position)
        val text: TextView = view as TextView
        text.text = view.resources.getString(item.titleStrId)

        return view
    }
}
