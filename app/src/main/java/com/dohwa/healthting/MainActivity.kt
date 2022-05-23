package com.dohwa.healthting

import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    private val PICK_IMAGE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainlayout)
        val imageView: ImageView = findViewById(R.id.my_image)
        imageView.setOnClickListener {
            startGalleryActivity()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            loadAndSaveImage(data)
        } else {
            Log.d("dh503kim", "wtf")
        }
    }

    fun startGalleryActivity() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(intent, PICK_IMAGE)
    }

    fun loadAndSaveImage(data: Intent?) {
        val imageView: ImageView = findViewById(R.id.my_image)
        val inputStream : InputStream? = data?.data?.let { contentResolver?.openInputStream(it) }
        imageView.setImageBitmap(BitmapFactory.decodeStream(inputStream))
    }
}