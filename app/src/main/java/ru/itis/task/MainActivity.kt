package ru.itis.task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileButton: Button = findViewById(R.id.acc_button)
        var isUserLoggedIn = false

        profileButton.setOnClickListener {
            if (isUserLoggedIn) {
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                val dialog = LoginDialogFragment()
                dialog.listener = object : LoginDialogFragment.OnLoginActionListener {
                    override fun onLoginSelected() {
                        val intent = Intent(this@MainActivity, LoginActivity::class.java)
                        startActivity(intent)
                    }

                    override fun onRegisterSelected() {
                        val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                        startActivity(intent)
                    }
                }
                dialog.show(supportFragmentManager, "loginDialog")
            }
        }
    }
}

