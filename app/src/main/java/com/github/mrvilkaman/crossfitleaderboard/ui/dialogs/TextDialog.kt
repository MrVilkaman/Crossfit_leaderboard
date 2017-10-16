package com.github.mrvilkaman.crossfitleaderboard.ui.dialogs


import android.app.Dialog
import android.content.Context
import android.support.annotation.StringRes
import android.text.*
import com.afollestad.materialdialogs.MaterialDialog
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter


class TextDialog(context: Context) : CommonDialog<BasePresenter<*>>(context) {
    private var title: Int = 0
    private var preFill: String? = null
    private var callback: (String) ->Unit = {}

    private var filter: InputFilter = object : InputFilter {
        override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int, dend: Int): CharSequence? {
            var keepOriginal = true
            val sb = StringBuilder(end - start)
            (start until end)
                    .map { source[it] }
                    .forEach {
                        if (isCharAllowed(it))
                        // put your condition here
                            sb.append(it)
                        else
                            keepOriginal = false
                    }
            return if (keepOriginal)
                null
            else {
                if (source is Spanned) {
                    val sp = SpannableString(sb)
                    TextUtils.copySpansFrom(source, start, sb.length, null, sp, 0)
                    sp
                } else {
                    sb
                }
            }
        }

        private fun isCharAllowed(c: Char): Boolean {
            //			return Character.isLetterOrDigit(c) || Character.isSpaceChar(c);
            return c != '"' && c != '\''
        }
    }

    override fun doWorkWithDialog(dialog: MaterialDialog?) {
        dialog!!.inputEditText!!.filters = arrayOf(filter)

    }

    override fun handleBuilder(builder: MaterialDialog.Builder): MaterialDialog.Builder {
        val flag = when {
            isNumber -> InputType.TYPE_CLASS_NUMBER
            isMultiLine -> InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
            else -> InputType.TYPE_CLASS_TEXT
        }
        return builder.inputType(flag)
                .input(null, preFill, !isNumber) { _, input ->
                    val text = input.toString()
                    updateDescription(text)
                }
                .positiveText(R.string.order_work_action_save)
                .negativeText(R.string.order_work_action_cancel)
    }

    private fun updateDescription(text: String) {
        callback.invoke(text)
    }

    override fun layout(): Int = 0

    override fun title(): Int = title


    interface Callback {
        fun updateText(text: String)
    }

    companion object {

        private var isMultiLine: Boolean = false

        fun createMultiLine(context: Context, @StringRes titleId: Int, preFill: String,
                            callback: (String) ->Unit): Dialog {
            val textDialog = TextDialog(context)
            TextDialog.isMultiLine = true
            TextDialog.isNumber = false
            textDialog.title = titleId
            textDialog.preFill = preFill
            textDialog.callback = callback

            return textDialog.build()
        }

        fun createSingleLine(context: Context, @StringRes titleId: Int, preFill: String,
                             callback: (String) ->Unit): Dialog {
            val textDialog = TextDialog(context)
            TextDialog.isMultiLine = false
            TextDialog.isNumber = false
            textDialog.title = titleId
            textDialog.preFill = preFill
            textDialog.callback = callback

            return textDialog.build()
        }

        private var isNumber: Boolean = false

        fun createNumber(context: Context, @StringRes titleId: Int, preFill: String,
                         callback: (String) ->Unit): Dialog {
            val textDialog = TextDialog(context)
            TextDialog.isMultiLine = false
            TextDialog.isNumber = true
            textDialog.title = titleId
            textDialog.preFill = preFill
            textDialog.callback = callback

            return textDialog.build()
        }
    }
}
