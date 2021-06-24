package id.scodeid.yorebahanmovie.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import id.scodeid.yorebahanmovie.R
import id.scodeid.yorebahanmovie.ui.home.HomeActivity
import kotlinx.coroutines.*

class MainSplashScreenActivity : AppCompatActivity() {

    companion object {
        private val TAG_LOG = MainSplashScreenActivity::class.java.simpleName
    }

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        coroutineScope.launch {
            delay(2000L)

            startActivity(Intent(this@MainSplashScreenActivity, HomeActivity::class.java))
            finish()
        }

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG_LOG, "onPause")
        coroutineScope.cancel()
    }
}