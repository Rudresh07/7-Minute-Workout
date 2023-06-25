package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.a7minuteworkout.databinding.ActivityExcerciseBinding

class ExcerciseActivity : AppCompatActivity() {

    private var binding: ActivityExcerciseBinding?= null

    private var restTimer: CountDownTimer? = null
    private var restProgress =0

    private var ExcerciseTimer: CountDownTimer? = null
    private var ExcerciseProgress =0

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

        setRestView()
        }



    private fun setRestView(){



        if (restTimer!=null){
            restTimer?.cancel()
            restProgress=0
        }

        progressRestTimer()

    }

    private fun SetExcerciseView(){

        binding?.flTimer?.visibility = View.INVISIBLE
        binding?.tv2ndScreen?.text = "Excercise Name"
        binding?.flExcerciseTimer?.visibility = View.VISIBLE
        if (ExcerciseTimer!=null){
            ExcerciseTimer?.cancel()
            ExcerciseProgress=0
        }

        progressExcerciseTimer()
    }


    private fun progressRestTimer() {
 binding?.progressBar?.progress = restProgress
        val totalDuration: Long = 10000

        object : CountDownTimer(totalDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                restProgress++
                binding?.progressBar?.progress = 10-restProgress

                val secondLeft = millisUntilFinished / 1000
                binding?.timerCount?.text = secondLeft.toString()



            }

            override fun onFinish() {
                SetExcerciseView()

            }
        }.start()
    }



    fun progressExcerciseTimer() {
        binding?.excerciseProgressBar?.progress = ExcerciseProgress
        val totalDuration: Long = 30000

        object : CountDownTimer(totalDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {

                ExcerciseProgress++
                binding?.excerciseProgressBar?.progress = 30-ExcerciseProgress

                val secondLeft = millisUntilFinished / 1000
                binding?.timerCountExcercise?.text = secondLeft.toString()



            }

            override fun onFinish() {

                Toast.makeText(applicationContext, "Timer finished", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onDestroy() {


        if (restTimer!=null){
            restTimer?.cancel()
            restProgress=0
        }


        super.onDestroy()
        binding =null
    }

    }
