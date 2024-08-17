package com.xnimbus.soundpool

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class MainActivity2 : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView: ImageView = findViewById(R.id.circle_center)
        val textView: TextView = findViewById(R.id.anim_text)
        val button : Button = findViewById(R.id.button)
        // Create a ValueAnimator for oscillation
        val oscillationAnimator = ValueAnimator.ofFloat(0f, 360f)
        oscillationAnimator.duration =
            50000 //Duration of one full oscillation cycle in milliseconds
        oscillationAnimator.interpolator = OvershootInterpolator() // Oscillation effect

        // Update the rotation property of the ImageView
        oscillationAnimator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Float
            imageView.rotation = animatedValue
            Log.d("Number" , animatedValue.toString())
            textView.text = animatedValue.toString().split(".")[0]
        }
        // Set up an animation repeat mode to oscillate back and forth
        oscillationAnimator.repeatMode = ValueAnimator.REVERSE
        oscillationAnimator.repeatCount = ValueAnimator.INFINITE
        // Start the animation
        oscillationAnimator.start()
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")

    }
}