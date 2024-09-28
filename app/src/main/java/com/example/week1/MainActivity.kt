package com.example.week1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onEmotionClicked(view: View) {
        // Get the ID of the clicked ImageView
        val id = view.id

        // Prepare an intent to go to the next activity
        val intent = Intent(this@MainActivity, NextActivity::class.java)

        // Based on the ID, pass different data or do other actions
        when (id) {
            R.id.happy -> intent.putExtra("emotion", "happy")
            R.id.excited -> intent.putExtra("emotion", "excited")
            R.id.normal -> intent.putExtra("emotion", "normal")
            R.id.worried -> intent.putExtra("emotion", "worried")
            R.id.angry -> intent.putExtra("emotion", "angry")
        }

        // Start the next activity
        startActivity(intent)
    }
}
