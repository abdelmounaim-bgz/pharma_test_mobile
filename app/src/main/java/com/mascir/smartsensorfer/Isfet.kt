package com.mascir.smartsensorfer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mascir.smartsensorfer.bluetooth.bluetoothComponents
import com.mascir.smartsensorfer.utils.IsfetCalibrationDialog
import java.io.IOException

private lateinit var MesureBtn: Button
private lateinit var IsfetProgressBar: ProgressBar
private lateinit var IsfetLoadingText: TextView
private lateinit var IsfetValueText: TextView
private lateinit var IsfetScreen: ConstraintLayout
private lateinit var IsfetCalibration: FloatingActionButton

class Isfet : AppCompatActivity() {
    companion object {
        var calibrationNum = 4
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isfet)

        MesureBtn = findViewById(R.id.IsfetMesure)
        IsfetCalibration = findViewById(R.id.IsfetCalibrate)
        IsfetProgressBar = findViewById(R.id.IsfetProgress)
        IsfetScreen = findViewById(R.id.IsfetScreen)
        IsfetLoadingText = findViewById(R.id.IsfetLoadingText)
        IsfetValueText = findViewById(R.id.IsfetValue)

        MesureBtn.setOnClickListener {

        }
        IsfetCalibration.setOnClickListener {


        }
    }


}