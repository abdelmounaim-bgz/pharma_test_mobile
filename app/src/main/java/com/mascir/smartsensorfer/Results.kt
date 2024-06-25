package com.mascir.smartsensorfer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mascir.smartsensorfer.httpReqs.AsyncCallerNormal

private lateinit var resFe: TextView
private lateinit var resMg: TextView
private lateinit var resar: TextView
private lateinit var resarvs: TextView
private lateinit var reslm: TextView
private lateinit var reslmvs: TextView
private lateinit var resca: TextView
private lateinit var rescavs: TextView
private lateinit var resmo: TextView
private lateinit var resmovs: TextView
private lateinit var resnt: TextView
private lateinit var resntvs: TextView
private lateinit var resp: TextView
private lateinit var respvs: TextView

class Results : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        resFe = findViewById(R.id.fe_val)
        resMg = findViewById(R.id.mg_val)
        resar = findViewById(R.id.Ar_val)
        resarvs = findViewById(R.id.Ar_vs_val)
        reslm = findViewById(R.id.Lm_val)
        reslmvs = findViewById(R.id.Lm_vs_val)
        resca = findViewById(R.id.Ca_val)
        rescavs = findViewById(R.id.Ca_vs_val)
        resmo = findViewById(R.id.Mo_val)
        resmovs = findViewById(R.id.Mo_vs_val)
        resnt = findViewById(R.id.Nt_val)
        resntvs = findViewById(R.id.Nt_vs_val)
        resp = findViewById(R.id.p_val)
        respvs = findViewById(R.id.p_vs_val)

        val resFeVal: String = AsyncCallerNormal.objData.getString("resFE")
        val resMgVal: String = AsyncCallerNormal.objData.getString("resMg")
        val resarVal: String = AsyncCallerNormal.objData.getString("resAr")
        val resarvsVal: String = AsyncCallerNormal.objData.getString("resArvs")
        val reslmVal: String = AsyncCallerNormal.objData.getString("resLm")
        val reslmvsVal: String = AsyncCallerNormal.objData.getString("resLmvs")
        val rescaVal: String = AsyncCallerNormal.objData.getString("resCa")
        val rescavsVal: String = AsyncCallerNormal.objData.getString("resCavs")
        val resmoVal: String = AsyncCallerNormal.objData.getString("resMo")
        val resmovsVal: String = AsyncCallerNormal.objData.getString("resMovs")
        val resntVal: String = AsyncCallerNormal.objData.getString("resNt")
        val resntvsVal: String = AsyncCallerNormal.objData.getString("resNtvs")
        val respVal: String = AsyncCallerNormal.objData.getString("resP")
        val respvsVal: String = AsyncCallerNormal.objData.getString("resPvs")
        /*if (resFeVal == 0.0) {
            resFe.text = "La valeur a été perdu. Recommencer le scan."
        } else {
            resFe.text = resFeVal.toString()
        }
        if (resMgVal == 0.0) {
            resMg.text = "La valeur a été perdu. Recommencer le scan."
        } else {
            resMg.text = resMgVal.toString()
        }*/
        resFe.text = "$resFeVal  mg.kg\u207B\u00B9"
        resMg.text = "$resMgVal  mg.kg\u207B\u00B9"
        resar.text = "$resarVal %"
        resarvs.text = "$resarvsVal %"
        reslm.text = "$reslmVal %"
        reslmvs.text = "$reslmvsVal %"
        resca.text = "$rescaVal mg.kg\u207B\u00B9"
        rescavs.text = "$rescavsVal mg.kg\u207B\u00B9"
        resmo.text = "$resmoVal %"
        resmovs.text = "$resmovsVal %"
        resnt.text = "$resntVal mg.kg\u207B\u00B9"
        resntvs.text = "$resntvsVal mg.kg\u207B\u00B9"
        resp.text = "$respVal mg.kg\u207B\u00B9"
        respvs.text = "$respvsVal mg.kg\u207B\u00B9"

    }
}