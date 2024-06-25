package com.mascir.smartsensorfer.httpReqs

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.text.Html
import android.view.ContextThemeWrapper
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.mascir.smartsensorfer.*
import com.mascir.smartsensorfer.FragmentScan.Companion.scans
import kotlinx.android.synthetic.main.fragment_scan.view.*
import okhttp3.*
import org.json.JSONArray
import org.json.JSONObject
import org.jsoup.Jsoup
import java.io.File
import java.io.IOException


val url = "http://196.200.149.98:3040"
/*val url = "http://192.168.184.66:3040"*/

class AsyncCallerLogin(progress: ProgressBar, btn: Button, act: Activity) :
    AsyncTask<String, Void, String>() {

    val progress: ProgressBar = progress
    val btn: Button = btn
    val act: Activity = act
    // var editor = Login.sharedPreference.edit()

    companion object {
        var res = ""
        var user: JSONObject = JSONObject();
    }

    override fun onPreExecute() {
        super.onPreExecute()
        progress.visibility = View.VISIBLE
        btn.isEnabled = false
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        progress.visibility = View.GONE
        btn.isEnabled = true
        while (!Login.logged) {
            if (res != "") {
                Login.logged = true
                if (res == "done") {

                    if (user.length() != 0) {
                        Toast.makeText(act, "Bienvenue !!!", Toast.LENGTH_LONG).show()
                        val intent = Intent(act, Home::class.java)
                        act.startActivity(intent)
                        //editor.putString("user", user.getString("username"))
                        //editor.putString("pass", user.getString("password"))
                        //editor.putString("role", user.getString("role"))
                        //editor.apply()
                        //editor.commit()

                    } else {
                        Toast.makeText(
                            act,
                            "Informations incorrectes !!!",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                    Login.logged = true
                } else if (res == "failed") {

                    Toast.makeText(
                        act as AppCompatActivity,
                        "Chargement non réussi, il se peut que le serveur n'est pas disponible.",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }
        res = ""
        Login.logged = false;

    }

    override fun doInBackground(vararg p0: String?): String? {
        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("username", p0[0])
            .addFormDataPart("password", p0[1])
            .build()
        val request = Request.Builder()
            .url(url + "/login")
            .post(body)
            .build()
        try {
            OkHttpClient().newCall(request).enqueue(object : Callback {

                override fun onFailure(call: Call, e: IOException) {
                    println("this is it :    " + e.message)
                    res = "failed"
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {

                        user = JSONObject(response.body()?.string().toString())
                        println(user)
                        res = "done"
                        //objData = jsonArray.get(0) as JSONObject
                    }

                }
            })
        } catch (e: InterruptedException) {
            e.printStackTrace();
        }
        return res
    }


}

class ForceUpdateAsync(
    currentVersion: String,
    context: Context,
    progress: ProgressBar,
    updateBtn: Button
) :
    AsyncTask<String, Void, JSONObject>() {

    private val progress: ProgressBar = progress
    private val updateBtn: Button = updateBtn
    private var latestVersion: String? = null
    private val currentVersion: String? = currentVersion
    private val context: Context? = context

    override fun onPostExecute(jsonObject: JSONObject?) {
        super.onPostExecute(jsonObject)
        println("this is the lastest version : " + latestVersion)
        println("this is the current version : " + currentVersion)
        if (latestVersion != null) {
            if (!currentVersion.equals(latestVersion, ignoreCase = true)) {
                //Toast.makeText(context, "update is available.", Toast.LENGTH_LONG).show()
                progress.visibility = View.GONE
                updateBtn.visibility = View.VISIBLE
                showForceUpdateDialog()
            } else {
                context!!.startActivity(Intent(context, Login::class.java))

            }
        }

    }

    fun showForceUpdateDialog() {
        val alertDialogBuilder =
            AlertDialog.Builder(
                ContextThemeWrapper(
                    context,
                    R.style.DialogDark
                )
            )
        alertDialogBuilder.setTitle(context!!.getString(R.string.youAreNotUpdatedTitle))
        alertDialogBuilder.setMessage(
            context.getString(R.string.youAreNotUpdatedMessage) + " " + latestVersion + context.getString(
                R.string.youAreNotUpdatedMessage1
            )
        )
        alertDialogBuilder.setCancelable(false)
        alertDialogBuilder.setPositiveButton(
            R.string.update,
            DialogInterface.OnClickListener { dialog, id ->
                context.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("market://details?id=com.mascir.smartsensorfer")
                    )
                )
                dialog.cancel()
            })
        alertDialogBuilder.show()
    }

    override fun doInBackground(vararg p0: String?): JSONObject {
        try {
            latestVersion =
                Jsoup.connect("https://play.google.com/store/apps/details?id=com.mascir.smartsensorfer&hl=en")
                    .timeout(30000)
                    .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                    .referrer("http://www.google.com")
                    .get()
                    .select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                    .first()
                    .ownText()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return JSONObject()
    }
}

class AsyncCallerNormal(
    testFile: File,
    avgFile: File,
    context: Context,
    progress: ProgressBar,
    loadingText: TextView,
    insertion: ConstraintLayout
) :
    AsyncTask<String, Void, String>() {
    companion object {
        var test = ""
        var objData: JSONObject = JSONObject()
    }

    val param1: File? = testFile
    val param2: File? = avgFile
    val context: Context = context
    private val progress: ProgressBar? = progress
    private val loadingText: TextView? = loadingText
    private val insertion: ConstraintLayout? = insertion

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        var done = false
        while (!done) {
            if (test != "") {
                done = true
                loadingText!!.visibility = View.GONE
                progress!!.visibility = View.GONE
                insertion!!.visibility = View.VISIBLE
                if (test == "failed") {
                    test = ""
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("un problème est survenue")
                    builder.setMessage("Le serveur n'est pas disponible pour le moment.")
                    builder.setPositiveButton("OK") { dialog, which ->
                    }
                    builder.show()
                } else {
                    test = ""
                    /*val intent = Intent(context, Results::class.java)

                    context!!.startActivity(intent)*/
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Chargement réussi")
                    builder.setMessage("Veuillez consulter les résultats sur le serveur.")
                    builder.setPositiveButton("OK") { dialog, which ->
                    }
                    builder.show()

                }
            }
        }
    }

    override fun doInBackground(vararg p0: String?): String? {

        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart(
                "file", param1?.name,
                RequestBody.create(MediaType.parse("text/csv"), param1)
            ).addFormDataPart(
                "avgfile",
                param2?.name,
                RequestBody.create(MediaType.parse("text/csv"), param2)
            )
            .addFormDataPart("sensor", p0[0])
            .addFormDataPart("numEchant", p0[1])
            .addFormDataPart("lat", p0[2])
            .addFormDataPart("lng", p0[3])
            .addFormDataPart("app", p0[4])
            .build()
        val request = Request.Builder()
            .url("$url/normal")
            .post(body)
            .build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("this is it :    " + e.message)
                test = "failed"
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val jsonArr = JSONArray(response.body()?.string().toString())
                    objData = jsonArr.getJSONObject(0)
                    println(objData)
                    test = objData.getString("filename")
                }

            }
        })
        println("done")


        return test
    }


}

