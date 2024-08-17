package com.xnimbus.soundpool

import com.xnimbus.soundpool.R
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.LinearInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.my_image_view)

        // Create a ValueAnimator for oscillation
        val oscillationAnimator = ValueAnimator.ofFloat(0f, 360f)
        oscillationAnimator.duration =
            1500 //Duration of one full oscillation cycle in milliseconds
        oscillationAnimator.interpolator = OvershootInterpolator() // Oscillation effect

        // Update the rotation property of the ImageView
        oscillationAnimator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Float
            imageView.rotation = animatedValue
        }
        // Set up an animation repeat mode to oscillate back and forth
        oscillationAnimator.repeatMode = ValueAnimator.REVERSE
        oscillationAnimator.repeatCount = ValueAnimator.INFINITE
        // Start the animation
        oscillationAnimator.start()
        val handler = HandlerCompat.createAsync(Looper.getMainLooper()) // Use the appropriate handler if necessary
        handler.postDelayed({
            // Use 'this@ActivityName' if you are in an Activity, or 'context' if you have a context reference
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            //startActivityFromFragment(cirecleFragment ::class.java,intent)
        }, 1500)
    }



}

