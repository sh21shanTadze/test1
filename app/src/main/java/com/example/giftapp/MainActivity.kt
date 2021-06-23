package com.example.giftapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var emailTextView: TextView
    private lateinit var uidTextView: TextView
    private lateinit var passwordChangeButton: Button
    private lateinit var logoutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        init()

        registerListeners()

    }

    private fun init() {

        emailTextView = findViewById(R.id.emailtextView)
        uidTextView = findViewById(R.id.idtextView)
        passwordChangeButton = findViewById(R.id.changePassword)
        logoutButton = findViewById(R.id.logout)

        emailTextView.text = mAuth.currentUser?.email
        uidTextView.text = mAuth.currentUser?.uid

    }

    private fun registerListeners() {

        passwordChangeButton.setOnClickListener {
            startActivity(Intent(this, ForgorPasswordActivity::class.java))
        }

        logoutButton.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            mAuth.signOut()
            finish()
        }

    }

}