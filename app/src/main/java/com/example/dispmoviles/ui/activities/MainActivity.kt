package com.example.dispmoviles.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.dispmoviles.R
import com.example.dispmoviles.databinding.ActivityMainBinding
import com.example.dispmoviles.databinding.ActivitySecondBinding
import com.example.dispmoviles.logic.validator.LoginValidator
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStart(){
        super.onStart()
        initClass()
    }

    private fun initClass(){
        Log.d("UCE", "Entrando a start")

        binding.buttonIngresar.setOnClickListener{

            val check = LoginValidator().checklogin(
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextTextPassword.text.toString()
            )

            if(check) {
                var intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("var1", binding.editTextTextEmailAddress.toString())
                startActivity(intent)
                /*Snackbar.make(binding.txtBienvenida ,"Correcto",
                    Snackbar.LENGTH_LONG).show()*/
            }else{
                /*Snackbar.make(binding.txtCorreo ,"usuario o contrasenia invalidos",
                    Snackbar.LENGTH_LONG).show()*/

            }
        }
    }
}