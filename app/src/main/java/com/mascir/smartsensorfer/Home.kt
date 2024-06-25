package com.mascir.smartsensorfer

import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.mascir.smartsensorfer.databinding.ActivityHomeBinding
import java.util.*


class Home : AppCompatActivity() {
    companion object {
        var theDevice: BluetoothDevice? = null
        var theSocket: BluetoothSocket? = null
        val uuid: UUID = UUID.fromString(
            "94f39d29-7d6d-437d-973b-fba39e49d4ee"
        )
        var connected = false
    }

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(
            this,
            R.layout.activity_home
        )
        drawerLayout = binding.drawerLayout

        val navController = this.findNavController(R.id.myNavHostFragment)

        //NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}