class AsyncCallerIsfetSend(
    value: Double,
    numEchant: String,
    context: Context,
    progress: ProgressBar,
    loadingText: TextView,
    insertion: ConstraintLayout
) :
    AsyncTask<String, Void, String>() {
    companion object {
        var test = ""
        var objData: JSONObject = JSONObject()
    }

    val param1: Double? = value
    val numEchant: String = numEchant
    val context: Context = context
    private val progress: ProgressBar? = progress
    private val loadingText: TextView? = loadingText
    private val insertion: ConstraintLayout? = insertion

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        var done = false
        while (!done) {
            if (test != "") {
                done = true
                loadingText!!.visibility = View.GONE
                progress!!.visibility = View.GONE
                insertion!!.visibility = View.VISIBLE
                if (test == "failed") {
                    test = ""
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("un problème est survenue")
                    builder.setMessage("Le serveur n'est pas disponible pour le moment.")
                    builder.setPositiveButton("OK") { dialog, which ->
                    }
                    builder.show()
                } else {
                    test = ""
                    /*val intent = Intent(context, Results::class.java)

                    context!!.startActivity(intent)*/
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Chargement réussi")
                    builder.setMessage("Veuillez consulter les résultats sur le serveur.")
                    builder.setPositiveButton("OK") { dialog, which ->
                    }
                    builder.show()

                }
            }
        }
    }

    override fun doInBackground(vararg p0: String?): String? {

        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("value", p0[0])
            .addFormDataPart("numEchant", p0[1])
            .addFormDataPart("lat", p0[2])
            .addFormDataPart("lng", p0[3])
            .addFormDataPart("app", p0[4])
            .build()
        val request = Request.Builder()
            .url("$url/isfet")
            .post(body)
            .build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("this is it :    " + e.message)
                test = "failed"
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val jsonArr = JSONArray(response.body()?.string().toString())
                    objData = jsonArr.getJSONObject(0)
                    println(objData)
                    test = objData.getString("filename")
                }

            }
        })
        println("done")


        return test
    }


}

