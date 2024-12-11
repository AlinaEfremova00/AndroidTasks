package ru.itis.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val switchToLoginButton = view.findViewById<Button>(R.id.switch_to_login_button)
        switchToLoginButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_container, LoginFragment())
                .addToBackStack(null)
                .commit()
        }

        val registerButton = view.findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_container, ProfileFragment())
                .commit()
        }

        return view
    }
}
