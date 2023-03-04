package org.lycancypher.navlayouts01.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import org.lycancypher.navlayouts01.R
import org.lycancypher.navlayouts01.common.utils.Constants.SPLASH_TIME

/* EN ESTA PANTALLA SE PONEN LOS PERMISOS DE LA APP */

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        load()
    }

    private fun load() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIME)
    }
}