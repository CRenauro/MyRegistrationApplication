package com.galaxe.myregistrationapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import java.util.*

class Register : AppCompatActivity() {

    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var city: EditText
    lateinit var datePick: DatePicker
    lateinit var datePicktext: TextView
    lateinit var month1: String
    lateinit var day1: String
    lateinit var year1: String
//    lateinit var btn: Button
//    lateinit var tv: TextView
//    lateinit var saveBtn: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)



        userName = findViewById(R.id.name)
        password = findViewById(R.id.password)
        city = findViewById(R.id.city)
        datePick = findViewById(R.id.dp)
//        nextBtn = findViewById(R.id.nextBtn)
//        saveBtn = findViewById(R.id.saveBtn)
        datePicktext = findViewById(R.id.datePicktext)




        var today = Calendar.getInstance()
        datePick.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) {  _,year, month, day ->
            month1 = (month + 1).toString()
            day1 = day.toString()
            year1 = year.toString()
            datePicktext.text = "$month/$day/$year"
        }

    }
    fun showAlert(view: View) {
        var alert = AlertDialog.Builder(this)
        if (userName.text.toString() != "" && password.text.toString() != "" && city.text.toString() != ""){

            alert.setTitle("Data Saved")
//            alert.setMessage("")
            alert.setIcon(android.R.drawable.ic_dialog_alert)
            alert.setPositiveButton("You're in!") { dialog, which -> }

            var sharedpref: SharedPreferences = this.getSharedPreferences("myFile", Context.MODE_PRIVATE)
            var sfedit: SharedPreferences.Editor = sharedpref.edit()

            sfedit.putString("name", userName.text.toString())
            sfedit.putString("password", password.text.toString())
            sfedit.putString("city", city.text.toString())
            sfedit.putString("month", month1)
            sfedit.putString("day", day1)
            sfedit.putString("year", year1)

            sfedit.commit()
        }
        else {
            alert.setTitle("Oh no!")
            alert.setMessage("Goodbye")
            alert.setIcon(android.R.drawable.ic_dialog_alert)
            alert.setNegativeButton("You're out!") { dialog, which -> }
        }

        alert.show()



    }

    fun next(view: View){
        intent = Intent(this, Welcome::class.java)
        startActivity(intent)
    }



}