package com.example.ejercicioactividad;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SegundaPantalla extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        String nombre = sharedPreferences.getString("nombre", "");
        String apellido = sharedPreferences.getString("apellido", "");
        String telefono = sharedPreferences.getString("telefono", "");
        String edad = sharedPreferences.getString("edad", "");
        String mail = sharedPreferences.getString("mail", "");

        TextView txtNombre = findViewById(R.id.txtnombre);
        TextView txtApellido = findViewById(R.id.txtapellido);
        TextView txtTelefono = findViewById(R.id.txttelefono);
        TextView txtEdad = findViewById(R.id.txtedad);
        TextView txtMail = findViewById(R.id.txtmail); //TENES QUE MOSTRAR LOS DATOS POR MEDIO DE UN TXT

        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtTelefono.setText(telefono);
        txtEdad.setText(edad);
        txtMail.setText(mail);
    }
}
