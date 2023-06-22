package com.example.a7minuteworkout

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a7minuteworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding?.root
        setContentView(view)

        binding?.flStart?.setOnClickListener {
            val intent = Intent(this, ExcerciseActivity::class.java)
            startActivity(intent)
        }


    }


    //this will again set the binding to null so that no error occur in further process
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}