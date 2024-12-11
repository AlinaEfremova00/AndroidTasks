package ru.itis.task

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        if (savedInstanceState == null) {
            val fragmentToLoad = intent.getStringExtra("fragment_to_load")
            val fragment = when (fragmentToLoad) {
                "login" -> LoginFragment()
                "register" -> RegisterFragment()
                else -> ProfileFragment()
            }

            supportFragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_container, fragment)
                .commit()
        }
    }
}
