package com.mascir.smartsensorfer.bluetooth

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice


import com.mascir.smartsensorfer.bluetooth.bluetoothComponents.mBluetoothAdapter


import java.util.*

object bluetoothComponents {
    var isCalibring = false
    var calibrated = false
    var isScanning = false
    val mBluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

}

typealias Reading = List<Pair<Float, Float>>


private val sensor_name_regex = "AgriSensor"
private val uuid: UUID = UUID.fromString(
    "94f39d29-7d6d-437d-973b-fba39e49d4ee"
)


fun fetchInPairedDevices(): Set<BluetoothDevice> {
    val pairedDevices: Set<BluetoothDevice>? = mBluetoothAdapter?.bondedDevices
    pairedDevices?.filter { isValidDevice(it.name) }

    return pairedDevices!!
}

val candidateNonPairedDevices: MutableSet<BluetoothDevice> = mutableSetOf()
fun isValidDevice(deviceName: String): Boolean {
    return deviceName.matches(Regex(sensor_name_regex))
}


val defaultTransformer: (String) -> Pair<Int, Reading> = { message ->
    val stringPairs: MutableList<String> = message.trim().split("//").toMutableList()
    val testResult = stringPairs.removeAt(0)

    if (stringPairs[stringPairs.lastIndex] == "") stringPairs.removeAt(stringPairs.lastIndex)

    val pairs: List<Pair<Float, Float>> = stringPairs.map {
        val pair = it.split("-")
        return@map Pair(pair[0].toFloat(), pair[1].toFloat())
    }

    Pair(testResult.toInt(), pairs)
}
val transform: (String) -> Pair<Int, Reading> = defaultTransformer


fun checkBluetooth(): Boolean {

    if (mBluetoothAdapter == null) {
        return false
    } else if (!mBluetoothAdapter.isEnabled) {
        return false
    }
    return true
}

