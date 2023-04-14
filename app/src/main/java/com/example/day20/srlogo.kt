package com.example.day20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class srlogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_srlogo)

        supportActionBar?.hide()
        Handler().postDelayed(
            {
                val Intent =  Intent(this, MainActivity::class.java)
                startActivity(Intent)
                finish()
            }, 2000
        )
    }
}

private fun Handler.postDelayed(function: () -> Unit) {

}
