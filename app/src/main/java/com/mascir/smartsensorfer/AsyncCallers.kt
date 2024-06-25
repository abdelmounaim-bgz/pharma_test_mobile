package com.mascir.smartsensorfer

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.SharedPreferences

import android.os.AsyncTask
import android.os.Build
import android.view.View
import android.widget.*

import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import com.mascir.smartsensorfer.FragmentScan.Companion.Tarray


import com.mascir.smartsensorfer.FragmentScan.Companion.scans

import com.mascir.smartsensorfer.Home.Companion.theDevice
import com.mascir.smartsensorfer.Home.Companion.theSocket
import com.mascir.smartsensorfer.IsfetFragment.Companion.calValues

import com.mascir.smartsensorfer.IsfetFragment.Companion.num
import com.mascir.smartsensorfer.Login.Companion.sharedPreference
import com.mascir.smartsensorfer.bluetooth.bluetoothComponents
import com.mascir.smartsensorfer.bluetooth.bluetoothComponents.calibrated
import com.mascir.smartsensorfer.bluetooth.transform
import com.mascir.smartsensorfer.httpReqs.AsyncCallerIsfetSend
import com.mascir.smartsensorfer.httpReqs.AsyncCallerLogin
import com.mascir.smartsensorfer.httpReqs.AsyncCallerNormal
import com.mascir.smartsensorfer.httpReqs.AsyncCallerfiles
import com.mascir.smartsensorfer.storage.CsvStorage
import com.mascir.smartsensorfer.utils.IsfetCalibrationDialog
import kotlinx.android.synthetic.main.fragment_isfet.view.*
import kotlinx.android.synthetic.main.fragment_main_menu.view.*
import kotlinx.android.synthetic.main.isfet_calibration_dialog.view.*
import java.io.BufferedReader
import java.io.File

import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

