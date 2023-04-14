package com.example.day20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.day20.databinding.ActivityLoginBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class login : AppCompatActivity() {

    companion object{
        const val KEY1 = "com.example.day20.SignInActivity.name"
        const val KEY2 = "com.example.day20.SignInActivity.number"
    }
    lateinit var databaseReference: DatabaseReference
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn2.setOnClickListener {
            val password = binding.pass2.text.toString()
            if (password.isEmpty()){
                readData(password)
            }else{
                Toast.makeText(this, "Please enter user name ", Toast.LENGTH_SHORT).show()
            }


        }

    }

    private fun readData(password: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("user")
        databaseReference.child(password).get().addOnSuccessListener {
            if (it.exists()){
                val name = it.child("name").value
                val number = it.child("phnumber").value

                val wellcome = Intent(this, Wellome::class.java)
                wellcome.putExtra(KEY1, name.toString())
                wellcome.putExtra(KEY2, number.toString())
                startActivity(wellcome)
            }else{
                Toast.makeText(this, "user not found ", Toast.LENGTH_SHORT).show()

            }


        }.addOnFailureListener {
            Toast.makeText(this, "fail ", Toast.LENGTH_SHORT).show()
        }
    }
}