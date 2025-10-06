package com.example.proyectobase

import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectobase.funciones.InsertarAlumnosAPI

class CamaraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_camara)

        val edNombre:EditText = findViewById(R.id.ed_nombre_camara)
        val edApellido:EditText = findViewById(R.id.ed_apellido_camara)
        val spGrupo:Spinner = findViewById(R.id.sp_grupo_camara)
        val spSeccion:Spinner = findViewById(R.id.sp_seccion_camara)
        val btnCamara:Button = findViewById(R.id.btn_tomar_foto)
        val btnGuardarCamara:Button = findViewById(R.id.btn_guardar_camara)

        var groups = listOf("1","2","3","4","5","6","7","8","9","10","11","12")
        var secciones = listOf("1","2","3","4","5","6","7","8","9","10","11","12")

        val adaptadorGrupos = ArrayAdapter(this,android.R.layout.simple_spinner_item,groups).apply(){
            setDropDownViewResource(android.R.layout.simple_spinner_item)
        }

        val adaptadorSeccion = ArrayAdapter(this,android.R.layout.simple_spinner_item,secciones).apply(){
            setDropDownViewResource(android.R.layout.simple_spinner_item)
        }

        spGrupo.adapter = adaptadorGrupos
        spSeccion.adapter = adaptadorSeccion

        btnGuardarCamara.setOnClickListener{
            InsertarAlumnosAPI.insertarAlumno(
                owner = this,
                context = this,
                nombre =  edNombre.text.toString(),
                apellido = edApellido.text.toString(),
                grupo = spGrupo.selectedItem.toString(),
                seccion = spSeccion.selectedItem.toString(),
                archivoBytes = null,
                onSuccess = {
                    println("termino insert correcto")
                    Toast.makeText(this,"guardado", Toast.LENGTH_SHORT).show()
                }


            )
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}