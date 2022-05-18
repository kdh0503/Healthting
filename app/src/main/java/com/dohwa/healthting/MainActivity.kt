package com.dohwa.healthting

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainlayout)
        Log.d("dh503kim", "onCreate")
        val imageView : ImageView = findViewById(R.id.my_image)
        imageView.setOnClickListener { Log.d("dh503kim", "onclick") }
    }
}