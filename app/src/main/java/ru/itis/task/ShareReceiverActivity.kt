package ru.itis.task

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.pm.PackageManager

class ShareReceiverActivity : AppCompatActivity() {

    companion object {
        const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_receiver)


        // Кнопка для выбора изображения
        val pickImageButton: Button = findViewById(R.id.pick_image_button)
        val imageView: ImageView = findViewById(R.id.received_image)

        // Проверка разрешений на доступ к хранилищу
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }

        // Открытие галереи для выбора изображения
        pickImageButton.setOnClickListener {
            val pickImageIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            pickImageIntent.type = "image/*"
            startActivityForResult(pickImageIntent, PICK_IMAGE_REQUEST)
        }

        // Обработчик кнопки назад
        val backButton: Button = findViewById(R.id.back_button1)
        backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    // Обработка результата выбора изображения
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri: Uri = data.data!!
            val imageView: ImageView = findViewById(R.id.received_image)
            imageView.setImageURI(selectedImageUri)
        }
    }

    // Обработка результата запроса разрешений
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
        }
    }
}


