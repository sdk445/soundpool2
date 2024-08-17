package com.xnimbus.soundpool
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.animation.OvershootInterpolator
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import com.xnimbus.soundpool.R


class startApp : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)
        val buttonBack: Button = findViewById(R.id.back_button)
        buttonBack.setOnClickListener {
            // Close this activity and return to the previous one
            finish()
        }

        val hwebbiew : WebView = findViewById(R.id.webview)
        val webSettings : WebSettings = hwebbiew.settings
        webSettings.javaScriptEnabled = true
        hwebbiew.webViewClient = WebViewClient()

        // HTML content with an embedded video
        val htmlContent = """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Video Player</title>
            </head>
            <body>
                <video width="100%" controls>
                    <source src="https://www.example.com/path/to/video.mp4" type="video/mp4">
                    Your browser does not support the video tag.
                </video>
            </body>
            </html>
        """
        hwebbiew.loadUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ")

    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")

    }

}
