package com.example.atv2mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCont:Button = findViewById(R.id.btnCont)
        val btnCalc:Button = findViewById(R.id.btnCalc)
        val btnAge :Button = findViewById(R.id.btnAge)

        btnCont.setOnClickListener{
            Toast.makeText(this, "Abrindo projeto contador", Toast.LENGTH_SHORT).show()
            val intentCont = Intent(this, ActivityContador::class.java)
            startActivity(intentCont)
        }

        btnCalc.setOnClickListener{
            Toast.makeText(this,"Abrindo projeto calculadora", Toast.LENGTH_SHORT).show()
            val intentCalc = Intent(this, ActivityCalculadora::class.java)
            startActivity(intentCalc)
        }

        btnAge.setOnClickListener{
            Toast.makeText(this, "Abrindo projeto idade em minutos", Toast.LENGTH_SHORT).show()
            val intentAge = Intent(this, ActivityIdade::class.java)
            startActivity(intentAge)
        }
    }

}