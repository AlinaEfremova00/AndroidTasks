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
            .setTitle("Вход в аккаунт")
            .setMessage("Пожалуйста, войдите в аккаунт или зарегистрируйтесь, чтобы продолжить.")
            .setPositiveButton("Войти") { _, _ ->
                listener?.onLoginSelected()
            }
            .setNegativeButton("Зарегистрироваться") { _, _ ->
                listener?.onRegisterSelected()
            }
            .create()
    }
}
