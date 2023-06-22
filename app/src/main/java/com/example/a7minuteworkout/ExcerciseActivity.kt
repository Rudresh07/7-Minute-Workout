package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.example.a7minuteworkout.databinding.ActivityExcerciseBinding

class ExcerciseActivity : AppCompatActivity() {

    private var binding: ActivityExcerciseBinding?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExcerciseBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        //binding the toolbar for the use
        setSupportActionBar(binding?.toolBar)

        //showing back button and implementing the back button
        if (supportActionBar!= null){

            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolBar?.setNavigationOnClickListener {
            onBackPressed()
        }

        progressTimer()
    }

    fun progressTimer() {

        val totalDuration: Long = 10000

        object : CountDownTimer(totalDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val progressBar = binding?.progressBar

                val secondLeft = millisUntilFinished / 1000
                binding?.timerCount?.text = secondLeft.toString()

                val progress = (( millisUntilFinished) * 100 / totalDuration).toInt()
                progressBar?.progress = progress
            }

            override fun onFinish() {
                binding?.timerCount?.text = "0"
                binding?.progressBar?.progress = 100
                Toast.makeText(applicationContext, "Timer finished", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }


    }
