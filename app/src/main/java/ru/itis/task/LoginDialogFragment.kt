package ru.itis.task

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class LoginDialogFragment : DialogFragment() {

    interface OnLoginActionListener {
        fun onLoginSelected()
        fun onRegisterSelected()
    }

    var listener: OnLoginActionListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.login_dialog_title))
            .setMessage(getString(R.string.login_dialog_text))
            .setPositiveButton(getString(R.string.sign_in)) { _, _ ->
                listener?.onLoginSelected()
            }
            .setNegativeButton(getString(R.string.register)) { _, _ ->
                listener?.onRegisterSelected()
            }
            .create()
    }
}
