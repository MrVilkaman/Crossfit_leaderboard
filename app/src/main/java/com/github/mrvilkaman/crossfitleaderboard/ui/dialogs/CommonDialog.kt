package com.github.mrvilkaman.crossfitleaderboard.ui.dialogs


import android.app.Dialog
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import com.afollestad.materialdialogs.DialogAction
import com.afollestad.materialdialogs.MaterialDialog
import com.github.mrvilkaman.crossfitleaderboard.R
import com.github.mrvilkaman.presentationlayer.fragments.core.BasePresenter
import com.github.mrvilkaman.presentationlayer.fragments.core.BaseView
import com.github.mrvilkaman.presentationlayer.resolution.ThrowableResolver
import com.github.mrvilkaman.presentationlayer.utils.ui.UIUtils

abstract class CommonDialog<P : BasePresenter<*>>(val context: Context) : BaseView {

    @Suppress("MemberVisibilityCanPrivate")
//    @Inject
    var presenter: P? = null
    private var content: View? = null
    private var progressBar: View? = null
//    @Inject
    var throwableResolver: ThrowableResolver? = null
    private var dialog: MaterialDialog? = null

    @StringRes
    protected  abstract fun title(): Int

    @LayoutRes
    protected abstract fun layout(): Int


    protected fun build(): Dialog {
        val builder = MaterialDialog.Builder(context)
        val layout = layout()
        if (layout != 0) {
            val view = LayoutInflater.from(context)
                    .inflate(layout, null)
            builder.customView(view, true)
            builder.canceledOnTouchOutside(false)
                    .autoDismiss(true)

            content = view.findViewById(R.id.content)
            progressBar = view.findViewById(R.id.progress_wheel)
            initView(view)
        }


        val title = title()
        if (title != 0) {
            builder.title(title)
        }

        val presenter = presenter
        if (presenter != null) {
            presenter.setView(this as Nothing?)
            presenter.onViewAttached()
        }
        onViewCreated()
        dialog = handleBuilder(builder).dismissListener { dialog ->
            if (presenter != null) {
                presenter.onViewDetached()
                presenter.setView(null)
            }
        }
                .build()

        doWorkWithDialog(dialog)

        return dialog!!
    }

    protected open fun initView(view: View) {

    }

    protected open fun doWorkWithDialog(dialog: MaterialDialog?) {

    }

    protected open fun onViewCreated() {

    }

    protected abstract fun handleBuilder(builder: MaterialDialog.Builder): MaterialDialog.Builder

    override fun showProgress() {
        UIUtils.changeVisibility(dialog?.getActionButton(DialogAction.NEGATIVE), false)
        UIUtils.changeVisibility(dialog?.getActionButton(DialogAction.POSITIVE), false)
        UIUtils.changeVisibility(content, false)
        UIUtils.changeVisibility(progressBar, true)
    }

    override fun hideProgress() {
        UIUtils.changeVisibility(dialog?.getActionButton(DialogAction.NEGATIVE), true)
        UIUtils.changeVisibility(dialog?.getActionButton(DialogAction.POSITIVE), true)
        UIUtils.changeVisibility(progressBar, false)
        UIUtils.changeVisibility(content, true)
    }

    fun close() {
        dialog?.dismiss()
    }

}
