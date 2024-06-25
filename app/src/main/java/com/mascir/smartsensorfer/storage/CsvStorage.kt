package com.mascir.smartsensorfer.storage

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.mascir.smartsensorfer.FragmentSpectro.Companion.sharedPreference

import com.mascir.smartsensorfer.bluetooth.Reading
import java.io.File
import java.io.IOException
import java.util.*

class CsvStorage(private val context: Context) {

    companion object {
        var nameOfFile = ""
        var nameOfFileAvg = ""
        var spectroId = ""
    }

    /*var editor = sharedPreference.edit()*/

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    fun saveReading(result: Pair<Int, Reading>, avg: MutableList<Double>) {
        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)

        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val seconds = c.get(Calendar.SECOND)

        val dateForSto = "$day/$month/$year $hour:$minute:$seconds"
        nameOfFileAvg = "avg_${year}${month}${day}-${hour}${minute}${seconds}.csv"
        val dir = File("${context.getExternalFilesDir(null)}/tests")
        if (!dir.exists()) dir.mkdir()
        val file = File(dir, nameOfFileAvg)
        /*editor.putString(nameOfFileAvg, dateForSto)
        editor.apply()
        editor.commit()*/
        val os = file.outputStream()
        try {
            val builder = StringBuilder()
            spectroId = result.first.toString()
            builder.append(spectroId + "\r\n")

            builder.append("X,Y\r\n")
            for (i in 0 until avg.size) {
                builder.append("${result.second[i].first},${avg[i]}\r\n")
            }
            /* result.second.forEach {
                 builder.append("${it.first}, ${it.second}\r\n")
             }*/
            os.write(builder.toString().toByteArray())
        } catch (ex: IOException) {
            ex.printStackTrace()
        } finally {
            os.close()

        }
    }

    @SuppressLint("NewApi")
    @RequiresApi(Build.VERSION_CODES.N)
    fun saveReadingFiles(result: Pair<Int, Reading>) {
        val c = Calendar.getInstance()

        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH) + 1
        val day = c.get(Calendar.DAY_OF_MONTH)

        val hour = c.get(Calendar.HOUR_OF_DAY)
        val minute = c.get(Calendar.MINUTE)
        val seconds = c.get(Calendar.SECOND)
        val dateForSto = "$day/$month/$year $hour:$minute:$seconds"
        nameOfFile = "${year}${month}${day}-${hour}${minute}${seconds}.csv"
        val dir = File("${context.getExternalFilesDir(null)}/tests")
        if (!dir.exists()) dir.mkdir()
        val file = File(dir, nameOfFile)
        /*editor.putString(nameOfFile, dateForSto)
        editor.apply()
        editor.commit()*/
        val os = file.outputStream()
        try {
            val builder = StringBuilder()
            spectroId = result.first.toString()
            builder.append(spectroId + "\r\n")

            builder.append("X,Y\r\n")

            result.second.forEach {
                builder.append("${it.first}, ${it.second}\r\n")
            }
            os.write(builder.toString().toByteArray())
        } catch (ex: IOException) {
            ex.printStackTrace()
        } finally {
            os.close()

        }
    }

}
