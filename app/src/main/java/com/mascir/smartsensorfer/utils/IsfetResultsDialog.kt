package com.mascir.smartsensorfer.utils

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.mascir.smartsensorfer.*
import com.mascir.smartsensorfer.IsfetFragment.Companion.vsg1
import com.mascir.smartsensorfer.IsfetFragment.Companion.vsg2
import com.mascir.smartsensorfer.IsfetFragment.Companion.vsg3
import kotlinx.android.synthetic.main.fragment_isfet.*
import kotlinx.android.synthetic.main.fragment_isfet.view.*
import kotlinx.android.synthetic.main.fragment_spectro.view.*
import kotlinx.android.synthetic.main.isfet_calibration_dialog.view.*
import kotlinx.android.synthetic.main.isfet_results_dialog.view.*
import java.util.ArrayList
import java.util.HashMap


class IsfetResultsDialog : DialogFragment() {
    var data: MutableList<Map<String, String>>? = ArrayList<Map<String, String>>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.isfet_results_dialog, container, false)
        val resFinal = Login.sharedPreference.all.map { it.key }

        if (resFinal.isEmpty()) {
            view.isfet_result_null.visibility = View.VISIBLE
            view.isfet_result_lv.visibility = View.GONE
        } else {
            for (i in resFinal.indices) {
                val datanu: MutableMap<String, String> =
                    HashMap<String, String>()
                if (resFinal[i] != "a" || resFinal[i] != "b" || resFinal[i] != "R") {
                    datanu["num"] = resFinal[i]
                    datanu["value"] =
                        Login.sharedPreference.getString(resFinal[i], "").toString()
                    data?.add(datanu)
                }

            }
        }
        val fromwhere: Array<String> = arrayOf("num", "value")
        val viewwhere: IntArray = intArrayOf(R.id.numEchantTxt, R.id.ValueTxt)
        var adapter = SimpleAdapter(
            activity as AppCompatActivity,
            data,
            R.layout.res_items,
            fromwhere,
            viewwhere
        )
        view.isfet_result_lv.adapter = adapter
        view.close_isfet_res.setOnClickListener {
            dismiss()
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.75).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }

}