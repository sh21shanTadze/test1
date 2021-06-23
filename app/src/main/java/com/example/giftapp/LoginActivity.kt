package com.example.giftapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var loginEmail: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var forgotPassword: Button

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {
            goToMainActivity()
        }

        setContentView(R.layout.activity_login)

        init()

        registerListeners()

    }

    private fun init() {

        loginEmail = findViewById(R.id.editTextTextEmailAddress)
        loginPassword = findViewById(R.id.editTextTextPassword)
        loginButton = findViewById(R.id.Login)
        registerButton = findViewById(R.id.Registration)
        forgotPassword = findViewById(R.id.PasswordForgot)

    }

    private fun registerListeners() {

        loginButton.setOnClickListener {

            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        goToMainActivity()
                    } else {
                        Toast.makeText(this, "Authentication failed!", Toast.LENGTH_SHORT).show()
                    }
                }


        }
        registerButton.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))

        }
        forgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgorPasswordActivity::class.java))
        }


    }

    private fun goToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}