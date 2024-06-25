package com.mascir.smartsensorfer.utils

import android.content.Context
import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class FileReaderCSV(private val context: Context) {
    fun ReadCsvY(filename: String): ArrayList<Double> {
        var fileReader: BufferedReader? = null
        val TArray = ArrayList<Double>()
        try {

            var line: String?

            fileReader =
                BufferedReader(FileReader("${context.getExternalFilesDir(null)}/tests/${filename}"))


            fileReader.readLine()
            fileReader.readLine()
            // to skip the sensor sn and the header (X,Y)
            line = fileReader.readLine()
            while (line != null) {
                val tokens = line.split(",")
                if (tokens.isNotEmpty()) {

                    TArray.add(tokens[1].toDouble())
                }

                line = fileReader.readLine()
            }


            /*for (TArra in TArray) {
                println(TArra)
            }*/

        } catch (e: Exception) {
            println("Reading CSV Error!")
            e.printStackTrace()
        } finally {
            try {
                fileReader!!.close()

            } catch (e: IOException) {
                println("Closing fileReader Error!")
                e.printStackTrace()
            }
        }
        return TArray
    }
}