class AsyncCallerfiles(
    testFile: File,
    context: Context,
    progress: ProgressBar,
    loadingText: TextView,
    insertion: ConstraintLayout,
    resView: LinearLayout
) :
    AsyncTask<String, Void, String>() {
    companion object {
        var test = ""
        var objData: JSONObject = JSONObject()
    }

    val param1: File? = testFile
    val context: Context = context
    private val progress: ProgressBar? = progress
    private val loadingText: TextView? = loadingText
    private val insertion: ConstraintLayout? = insertion
    private val resView: LinearLayout? = resView

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        var done = false
        while (!done) {
            if (test != "") {
                done = true
                loadingText!!.visibility = View.GONE
                progress!!.visibility = View.GONE
                insertion!!.visibility = View.VISIBLE
                if (test == "failed") {
                    test = ""
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle(
                        Html.fromHtml(" <font color='#FF0000'>Un problème est survenue</font>")
                    )
                    builder.setMessage("Le serveur n'est pas disponible pour le moment.\nMerci de nous contacter si le problème persiste")
                    builder.setPositiveButton("OK") { dialog, which ->
                    }
                    builder.show()
                } else {
                    test = ""
                    /*val intent = Intent(context, Results::class.java)

                    context!!.startActivity(intent)*/
                   /* val builder = AlertDialog.Builder(context)
                    builder.setTitle(Html.fromHtml(" <font color='#105E24'>Chargement réussi</font>"))
                    builder.setMessage("Veuillez consulter les résultats sur le serveur.")
                    builder.setPositiveButton("OK") { dialog, which ->
                    }
                    builder.show()*/


                    loadingText!!.visibility = View.GONE
                     progress!!.visibility = View.GONE
                     val theres = objData.getString("res").trim()
                     resView!!.resText.text = theres
                     resView!!.resImg.setImageResource(
                         context.resources.getIdentifier(
                             "com.mascir.smartsensorfer:drawable/$theres",
                             null,
                             null
                         )
                     )
                     resView!!.visibility = View.VISIBLE
                     insertion!!.visibility = View.INVISIBLE
                }
            }
        }
    }

    override fun doInBackground(vararg p0: String?): String? {
        println("params : " + param1?.name + " " + p0[0] + " " + p0[1])
        val body = MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart(
                "file", param1?.name,
                RequestBody.create(MediaType.parse("text/csv"), param1)
            )
            .addFormDataPart("sensor", p0[0])
            .addFormDataPart("numEchant", p0[1])
            .build()
        val request = Request.Builder()
            .url("$url/normal")
            .post(body)
            .build()

        OkHttpClient().newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("this is it :    " + e.message)
                test = "failed"
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    /*  println(response.body()?.string().toString())*/
                    val jsonArr = JSONArray(response.body()?.string().toString())
                    objData = jsonArr.getJSONObject(0)
                    println(objData)
                    test = objData.getString("res")
                }

            }
        })
        println("done")


        return test
    }
}