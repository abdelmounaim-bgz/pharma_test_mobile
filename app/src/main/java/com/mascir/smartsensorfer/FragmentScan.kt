package com.mascir.smartsensorfer

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mascir.smartsensorfer.bluetooth.bluetoothComponents
import com.mascir.smartsensorfer.databinding.FragmentMainMenuBinding
import com.mascir.smartsensorfer.databinding.FragmentScanBinding
import kotlinx.android.synthetic.main.fragment_scan.view.*

private var locationManager: LocationManager? = null
private lateinit var binding: FragmentScanBinding

class FragmentScan : Fragment() {
    companion object {
        var scans: Int = 0
        var Tarray: MutableList<MutableList<Double>> = ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_scan, container, false
        )

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        locationManager =
            (activity as AppCompatActivity).getSystemService(AppCompatActivity.LOCATION_SERVICE) as LocationManager?
        var numEchant: String = ""
        view.scan_btn.isEnabled = false
        view.cal_btn.setOnClickListener {
            scans = 0
            Tarray = ArrayList()
            bluetoothComponents.isCalibring = true
            view.name.isEnabled = true
            Calibrate(
                view.scan_progress,
                view.scan_loading_text,
                view.insertion
            ).execute(Home.theDevice)

        }
        view.scan_btn.setOnClickListener {
            bluetoothComponents.isScanning = true
            /*
             if (scans == 4) {
                 try {
                     // Request location updates
                     locationManager?.requestLocationUpdates(
                         LocationManager.NETWORK_PROVIDER,
                         0L,
                         0f,
                         locationListener
                     )
                 } catch (ex: SecurityException) {
                     println("Security Exception, no location available")
                 }
                 view.name.isEnabled = true
             }*/
            TheScan(
                activity as AppCompatActivity,
                view.scan_progress,
                view.scan_loading_text,
                view.insertion,
                view.resView,
                numEchant
            ).execute(Home.theDevice)

        }
        view.resBtn.setOnClickListener {
            view.resView.visibility = View.GONE
            view.insertion.visibility = View.VISIBLE
        }
        view.name.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.toString() == "" || !bluetoothComponents.calibrated) {
                    view.scan_btn.isEnabled = false
                    numEchant = s.toString()
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.toString() != "" && bluetoothComponents.calibrated) {
                    view.scan_btn.isEnabled = true
                    numEchant = s.toString()
                }
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (binding.resView.visibility == View.VISIBLE) {
                        binding.resView.visibility = View.GONE
                        binding.insertion.visibility = View.VISIBLE
                    } else {
                        if (isEnabled) {
                            isEnabled = false
                            view.findNavController()
                                .navigate(R.id.action_fragmentScan_to_fragmentMainMenu)
                        }
                    }

                }
            })
    }

    /*private val locationListener: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            lng = location.longitude
            lat = location.latitude
            println("lat : " + lat + "\nlng : " + lng)
            locationManager!!.removeUpdates(this)
        }

        override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onProviderDisabled(provider: String) {}
    }*/

}