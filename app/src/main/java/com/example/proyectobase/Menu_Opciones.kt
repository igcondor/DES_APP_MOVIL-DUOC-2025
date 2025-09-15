package com.example.proyectobase

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Menu_Opciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_opciones)

        val opcionesLV: ListView = findViewById(R.id.lv_menu_principal)
        val opcionesArr = arrayOf("Calculadora","Foro del racismo","Mi manifiesto","Porkyman","Estallido Social2"
        )
        //que es un array adapter?
        val adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,opcionesArr)

        opcionesLV.adapter = adaptador

        //evento para escuchar opcion seleccionada:
        opcionesLV.setOnItemClickListener{parent,view,position,id ->
            val itemElegido = parent.getItemAtPosition(position).toString()
            // y aqui la accion que quieres ejecutar
            Toast.makeText(this, itemElegido,Toast.LENGTH_SHORT).show()

            if (itemElegido == "Calculadora"){
                val nuevaVentana = Intent(this, Calculadora_ActivityV2::class.java)
                startActivity(nuevaVentana)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}