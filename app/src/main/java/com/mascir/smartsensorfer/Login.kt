package com.mascir.smartsensorfer

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.mascir.smartsensorfer.httpReqs.AsyncCallerLogin
import com.mascir.smartsensorfer.utils.isOnline


class Login : AppCompatActivity() {

    companion object {
        var username: String = ""
        lateinit var sharedPreference: SharedPreferences
        var logged: Boolean = false
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreference = this.getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)

        var et_user_name = findViewById(R.id.et_user_name) as EditText
        var et_password = findViewById(R.id.et_password) as EditText
        var btn_submit = findViewById(R.id.btn_submit) as Button
        var progress = findViewById(R.id.login_progress) as ProgressBar
        btn_submit.setOnClickListener {
            /*progress.visibility = View.VISIBLE
            btn_submit.isEnabled = false*/

            username = et_user_name.text.toString().trim()
            val password = et_password.text.toString();
            if (username == "" || password == "") {
                Toast.makeText(this, "Toutes les informations sont requises", Toast.LENGTH_LONG)
                    .show()
            } else {

                val connectivity = isOnline(this)
                if (connectivity) {
                    AsyncCallerLogin(progress, btn_submit, this).execute(username, password)
                } else {
                    Toast.makeText(
                        this,
                        "Vérifier votre connexion internet et recommencer",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            }
        }
    }
}