package com.mascir.smartsensorfer

import android.content.Context
import com.mascir.smartsensorfer.utils.*
import com.mascir.smartsensorfer.utils.ModelFe.modelFe1
import com.mascir.smartsensorfer.utils.ModelFe.modelFe2
import com.mascir.smartsensorfer.utils.ModelFe.modelFe3
import com.mascir.smartsensorfer.utils.ModelG.modelG1
import com.mascir.smartsensorfer.utils.ModelG.modelG2
import com.mascir.smartsensorfer.utils.ModelG.modelG3
import java.lang.Math.exp

class CalculateRes(private val context: Context) {
    fun CalValFe(TArray: MutableList<Double>): Double {
        var res1 = 0.0
        var res2 = 0.0
        var res3 = 0.0
        for (i in 0 until TArray.size) {
            res1 += (TArray[i] * modelFe1[i])
            res2 += (TArray[i] * modelFe2[i])
            res3 += (TArray[i] * modelFe3[i])
        }
        println("res1: " + res1 + "res2 : " + res2 + "res3 : " + res3)
        return when (val max = maxOf(res1, res2, res3)) {
            res1 -> {
                Calres(TArray, ModelFePredict1.MFP1, ModelFePredict1.MFP1C, ModelFePredict1.MFP1I)

            }
            res2 -> {
                Calres(TArray, ModelFePredict2.MFP2, ModelFePredict2.MFP2C, ModelFePredict2.MFP2I)
            }
            else -> {
                Calres(TArray, ModelFePredict3.MFP3, ModelFePredict3.MFP3C, ModelFePredict3.MFP3I)
            }
        }
    }

    fun CalValMg(TArray: MutableList<Double>): Double {
        var res1 = 0.0
        var res2 = 0.0
        var res3 = 0.0
        for (i in 0 until TArray.size) {
            res1 += (TArray[i] * modelG1[i])
            res2 += (TArray[i] * modelG2[i])
            res3 += (TArray[i] * modelG3[i])
        }
        println("res1: " + res1 + "res2 : " + res2 + "res3 : " + res3)
        return when (val max = maxOf(res1, res2, res3)) {
            res1 -> {
                Calres(TArray, ModelGePredict1.MGP1, ModelGePredict1.MGP1C, ModelGePredict1.MGP1I)
            }
            res2 -> {
                Calres(TArray, ModelGePredict2.MGP2, ModelGePredict2.MGP2C, ModelGePredict2.MGP2I)
            }
            else -> {
                Calres(TArray, ModelMgPredict3.MGP3, ModelMgPredict3.MGP3C, ModelMgPredict3.MGP3I)
            }
        }
    }

    fun Calres(
        TArray: MutableList<Double>,
        MP: Array<Double>,
        MPC: Double,
        MPI: Double
    ): Double {
        var preRes = 0.0
        for (i in 0 until TArray.size) {
            preRes += (TArray[i] * MP[i])
        }
        val preResCor = preRes * MPC
        val preResInter = preResCor + MPI
        println("before exp: " + preResInter)
        return kotlin.math.exp(preResInter)
    }
}