class Calibrate(

    progress: ProgressBar,
    loadingText: TextView,
    insertion: ConstraintLayout
) :
    AsyncTask<BluetoothDevice, Void, Void>() {


    private val progress: ProgressBar? = progress
    private val loadingText: TextView? = loadingText
    private val insertion: ConstraintLayout? = insertion

    companion object {
        var resp = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()
        insertion!!.visibility = View.GONE
        loadingText!!.text = "calibration en cours ..."
        loadingText!!.visibility = View.VISIBLE
        progress!!.visibility = View.VISIBLE

    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        if (resp == "BCK_Done") {
            println("goooooooooooooooooooooood")
        }
        calibrated = true
        loadingText!!.visibility = View.GONE
        progress!!.visibility = View.GONE
        insertion!!.visibility = View.VISIBLE
        resp = ""

    }


    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {

        //Spectro.theSocket = theDevice!!.createRfcommSocketToServiceRecord(MainMenu.uuid)
        try {
            /*if (bluetoothComponents.mBluetoothAdapter.isDiscovering) bluetoothComponents.mBluetoothAdapter.cancelDiscovery()
            println("attempting connection to ${theDevice!!.name} ${theDevice!!.address}")
            Spectro.theSocket!!.connect()
            println("connected successfully to ${theDevice!!.name} ${theDevice!!.address}")*/

            val LAUNCH_BACKGROUND_COMMAND: ByteArray = "bg\r\n".toByteArray(Charsets.UTF_8)
            // Spectro.theSocket = theDevice!!.createRfcommSocketToServiceRecord(MainMenu.uuid)
            try {
                //if (bluetoothComponents.mBluetoothAdapter.isDiscovering) bluetoothComponents.mBluetoothAdapter.cancelDiscovery()
                val reader = BufferedReader(InputStreamReader(theSocket?.inputStream))
                val outputStream = theSocket?.outputStream
                var response = ""
                try {
                    outputStream?.write(LAUNCH_BACKGROUND_COMMAND)
                    response = reader.readLine()
                    resp = response
                    println("received $response")
                    bluetoothComponents.isCalibring = false


                } catch (e: IOException) {
                    println(e.message ?: "An error has occurred")
                    Home.theSocket!!.inputStream.close()
                    Home.theSocket!!.outputStream.close()
                    Home.theSocket!!.close()
                    //  SensorCommandResult.Failure(e)
                }




                true
            } catch (e: IOException) {
                println(e.message ?: "An error has occurred")
                false
            }

            if (theDevice == null || Home.theSocket == null) {
                println("we are here !!!")
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}

class Spectro(
    act: View

) :
    AsyncTask<BluetoothDevice, Void, Void>() {

    val act: View = act

    companion object {
        var resp = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()


        act.Menu.visibility = View.INVISIBLE

        act.BtLoadingText.text = "Configuration du capteur en cours ..."
        act.BtLoadingText.visibility = View.VISIBLE
        act.BtProgress.visibility = View.VISIBLE
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)


        act.Menu.visibility = View.VISIBLE
        act.BtLoadingText.visibility = View.INVISIBLE
        act.BtProgress.visibility = View.INVISIBLE
        act.findNavController()
            .navigate(R.id.action_fragmentMainMenu_to_fragmentScan)
    }


    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {
        val LAUNCH_SPECTRO: ByteArray = "spec\r\n".toByteArray(Charsets.UTF_8)
        try {
            val outputStream = Home.theSocket?.outputStream
            try {
                outputStream!!.write(LAUNCH_SPECTRO)
                println("sended $LAUNCH_SPECTRO")

                // Toast.makeText(act, "Analyse des sols", Toast.LENGTH_LONG)
                // .show()

            } catch (e: Exception) {
                println(e.message ?: "An error has occurred")
                when (e) {
                    is IOException -> {
                        Home.theSocket!!.inputStream.close()
                        Home.theSocket!!.outputStream.close()
                        Home.theSocket!!.close()
                    }
                    else -> {
                    }
                }
                println("failure")
            }
            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }
        return null
    }
}

class ExitSpectro() :
    AsyncTask<BluetoothDevice, Void, Void>() {
    companion object {
        var resp = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()


    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

    }


    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {

        val STOP_SPECTRO: ByteArray = "ex\r\n".toByteArray(Charsets.UTF_8)
        try {
            val outputStream = Home.theSocket!!.outputStream
            try {
                outputStream!!.write(STOP_SPECTRO)
                println("sended $STOP_SPECTRO")

                // Toast.makeText(act, "Analyse des sols", Toast.LENGTH_LONG)
                // .show()

            } catch (e: Exception) {
                println(e.message ?: "An error has occurred")
                when (e) {
                    is IOException -> {
                        Home.theSocket!!.inputStream.close()
                        Home.theSocket!!.outputStream.close()
                        Home.theSocket!!.close()
                    }
                    else -> {
                    }
                }
                println("failure")
            }
            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }
        return null
    }
}

class ExitCalIsfet() :
    AsyncTask<BluetoothDevice, Void, Void>() {
    companion object {
        var resp = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()


    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

    }


    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {

        val STOP_CAL_ISFET: ByteArray = "done\r\n".toByteArray(Charsets.UTF_8)
        try {
            val outputStream = Home.theSocket!!.outputStream
            try {
                outputStream!!.write(STOP_CAL_ISFET)
                println("sended $STOP_CAL_ISFET")

                // Toast.makeText(act, "Analyse des sols", Toast.LENGTH_LONG)
                // .show()

            } catch (e: Exception) {
                println(e.message ?: "An error has occurred")
                when (e) {
                    is IOException -> {
                        Home.theSocket!!.inputStream.close()
                        Home.theSocket!!.outputStream.close()
                        Home.theSocket!!.close()
                    }
                    else -> {
                    }
                }
                println("failure")
            }
            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }
        return null
    }
}

class Connect(act: View) : AsyncTask<BluetoothDevice, Void, Void>() {
    val act: View = act

    override fun onPreExecute() {
        super.onPreExecute()
        act.BtLoadingText.text = "Connexion au capteur en cours ..."
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        act.cnxBtn.visibility = View.VISIBLE
        act.BtCnxBtn.isEnabled = false
        act.Menu.visibility = View.VISIBLE
        act.poudre.isEnabled = true
        act.comprime.isEnabled = true
        act.liquid.isEnabled = true
        act.BtLoadingText.visibility = View.GONE
        act.BtProgress.visibility = View.GONE

    }

    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {
        theSocket = Home.theDevice!!.createRfcommSocketToServiceRecord(Home.uuid)
        try {
            println("attempting connection to ${Home.theDevice!!.name} ${Home.theDevice!!.address}")
            theSocket!!.connect()
            println("connected successfully to ${Home.theDevice!!.name} ${Home.theDevice!!.address}")
            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            bluetoothComponents.mBluetoothAdapter.cancelDiscovery()
            false
        }
        return null
    }
}

class LIsfet(
    act: View

) :
    AsyncTask<BluetoothDevice, Void, Void>() {

    val act: View = act

    companion object {
        var respIsfet = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()
        act.cnxBtn.visibility = View.GONE
        act.Menu.visibility = View.GONE

        act.BtLoadingText.text = "Configuration du capteur en cours ..."
        act.BtLoadingText.visibility = View.VISIBLE
        act.BtProgress.visibility = View.VISIBLE
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        act.cnxBtn.visibility = View.VISIBLE
        act.Menu.visibility = View.VISIBLE
        act.BtLoadingText.visibility = View.GONE
        act.BtProgress.visibility = View.GONE
        if (respIsfet == "ok") {
            act.findNavController()
                .navigate(R.id.action_fragmentMainMenu_to_isfetFragment)
        }
    }


    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {
        val LAUNCH_ISFET: ByteArray = "isfet\r\n".toByteArray(Charsets.UTF_8)
        try {
            val reader = BufferedReader(InputStreamReader(theSocket?.inputStream))
            val outputStream = theSocket?.outputStream
            var response = ""
            try {
                outputStream?.write(LAUNCH_ISFET)
                println("sended $LAUNCH_ISFET")
                response = reader.readLine()
                println("after read")
                respIsfet = response
                println("received $response")
                true
            } catch (e: IOException) {
                println(e.message ?: "An error has occurred")
                Home.theSocket!!.inputStream.close()
                Home.theSocket!!.outputStream.close()
                Home.theSocket!!.close()
            }
            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }

        return null
    }
}

class IsfetCalibrateAsync(

    view: View
) :
    AsyncTask<BluetoothDevice, Void, Void>() {

    private val view = view
    private val progress: ProgressBar? = view.IsfetCalibrateProgress
    private val loadingText: TextView? = view.IsfetCalibrateLoadingText
    private val insertion: EditText = view.IsfetCalibrateValue
    private val CalBtn: Button? = view.IsfetCalibrateBtn

    companion object {
        var resp = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()
        CalBtn!!.visibility = View.GONE
        loadingText!!.text = "Calibration en cours ..."
        loadingText!!.visibility = View.VISIBLE
        insertion!!.visibility = View.GONE
        progress!!.visibility = View.VISIBLE
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        println("post")
        println("the num : " + num)
        println("the array : " + Arrays.toString(calValues))
        if (num == 3) {
            val a: Double = calculateA(calValues)
            val b: Double = calcuateB(calValues, a)
            val RcarVal: Double = correlationCoefficient(calValues)
            println("a : " + a)
            println("b : " + b)
            println("R2 : " + RcarVal)
            var editor = Login.sharedPreference.edit()
            editor.putString("a", "%.3f".format(a))
            editor.putString("b", "%.3f".format(b))
            editor.putString("R", "%.3f".format(RcarVal))
            editor.apply()
            editor.commit()
            IsfetFragment.a = "%.3f".format(a)
            IsfetFragment.b = "%.3f".format(b)
            IsfetFragment.Rcar = "%.3f".format(RcarVal)
            progress!!.visibility = View.GONE
            loadingText!!.text = "Calibration terminé. Merci de fermer."
            return
        }
        loadingText!!.visibility = View.GONE
        progress!!.visibility = View.GONE
        insertion!!.visibility = View.VISIBLE
        CalBtn!!.visibility = View.VISIBLE
    }

    fun calculateA(
        x: Array<Double>
    ): Double {
        val y: Array<Double> = arrayOf(-2.0, -3.0, -1.0)
        val n = x.size

        // sum of array x
        val sx = x.sum()

        // sum of array y
        val sy = y.sum()

        val xavg = sx / n
        val yavg = sy / n

        // for sum of product of x and y
        var sxsy: Double = 0.0

        // sum of square of x
        var sx2: Double = 0.0
        for (i in 0 until n) {
            sxsy += (x[i] - xavg) * (y[i] - yavg)
            sx2 += Math.pow(y[i] - yavg, 2.0)
        }
        val a: Double = sxsy / sx2

        return a
    }

    fun calcuateB(
        X: Array<Double>, a: Double
    ): Double {
        val Y: Array<Double> = arrayOf(-2.0, -3.0, -1.0)
        // Finding b

        val n = X.size
        var meanX: Double = 0.0
        var meanY: Double = 0.0

        for (i in 0 until n) {
            meanX += X[i]
            meanY += Y[i]
        }
        meanX = meanX / n
        meanY = meanY / n

        // calculating a
        val b = meanX - a * meanY
        return b
    }

    fun correlationCoefficient(X: Array<Double>): Double {
        val y: Array<Double> = arrayOf(-2.0, -3.0, -1.0)
        val n = X.size

        // sum of array x
        val sx = X.sum()

        // sum of array y
        val sy = y.sum()

        val xavg = sx / n
        val yavg = sy / n

        var sxsy: Double = 0.0
        var sum_X = 0.0
        var sum_Y = 0.0
        var sum_XY = 0.0
        var squareSum_X = 0.0
        var squareSum_Y = 0.0

        for (i in 0 until n) {
            sxsy += (X[i] - xavg) * (y[i] - yavg)
            // sum of elements of array X.
            // sum of square of array elements.
            squareSum_X += Math.pow(X[i] - xavg, 2.0)
            squareSum_Y += Math.pow(y[i] - yavg, 2.0)
        }

        // use formula for calculating correlation
        // coefficient.
        val denom = Math.sqrt(squareSum_X * squareSum_Y)
        val corr: Double = Math.pow(sxsy / denom, 2.0)

        return corr
    }

    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {
        val send = insertion.text.trim().toString() + "\r\n"
        val LAUNCH_CAL_ISFET_COMMAND: ByteArray = send.toByteArray(Charsets.UTF_8)
        try {
            val reader = BufferedReader(InputStreamReader(theSocket?.inputStream))
            val outputStream = theSocket?.outputStream
            var response = ""
            try {
                outputStream!!.write(LAUNCH_CAL_ISFET_COMMAND)
                println("sended ${LAUNCH_CAL_ISFET_COMMAND}")

                if (insertion.text.toString() == "0") {
                    response = reader.readLine()
                    resp = response
                    println("received $response")
                } else {
                    response = reader.readLine()
                    resp = response
                    println("received $response")
                    calValues.set(
                        num, response.split("'")[1].toDouble()
                    )
                    num += 1
                }
            } catch (e: IOException) {
                println(e.message ?: "An error has occurred")
                //  SensorCommandResult.Failure(e)
            }
            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }

        return null
    }
}

class CalIsfet(
    view: View,
    act: Activity
) :
    AsyncTask<BluetoothDevice, Void, Void>() {

    val view: View = view
    val act: Activity = act

    companion object {
        var resp = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()
        view.IsfetLoadingText.text = "Lancement de la calibration ..."
        view.IsfetLoadingText.visibility = View.VISIBLE
        view.IsfetProgress.visibility = View.VISIBLE
        view.IsfetScreen.visibility = View.INVISIBLE
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        println("goooooooooooooooooooooood")
        view.IsfetLoadingText.visibility = View.INVISIBLE
        view.IsfetProgress.visibility = View.INVISIBLE
        view.IsfetScreen.visibility = View.VISIBLE
        IsfetCalibrationDialog().show(
            (act as AppCompatActivity).supportFragmentManager,
            "MyCustomFragment"
        )

    }


    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {
        val LAUNCH_ISFET_CAL: ByteArray = "cal\r\n".toByteArray(Charsets.UTF_8)
        try {
            val outputStream = Home.theSocket?.outputStream
            try {
                outputStream!!.write(LAUNCH_ISFET_CAL)
                println("sended $LAUNCH_ISFET_CAL")

                // Toast.makeText(act, "Analyse des sols", Toast.LENGTH_LONG)
                // .show()

            } catch (e: Exception) {
                println(e.message ?: "An error has occurred")
                when (e) {
                    is IOException -> {
                        Home.theSocket!!.inputStream.close()
                        Home.theSocket!!.outputStream.close()
                        Home.theSocket!!.close()
                    }
                    else -> {
                    }
                }
                println("failure")
            }
            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }
        return null
    }
}

class Mesure(
    view: View
) :
    AsyncTask<BluetoothDevice, Void, Void>() {

    val view = view


    companion object {
        var resp = ""
    }

    override fun onPreExecute() {
        super.onPreExecute()
        println("in pre")
        view.IsfetLoadingText.text = "Mesure en cours ..."
        view.IsfetLoadingText.visibility = View.VISIBLE
        view.IsfetProgress.visibility = View.VISIBLE
        view.IsfetScreen.visibility = View.INVISIBLE
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        println("goooooooooooooooooooooood")
        val delim = "'"
        val valuerec = resp.split(delim)[1].toDouble()
        ((view.table_layout.getChildAt(4) as TableRow).getChildAt(1) as TextView).text =
            valuerec.toString()
        val bD: Double = IsfetFragment.b!!.replace(",", ".").toDouble()
        val aD: Double = IsfetFragment.a!!.replace(",", ".").toDouble()
        val res: Double = (valuerec - bD) / aD
        view.IsfetValue.text = res.toString()
        val numEchant: String = view.numEchantIsfet.text.toString()
        var editor = Login.sharedPreference.edit()
        editor.putString(numEchant, "%.3f".format(valuerec))
        editor.apply()
        editor.commit()
        view.IsfetLoadingText.visibility = View.INVISIBLE
        view.IsfetProgress.visibility = View.INVISIBLE
        view.IsfetScreen.visibility = View.VISIBLE

    }


    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {

        try {
            val LAUNCH_MESURE_COMMAND: ByteArray = "mes\r\n".toByteArray(Charsets.UTF_8)

            try {
                val reader = BufferedReader(InputStreamReader(theSocket?.inputStream))
                val outputStream = theSocket?.outputStream
                var response = ""
                try {
                    outputStream?.write(LAUNCH_MESURE_COMMAND)
                    response = reader.readLine()
                    resp = response
                    println("received $response")
                } catch (e: IOException) {
                    println(e.message ?: "An error has occurred")
                    theSocket!!.inputStream.close()
                    theSocket!!.outputStream.close()
                    theSocket!!.close()
                    //  SensorCommandResult.Failure(e)
                }

                true
            } catch (e: IOException) {
                println(e.message ?: "An error has occurred")
                false
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null
    }
}

class Off() : AsyncTask<BluetoothDevice, Void, Void>() {
    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {
        val OFF_COMMAND: ByteArray = "off\r\n".toByteArray(Charsets.UTF_8)

        try {

            //val reader = BufferedReader(InputStreamReader(theSocket!!.inputStream))
            val outputStream = theSocket!!.outputStream

            try {
                outputStream.write(OFF_COMMAND)
                println("sended $OFF_COMMAND")
            } catch (e: Exception) {
                println(e.message ?: "An error has occurred")
                when (e) {
                    is IOException -> {
                        theSocket!!.inputStream.close()
                        theSocket!!.outputStream.close()
                        theSocket!!.close()
                    }
                    else -> {
                    }
                }
                println("failure")
            }

            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }
        return null
    }

}

class TheScan(
    context: Context,
    progress: ProgressBar,
    loadingText: TextView,
    insertion: ConstraintLayout,
    resView: LinearLayout,
    numEchant: String

) :
    AsyncTask<BluetoothDevice, Void, Void>() {
    var resFe: Double = 0.0
    var resMg: Double = 0.0
    private val context: Context? = context
    private val progress: ProgressBar? = progress
    private val loadingText: TextView? = loadingText
    private val insertion: ConstraintLayout? = insertion
    private val resView: LinearLayout? = resView
    private val numEchant: String? = numEchant

    companion object {

        var resp = ""
    }

    /*fun average(Tarrays: MutableList<MutableList<Double>>): MutableList<Double> {
        var avgTarray: MutableList<Double> = ArrayList()

        for (i in 0 until 1024) {
            var avg: Double = 0.0
            var sum: Double = 0.0
            Tarrays.forEach {
                sum += it[i]
            }
            avg = sum / 5
            avgTarray.add(avg)
        }
        println(avgTarray)
        return avgTarray
    }*/

    override fun onPreExecute() {
        super.onPreExecute()
        insertion!!.visibility = View.GONE
        loadingText!!.text = "Scan en cours ..."
        loadingText!!.visibility = View.VISIBLE
        progress!!.visibility = View.VISIBLE

    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        if (resp != "") {
            println("goooooooooooooooooooooooooooooood")
        }

        resp = ""
        /*if (scans == 4) {
            scans = 0
            val fileAvgName = CsvStorage.nameOfFileAvg
            val filename = CsvStorage.nameOfFile
            val spectro = CsvStorage.spectroId
            val fileAvgToSend =
                File("${context!!.getExternalFilesDir(null)}/tests/" + fileAvgName)
            val fileToSend = File("${context!!.getExternalFilesDir(null)}/tests/" + filename)
            AsyncCallerNormal(
                fileToSend,
                fileAvgToSend,
                this.context,
                progress!!,
                loadingText!!,
                insertion!!
            ).execute(
                spectro,
                numEchant,
                *//*   lat.toString(),
                   lng.toString(),*//*
                AsyncCallerLogin.user.getString("app")
            )
        } else {*/
        val filename = CsvStorage.nameOfFile
        val spectro = CsvStorage.spectroId
        val fileToSend =
            File("${context!!.getExternalFilesDir(null)}/tests/" + filename)

        AsyncCallerfiles(
            fileToSend,
            this.context,
            progress!!,
            loadingText!!,
            insertion!!,
            resView!!
        ).execute(spectro, numEchant)
        /*}*/

        /*val intent = Intent(context, Results::class.java)
        intent.putExtra("ResultFe", resFe)
        intent.putExtra("ResultMg", resMg)
        context!!.startActivity(intent)*/
    }


    @SuppressLint("MissingPermission")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun doInBackground(vararg p0: BluetoothDevice?): Void? {


        val LAUNCH_SCAN_COMMAND: ByteArray = "sc\r\n".toByteArray(Charsets.UTF_8)

        try {

            val reader = BufferedReader(InputStreamReader(Home.theSocket!!.inputStream))
            val outputStream = Home.theSocket!!.outputStream

            try {
                outputStream.write(LAUNCH_SCAN_COMMAND)
                println("sended $LAUNCH_SCAN_COMMAND")
                val message: String = reader.readLine()
                println(message)
                val result = transform(message)
                resp = result.toString()


                /* var TArray: MutableList<Double> = ArrayList()
                 result.second.forEach {
                     TArray.add(it.second.toDouble())
                 }
                 println(TArray[0])
                 Tarray.add(TArray)*/
                CsvStorage(context!!).saveReadingFiles(result)
                /*  if (scans == 4) {
                      val avgTarray = average(Tarray)
                      CsvStorage(context!!).saveReading(result, avgTarray)
                      Tarray = ArrayList()
                  }*/


                //resFe = CalculateRes(context!!).CalValFe(TArray)
                //resMg = CalculateRes(context!!).CalValMg(TArray)
                bluetoothComponents.isScanning = false

            } catch (e: Exception) {
                println(e.message ?: "An error has occurred")
                when (e) {
                    is IOException -> {
                        Home.theSocket!!.inputStream.close()
                        Home.theSocket!!.outputStream.close()
                        Home.theSocket!!.close()
                    }
                    else -> {
                    }
                }
                println("failure")
            }

            true
        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            false
        }
        if (theDevice == null || Home.theSocket == null) {
            println("we are here !!!")
        }

        return null
    }
}
