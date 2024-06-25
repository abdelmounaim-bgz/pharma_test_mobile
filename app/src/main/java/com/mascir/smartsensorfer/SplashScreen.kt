package com.mascir.smartsensorfer

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import androidx.annotation.RequiresApi

/*import com.mascir.smartsensorfer.httpReqs.ForceUpdateAsync*/

class SplashScreen : AppCompatActivity() {
    private lateinit var progress: ProgressBar
    private lateinit var updateBtn: Button

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        /*  val connectivity = isOnline(this)

          progress = findViewById(R.id.progressBarSplash)
          updateBtn = findViewById(R.id.updateBtn)
          if (connectivity) {
              updateBtn.setOnClickListener {
                  startActivity(
                      Intent(
                          Intent.ACTION_VIEW,
                          Uri.parse("market://details?id=org.mascir.rnascansensor")
                      )
                  )
              }
              forceUpdate()
          } else {
              Toast.makeText(
                  this,
                  "Pas de connexion internet. Veuillez vérifier votre connexion et recommencer.",
                  Toast.LENGTH_LONG
              ).show()
              progress.visibility = View.GONE
              updateBtn.text = "Recommencer"
              updateBtn.visibility = View.VISIBLE
              updateBtn.setOnClickListener {
                  finish()
                  overridePendingTransition(0, 0)
                  startActivity(intent)
                  overridePendingTransition(0, 0)
              }
          }*/
        Handler().postDelayed({
            val intent = Intent(this, Home::class.java)
            this.startActivity(intent)
            //doSomethingHere()
        }, 3000)

    }

    /*fun forceUpdate() {
        val packageManager = this.packageManager
        var packageInfo: PackageInfo? = null
        try {
            packageInfo = packageManager.getPackageInfo(packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        val currentVersion = packageInfo!!.versionName
        ForceUpdateAsync(currentVersion, this, progress, updateBtn).execute()
    }*/
}