package com.mascir.smartsensorfer

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.mascir.smartsensorfer.Home.Companion.connected
import com.mascir.smartsensorfer.Home.Companion.theSocket
import com.mascir.smartsensorfer.Home.Companion.uuid
import com.mascir.smartsensorfer.bluetooth.bluetoothComponents
import com.mascir.smartsensorfer.bluetooth.checkBluetooth
import com.mascir.smartsensorfer.bluetooth.isValidDevice
import com.mascir.smartsensorfer.databinding.FragmentMainMenuBinding
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_main_menu.*
import kotlinx.android.synthetic.main.fragment_main_menu.view.*

import kotlinx.android.synthetic.main.fragment_scan.view.*
import java.io.IOException
import java.util.*
import kotlin.system.exitProcess

class FragmentMainMenu : Fragment() {

    private lateinit var binding: FragmentMainMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_main_menu, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // val view = inflater.inflate(R.layout.fragment_main_menu, container, false)
        view.BtCnxBtn.setOnClickListener {

            toLoading("Recherche d'un capteur à proximité ...")
            if (!checkBluetooth()) {
                val builder = AlertDialog.Builder(activity as AppCompatActivity)
                builder.setTitle("Activer votre bluetooth")
                builder.setMessage("Veuillez activer votre bluetooth afin d'assurer la connexion avec le capteur")
                builder.setPositiveButton("D'accord") { dialog, which ->
                    val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                    startActivityForResult(enableBtIntent, 1000)
                }
                builder.show()

            } else {
                requestPermissions()
                statusCheck()
            }
        }

        /*   view.on_off.isChecked = true
           view.on_off?.setOnCheckedChangeListener { _, isChecked ->

               if (!isChecked) {
                   Toast.makeText(
                       activity as AppCompatActivity, "off",
                       Toast.LENGTH_SHORT
                   ).show()
                   view.on_off.isEnabled = false
                   Off().execute()
                   view.BtConnect.isEnabled = true
                   view.green_check.visibility = View.GONE
               }

           }*/
        /* view.BtConnectScan.setOnClickListener {
             navigateToChecks()
         }*/

