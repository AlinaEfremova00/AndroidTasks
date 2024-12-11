package ru.itis.task

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.profile_fragment_container, ProfileFragment())
                .commit()
        }
    }
}