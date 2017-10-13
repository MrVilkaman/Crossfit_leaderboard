package com.github.mrvilkaman.crossfitleaderboard.ui.screen.registration.mainInfo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.crossfitleaderboard.ui.dialogs.DatePickerDialog
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseFragment
import kotlinx.android.synthetic.main.fragment_main_info_registration_wizard.*
import java.text.SimpleDateFormat
import java.util.*


class MainInfoWizardScreen : BaseFragment<MainInfoWizardPresenter>(), MainInfoWizardView {

    override fun getLayoutId(): Int = R.layout.fragment_main_info_registration_wizard


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registration_date.setOnClickListener {
            DatePickerDialog.create(context, Date(), object : DatePickerDialog.OnSelectedDateListener {
                override fun onDateSelected(date: Date) {
                    presenter.onDateChanged(date)
                }

            }).show()
        }

        // Инициализация spinner для выбора количестава WOD
        val objects: Array<String> = resources.getStringArray(R.array.wod_count_list)
        val adapter = ArrayAdapter(context, R.layout.spinner_item_selected, objects)
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        planets_spinner.adapter = adapter
        planets_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.onWodCountChanged(objects[position])
            }
        }

    }

    private val dateFormat: SimpleDateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    override fun bindDate(date: Date) {
        registration_date.setText(dateFormat.format(date))
    }
}