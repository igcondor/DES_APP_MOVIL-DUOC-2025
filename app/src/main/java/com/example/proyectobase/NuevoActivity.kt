package com.example.proyectobase

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//IMPORT PACKAGE CUSTOM UTILS PARA CALCULAR
import com.example.proyectobase.utils.OPMatematicas

class NuevoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nuevo)
        val number1:EditText = findViewById(R.id.edNumber1)
        val number2:EditText = findViewById(R.id.edNumber2)
        val txtResultado:TextView = findViewById(R.id.txtResultado)
        val btnCalcular:Button = findViewById(R.id.btnCalcular)

        btnCalcular.setOnClickListener {
            var valor1:Int = number1.text.toString().toIntOrNull() ?:0
            var valor2:Int = number2.text.toString().toIntOrNull() ?:0

            var resultadoOP: Int = OPMatematicas.sumar(valor1,valor2)
            txtResultado.text = resultadoOP.toString()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}