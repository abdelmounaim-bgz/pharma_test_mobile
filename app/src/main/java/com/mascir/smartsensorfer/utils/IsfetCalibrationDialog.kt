package com.mascir.smartsensorfer.utils

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.mascir.smartsensorfer.*
import com.mascir.smartsensorfer.IsfetFragment.Companion.vsg1
import com.mascir.smartsensorfer.IsfetFragment.Companion.vsg2
import com.mascir.smartsensorfer.IsfetFragment.Companion.vsg3
import kotlinx.android.synthetic.main.fragment_isfet.*
import kotlinx.android.synthetic.main.fragment_isfet.view.*
import kotlinx.android.synthetic.main.isfet_calibration_dialog.view.*


class IsfetCalibrationDialog : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.isfet_calibration_dialog, container, false)
        isCancelable = false
        view.close_isfet_cal.setOnClickListener {
            dismiss()
        }
        view.IsfetCalibrateBtn.setOnClickListener {
            IsfetCalibrateAsync(
                view
            ).execute(Home.theDevice)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        vsg1.text = IsfetFragment.calValues[0].toString()
        vsg2.text = IsfetFragment.calValues[1].toString()
        vsg3.text = IsfetFragment.calValues[2].toString()
        activity!!.findViewById<TextView>(R.id.aVal).text = IsfetFragment.a
        activity!!.findViewById<TextView>(R.id.bVal).text = IsfetFragment.b
        activity!!.findViewById<TextView>(R.id.RcarVal).text = IsfetFragment.Rcar
        activity!!.findViewById<TextView>(R.id.IsfetMesure).visibility = View.VISIBLE
        activity!!.findViewById<TextView>(R.id.paramText).visibility = View.VISIBLE
        activity!!.findViewById<TextView>(R.id.IsfetValue).visibility = View.VISIBLE
        activity!!.findViewById<TextView>(R.id.IsfetUnit).visibility = View.VISIBLE
        ExitCalIsfet().execute()
    }

}