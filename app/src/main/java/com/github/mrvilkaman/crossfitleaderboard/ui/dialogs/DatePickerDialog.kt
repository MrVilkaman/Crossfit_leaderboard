package com.github.mrvilkaman.crossfitleaderboard.ui.dialogs

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.DatePicker
import com.afollestad.materialdialogs.MaterialDialog
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import java.util.*


class DatePickerDialog private constructor(context: Context, date: Date?, private val dateLimit: Date?, type: TYPE?) : CommonDialog<BasePresenter<*>>(context) {

    private val type: TYPE
    private var datePicker: DatePicker? = null
    private var dateCallback: OnSelectedDateListener? = null
    private var date: Date? = null


    override fun layout(): Int = R.layout.dialog_date

    override fun title(): Int = 0

    init {
        var date = date
        var type = type
        if (date == null) {
            date = Date()
        }

        this.date = date

        if (type == null) {
            type = TYPE.TODAY_MIN
        }

        this.type = type
    }

    override fun initView(view: View) {
        datePicker = view.findViewById(R.id.datePicker)
    }

    override fun handleBuilder(builder: MaterialDialog.Builder): MaterialDialog.Builder {
        return builder.positiveText(android.R.string.ok)
                .onPositive { dialog, which -> dateCallback?.onDateSelected(date!!) }
                .negativeText(android.R.string.cancel).autoDismiss(true)
    }

    override fun onViewCreated() {
        val picker = datePicker ?: return

        picker.calendarViewShown = false


        val dateCalendar = Calendar.getInstance()
        // reset hour, minutes, seconds and millis
        dateCalendar.set(Calendar.HOUR_OF_DAY, 0)
        dateCalendar.set(Calendar.MINUTE, 0)
        dateCalendar.set(Calendar.SECOND, 0)
        dateCalendar.set(Calendar.MILLISECOND, 0)
        //		datePicker.setMaxDate(dateCalendar.getTimeInMillis());

        when (type) {
            DatePickerDialog.TYPE.TODAY_MIN -> picker.minDate = dateCalendar.time.time
            DatePickerDialog.TYPE.TODAY_MAX -> picker.maxDate = dateCalendar.time.time
            DatePickerDialog.TYPE.MIN_THEN -> {
                var gregorianCalendar = GregorianCalendar()
                gregorianCalendar.set(Calendar.YEAR, 1930)
                picker.minDate = gregorianCalendar.timeInMillis
                if (dateLimit != null) {
                    picker.maxDate = dateLimit.time - 60 * 1000
                }
            }
            DatePickerDialog.TYPE.MAX_THEN -> {
                if (dateLimit != null) {
                    picker.minDate = dateLimit.time
                }
                val gregorianCalendar = GregorianCalendar()
                gregorianCalendar.add(Calendar.YEAR, 1)
                picker.maxDate = gregorianCalendar.time.time
            }
        }


        val calendar = Calendar.getInstance()
        calendar.time = date

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        picker.init(year, month, day) { datePicker1, i, i2, i3 -> date = GregorianCalendar(i, i2, i3, 0, 0).time }

    }

    fun setDateCallback(dateCallback: OnSelectedDateListener) {
        this.dateCallback = dateCallback
    }

    enum class TYPE {
        TODAY_MIN, TODAY_MAX, MAX_THEN, MIN_THEN, EMPTY
    }

    interface OnSelectedDateListener {
        fun onDateSelected(date: Date)
    }

    companion object {

        fun create(context: Context, date: Date, type: TYPE, limit: Date?,
                   dateCallback: OnSelectedDateListener): Dialog {
            val datePickerDialog = DatePickerDialog(context, date, limit, type)
            datePickerDialog.setDateCallback(dateCallback)
            return datePickerDialog.build()
        }

        fun create(context: Context, date: Date, type: TYPE,
                   dateCallback: OnSelectedDateListener): Dialog {
            return create(context, date, type, null, dateCallback)
        }

        fun create(context: Context, date: Date, dateCallback: OnSelectedDateListener): Dialog {
            return create(context, date, TYPE.TODAY_MIN, dateCallback)
        }
    }

}