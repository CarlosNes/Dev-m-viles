package com.example.ejercicioactividad

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PantalladeInicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pantallade_inicio)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el nombre pasado por intent
        val nombreIntent = intent.getStringExtra("Nombres")
        // val txtnombre: TextView = findViewById(R.id.txtnombre)
        // txtnombre.text = nombreIntent
        // txtnombre.setTextColor(resources.getColor(R.color.my_custom_color, null))  // Cambia el color aquí

        val btnIngresar: Button = findViewById(R.id.btningresar)
        btnIngresar.setOnClickListener {
            val nombre: EditText = findViewById(R.id.edtnombre)
            val apellido: EditText = findViewById(R.id.edtapellido)
            val telefono: EditText = findViewById(R.id.edttelefono)
            val edad: EditText = findViewById(R.id.edtedad)
            val mail: EditText = findViewById(R.id.edtmail)

            if (nombre.text.isNotEmpty() && apellido.text.isNotEmpty() && telefono.text.isNotEmpty() && edad.text.isNotEmpty() && mail.text.isNotEmpty()) {
                val sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE)
                with(sharedPreferences.edit()) {
                    putString("nombre", nombre.text.toString())
                    putString("apellido", apellido.text.toString())
                    putString("telefono", telefono.text.toString())
                    putString("edad", edad.text.toString())
                    putString("mail", mail.text.toString())
                    apply()
                }

                val intent = Intent(this, SegundaPantalla::class.java)
                startActivity(intent)
            } else {
                // Mostrar mensaje de error o hacer algo si los campos no están llenos
            }
        }
    }
}
