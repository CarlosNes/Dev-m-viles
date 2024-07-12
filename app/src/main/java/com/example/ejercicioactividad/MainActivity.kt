package com.example.ejercicioactividad

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    val btningresar: Button=findViewById(R.id.btningresar)
        btningresar.setOnClickListener {
            val intent=Intent (this,PantalladeInicio::class.java)
            intent.putExtra("Nombres", "Carlos")
            startActivity(intent)
            Toast.makeText(this, "Bienvendido", Toast.LENGTH_SHORT).show()
        }
    }
}