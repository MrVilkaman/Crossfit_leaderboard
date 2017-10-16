package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.wodinfo


import android.content.Context
import android.support.annotation.StringRes
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodItem
import com.github.mrvilkaman.crossfitleaderboard.business.registration.WodType
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseCustomView
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import com.github.mrvilkaman.presentationlayer.utils.ui.UIUtils
import kotlinx.android.synthetic.main.item_wod_info_view.view.*

class WodInfoItemWidget : BaseCustomView<BasePresenter<*>> {

    constructor(context: Context, number: Int, current:WodItem) : super(context, null) {
        registration_wizard_wod_number.text = resources.getString(R.string.wod_wizard_title, number)

        registration_wizard_wod_description.setText(current.description)
        registration_wizard_wod_type.setSelection(current.type.ordinal)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    private lateinit var wodType: WodType

    override fun onViewCreate(inflate: View, context: Context, attrs: AttributeSet?) {
//        registration_wizard_wod_title


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
                wodType = objects[position]
            }
        }

        registration_wizard_wod_description.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (registration_wizard_wod_description_input.error != null) {
                    registration_wizard_wod_description_input.error = null
                    registration_wizard_wod_description_input.isErrorEnabled = false
                }
            }
        })
    }

    override fun getLayoutId(): Int = R.layout.item_wod_info_view

    fun getData(): WodItem = WodItem(UIUtils.asString(registration_wizard_wod_description), wodType)

    fun setError(@StringRes errorMessageTextId: Int) {
        registration_wizard_wod_description_input.error = resources.getString(errorMessageTextId)
    }
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
