package com.mascir.smartsensorfer

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.AdapterView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mascir.smartsensorfer.Home.Companion.theDevice
import com.mascir.smartsensorfer.Home.Companion.theSocket
import com.mascir.smartsensorfer.Home.Companion.uuid
import com.mascir.smartsensorfer.bluetooth.bluetoothComponents
import com.mascir.smartsensorfer.databinding.FragmentMainMenuBinding
import com.mascir.smartsensorfer.databinding.FragmentScanBinding
import com.mascir.smartsensorfer.databinding.FragmentSpectroBinding
import com.mascir.smartsensorfer.utils.FileReaderCSV
import kotlinx.android.synthetic.main.fragment_spectro.view.*
import java.io.File
import java.io.IOException
import java.util.ArrayList
import java.util.HashMap

private lateinit var adapter: SimpleAdapter
private lateinit var binding: FragmentSpectroBinding

class FragmentSpectro : Fragment() {
    companion object {
        lateinit var sharedPreference: SharedPreferences
    }

    var exists = false

    var data: MutableList<Map<String, String>>? = ArrayList<Map<String, String>>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_spectro, container, false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreference = (activity as AppCompatActivity).getSharedPreferences(
            "PREFERENCE_NAME",
            Context.MODE_PRIVATE
        )
        val scans = sharedPreference.all.map { it.key }
        if (scans.isEmpty()) {
            view.scans_list.visibility = View.GONE
            view.no_scans.visibility = View.VISIBLE
        } else {
            exists = true
            for (i in scans.indices) {
                val datanu: MutableMap<String, String> =
                    HashMap<String, String>()
                datanu["name"] = scans[i]
                datanu["date"] = sharedPreference.getString(scans[i], "").toString()
                data?.add(datanu)
            }
        }
        val fromwhere: Array<String> = arrayOf("name", "date")
        val viewwhere: IntArray = intArrayOf(R.id.name, R.id.date)
        adapter = SimpleAdapter(
            activity as AppCompatActivity,
            data,
            R.layout.scans_items,
            fromwhere,
            viewwhere
        )
        view.scans_list.adapter = adapter
        view.new_scan.setOnClickListener {
            /*view.findNavController().navigate(R.id.action_fragmentSpectro_to_fragmentScan)*/
        }
        registerForContextMenu(view.scans_list)
        view.scans_list.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                view.scans_list.showContextMenuForChild(view)
                println("pressed on $position")
            }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (isEnabled) {
                        isEnabled = false
                        ExitSpectro().execute(theDevice)
                        /*view.findNavController()
                            .navigate(R.id.action_fragmentSpectro_to_fragmentMainMenu)*/
                    }
                }
            })
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val item = data?.get(info.position)
        menu!!.setHeaderTitle("menu pour: " + item?.get("name"))
        val inflater: MenuInflater = (activity as AppCompatActivity).menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //return super.onContextItemSelected(item)
        val selectedItemOrder = item!!.order
        //Get Title Of Selected Item
        val selectedItemTitle = item.title
        //To get Name of Person Click on ListView
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val listPosition = info.position
        val name = data?.get(listPosition)?.get("name")

        /*Toast.makeText(this@MainActivity, " $selectedItemTitle $name", Toast.LENGTH_LONG)
            .show()*/
        return when (item.itemId) {
            R.id.details -> {
                /*val TArray = FileReaderCSV(this).ReadCsvY(name!!)
                // println("this is the ta: $TArray")
                val resFe = CalculateRes(this).CalValFe(TArray)
                val resMg = CalculateRes(this).CalValMg(TArray)
                //println("the res is :${res}")
                val intent = Intent(this, Results::class.java)
                intent.putExtra("ResultFe", resFe)
                intent.putExtra("ResultMg", resMg)
                startActivity(intent)*/
                true
            }
            R.id.delete -> {

                deleteScan(listPosition!!)

                Toast.makeText(activity as AppCompatActivity, "supprimé", Toast.LENGTH_LONG)
                    .show()
                true
            }
            else -> super.onContextItemSelected(item)
        }


    }

    private fun deleteScan(listPosition: Int) {
        val name = data!![listPosition]["name"]
        data!!.removeAt(listPosition)
        adapter.notifyDataSetChanged()

        if (exists) {
            var editor = sharedPreference.edit()
            editor.remove(name)
            editor.apply()
            editor.commit()

            val file =
                File("${(activity as AppCompatActivity).getExternalFilesDir(null)}/tests/${name}")
            if (file.exists()) file.delete()
        }
        if (data!!.isEmpty()) {
            requireView().scans_list.visibility = View.GONE
            requireView().no_scans.visibility = View.VISIBLE
        }
    }
}