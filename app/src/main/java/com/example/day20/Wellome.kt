package com.example.day20

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.day20.databinding.ActivityLoginBinding
import com.example.day20.databinding.ActivityWellomeBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Wellome : AppCompatActivity() {
    lateinit var binding: ActivityWellomeBinding
    lateinit var databass : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWellomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val name = binding.PersonName.text.toString()
            val nnumber = binding.phonenumber.text.toString()

            val con = usertow(name , nnumber)
            databass = FirebaseDatabase.getInstance().getReference("contact")
            databass.child(nnumber).setValue(con).addOnSuccessListener {
                Toast.makeText( this , "ADD" , Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this , "fail" , Toast.LENGTH_SHORT).show()
            }

            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Your contact is Add ")
            builder1.setMessage("press yes to exist")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            builder1.setNegativeButton("No" , DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder1.show()


        }


    }
}