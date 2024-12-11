package ru.itis.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val switchToRegisterButton = view.findViewById<Button>(R.id.switch_to_register_button)
        switchToRegisterButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_container, RegisterFragment())
                .addToBackStack(null)
                .commit()
        }

        val loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_container, ProfileFragment())
                .commit()
        }

        return view
    }
}
