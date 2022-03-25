package com.example.atv2mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ActivityContador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        var timesClicked = 0
        val textView = findViewById<TextView>(R.id.textView)
        val btnClickMe = findViewById<Button>(R.id.mybutton)
        btnClickMe.setOnClickListener {
            timesClicked++
            textView.text = timesClicked.toString()
            Toast.makeText(this, "Hey, I'm a Toast", Toast.LENGTH_SHORT).show()
        }
    }
}