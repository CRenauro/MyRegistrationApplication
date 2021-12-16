package com.galaxe.myregistrationapplication

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Welcome : AppCompatActivity() {
    lateinit var confirm: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        confirm = findViewById(R.id.confirm)

        var sharedpref: SharedPreferences = this.getSharedPreferences("myFile", Context.MODE_PRIVATE)

        var userName = sharedpref.getString("name","n/a")
        var password= sharedpref.getString("password", "n/a")
        var city = sharedpref.getString("city", "n/a")
        var month = sharedpref.getString("month", "n/a")
        var day = sharedpref.getString("day","n/a")
        var year = sharedpref.getString("year","n/a")

        confirm.text = "Hello $userName\nYour password is: $password\nYour city is: $city\nYour DOB is: $month/$day/$year"

//        "Hello $userName\nYour password is: $password\nYour city is: $city\nYour DOB is: $month/$day/$year".also {
//            confirm.text = it
//        }


    }

    fun back(view: View){
        intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}