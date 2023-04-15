package com.example.day20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.day20.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {

            val name = binding.usern.text.toString()
            val phnumber = binding.number.text.toString()
            val password = binding.pass.text.toString()

            val obe = user (name , phnumber , password )
            database = FirebaseDatabase.getInstance().getReference("user")
            database.child(phnumber).setValue(obe).addOnSuccessListener {
                Toast.makeText( this , "user Registered" , Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this , "user Register fail" , Toast.LENGTH_SHORT).show()
            }
            val  wellcome = Intent(this, Wellome::class.java)
            startActivity(wellcome)

        }
        binding.allreadysingin.setOnClickListener {
            val opnenewlogin = Intent(this,  login::class.java)
            startActivity(opnenewlogin)
        }
    }
}