        view.poudre.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentMainMenu_to_fragmentScan)
        }
        view.comprime.setOnClickListener {
            println(" ")
            Toast.makeText(requireActivity(), "Indisponible pour le moment", Toast.LENGTH_SHORT)
                .show()
        }
        view.liquid.setOnClickListener {
            println(" ")
            Toast.makeText(requireActivity(), "Indisponible pour le moment", Toast.LENGTH_SHORT)
                .show()

        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (bluetoothComponents.mBluetoothAdapter.isDiscovering) {
                        bluetoothComponents.mBluetoothAdapter.cancelDiscovery()

                    }
                    if (binding.BtProgress.visibility == View.VISIBLE) {
                        binding.BtProgress.visibility = View.GONE
                        binding.BtLoadingText.visibility = View.GONE
                        binding.cnxBtn.visibility = View.VISIBLE
                        binding.Menu.visibility = View.VISIBLE
                    } else {
                        val builder = AlertDialog.Builder(activity as AppCompatActivity)
                        builder.setTitle("Quitter l'application")
                        builder.setMessage("Voullez-vous quitter l'application ?")
                        builder.setPositiveButton("Oui") { dialog, which ->
                            (activity as AppCompatActivity).moveTaskToBack(true);
                            exitProcess(-1)
                        }
                        builder.setNegativeButton("Non") { dialog, which ->
                            dialog.dismiss()
                        }
                        builder.show()
                    }

                }
            }
        )
    }

    private fun buildAlertMessageNoGps() {
        val builder =
            AlertDialog.Builder((activity as AppCompatActivity))
        builder.setMessage("Veuillez activer votre localisation et recommencer")
            .setCancelable(false)
            .setPositiveButton(
                "D'accord"
            ) { dialog, id ->
                startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            }
            .setNegativeButton(
                "Non"
            ) { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

    private fun navigateToChecks() {
        findNavController().navigate(R.id.fragmentScan)
    }

    private fun searchBl() {
        if (bluetoothComponents.mBluetoothAdapter.isDiscovering) {
            bluetoothComponents.mBluetoothAdapter.cancelDiscovery()
        }
        bluetoothComponents.mBluetoothAdapter.startDiscovery()
        val bluetoothFilter = IntentFilter()
        bluetoothFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
        bluetoothFilter.addAction(BluetoothDevice.ACTION_FOUND)
        bluetoothFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        (activity as AppCompatActivity).registerReceiver(receiver, bluetoothFilter)
    }

    private val receiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {

            val action: String? = intent?.action
            when (action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device: BluetoothDevice =
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)!!
                    println("found a device ${device?.name} ${device?.address}")
                    if (device?.name != null && isValidDevice(device.name)) {
                        bluetoothComponents.mBluetoothAdapter.cancelDiscovery()
                        Home.theDevice = device
                        connected = true
                        /*toScans()*/
                        Connect(binding.root).execute()
                        /*binding.BtLink.isEnabled = false*/
                        /*theSocket = device!!.createRfcommSocketToServiceRecord(uuid)
                        try {
                            println("attempting connection to ${device.name} ${device.address}")
                            theSocket!!.connect()
                            println("connected successfully to ${device.name} ${device.address}")

                        } catch (e: IOException) {
                            println(e.message ?: "An error has occurred")
                            bluetoothComponents.mBluetoothAdapter.cancelDiscovery()
                            /*Toast.makeText(
                                context,
                                "impossible de se connecter",
                                Toast.LENGTH_SHORT
                            ).show()*/

                            false
                        }*/
                    }
                }
            }
        }
    }

    private fun attemptConnection() {
        theSocket = Home.theDevice!!.createRfcommSocketToServiceRecord(uuid)
        try {
            println("attempting connection to ${Home.theDevice!!.name} ${Home.theDevice!!.address}")
            theSocket!!.connect()
            println("connected successfully to ${Home.theDevice!!.name} ${Home.theDevice!!.address}")

        } catch (e: IOException) {
            println(e.message ?: "An error has occurred")
            bluetoothComponents.mBluetoothAdapter.cancelDiscovery()
            /*Toast.makeText(
                context,
                "impossible de se connecter",
                Toast.LENGTH_SHORT
            ).show()*/

            false
        }
    }

    private fun statusCheck() {
        val manager: LocationManager =
            (activity as AppCompatActivity).getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps()
        } else {
            searchBl()
        }
    }

    private fun requestPermissions() {
        val requestCode = 1
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            when (ContextCompat.checkSelfPermission(
                (activity as AppCompatActivity),
                Manifest.permission.ACCESS_FINE_LOCATION
            )) {
                PackageManager.PERMISSION_DENIED -> (AlertDialog.Builder((activity as AppCompatActivity))
                    .setTitle("Pemission demandé")
                    .setMessage(
                        Html.fromHtml(
                            "<p>Afin de détecter les appareils à proximité, Veuillez autoriser a l'application l'accès à votre localisation.</p>" +
                                    "<p>Pour plus d'informations, appuyer <a href=\"http://developer.android.com/about/versions/marshmallow/android-6.0-changes.html#behavior-hardware-id\">ici</a>.</p>"
                        )
                    )
                    .setNeutralButton(
                        "d'accord!"
                    ) { dialog, which ->
                        if (ContextCompat.checkSelfPermission(
                                (activity as AppCompatActivity),
                                Manifest.permission.ACCESS_FINE_LOCATION
                            ) != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                (activity as AppCompatActivity),
                                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                                requestCode
                            )

                        }
                    }
                    .show()
                    .findViewById<View>(android.R.id.message) as TextView?)
                    ?.movementMethod = LinkMovementMethod.getInstance()
                PackageManager.PERMISSION_GRANTED -> {
                    // toScans()
                }
            }
        }
    }


    private fun toScans() {
        binding.BtProgress.visibility = View.GONE
        binding.BtLoadingText.visibility = View.GONE
        binding.cnxBtn.visibility = View.VISIBLE
        binding.Menu.visibility = View.VISIBLE
    }

    private fun toLoading(load: String) {
        binding.anoucement.visibility = View.GONE
        binding.BtLoadingText.text = load
        binding.BtLoadingText.visibility = View.VISIBLE
        binding.BtProgress.visibility = View.VISIBLE
        binding.cnxBtn.visibility = View.GONE
        binding.Menu.visibility = View.GONE
    }
}