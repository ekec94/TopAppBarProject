package com.example.topappbarproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        // define toolbar
        setSupportActionBar(findViewById(R.id.idToolbar))

        // display title of activity page
        supportActionBar!!.title = "Activity Three"
        // allow the user to return to main activity
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}