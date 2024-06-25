package com.mascir.smartsensorfer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.mascir.smartsensorfer.Home.Companion.theSocket
import com.mascir.smartsensorfer.Login.Companion.sharedPreference
import com.mascir.smartsensorfer.bluetooth.bluetoothComponents
import com.mascir.smartsensorfer.databinding.FragmentIsfetBinding
import com.mascir.smartsensorfer.utils.IsfetCalibrationDialog
import com.mascir.smartsensorfer.utils.IsfetResultsDialog
import kotlinx.android.synthetic.main.fragment_isfet.view.*
import kotlinx.android.synthetic.main.fragment_spectro.view.*
import kotlinx.android.synthetic.main.res_items.view.*
import java.io.IOException
import java.util.HashMap

private lateinit var binding: FragmentIsfetBinding

class IsfetFragment : Fragment() {
    companion object {
        var a: String? = null
        var b: String? = null
        var Rcar: String? = null
        var calValues: Array<Double> = Array<Double>(3) { 0.0 }
        lateinit var vsg1: TextView
        lateinit var vsg2: TextView
        lateinit var vsg3: TextView
        var num: Int = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_isfet,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vsg1 = (view.table_layout.getChildAt(1) as TableRow).getChildAt(1) as TextView
        vsg2 = (view.table_layout.getChildAt(2) as TableRow).getChildAt(1) as TextView
        vsg3 = (view.table_layout.getChildAt(3) as TableRow).getChildAt(1) as TextView

        a = Login.sharedPreference.getString("a", null)
        b = Login.sharedPreference.getString("b", null)
        Rcar = Login.sharedPreference.getString("R", null)
        if (a.isNullOrEmpty() || b.isNullOrEmpty() || Rcar.isNullOrEmpty() || a == "NaN" || b == "NaN" || Rcar == "NaN") {
            view.IsfetLoadingText.text = "Le capteur doit être calibrer."
            view.IsfetLoadingText.visibility = View.VISIBLE
            view.aVal.text = "---"
            view.bVal.text = "---"
            view.RcarVal.text = "---"
            view.IsfetMesure.visibility = View.GONE
            view.paramText.visibility = View.GONE
            view.IsfetValue.visibility = View.GONE
            view.IsfetUnit.visibility = View.GONE
        } else {
            view.aVal.text = a
            view.bVal.text = b
            view.RcarVal.text = Rcar
        }
        view.showResults.setOnClickListener {
            IsfetResultsDialog().show(
                requireActivity().supportFragmentManager,
                "MyCustomFragment"
            )
        }
        view.IsfetMesure.setOnClickListener {
            if (view.numEchantIsfet.text.isNullOrEmpty()) {
                Toast.makeText(
                    requireView().context,
                    "Vous devez insérer le numéro d'échantillon",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                Mesure(view).execute(
                    Home.theDevice
                )
            }
        }
        view.IsfetCalibrate.setOnClickListener {
            calValues = Array<Double>(3) { 0.0 }
            num = 0
            CalIsfet(view, requireActivity()).execute()
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (isEnabled) {
                        isEnabled = false
                        view.findNavController()
                            .navigate(R.id.action_isfetFragment_to_fragmentMainMenu)
                    }
                }
            })
    }
}