package com.example.giftapp.Fragments


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.giftapp.R

class LoginFragment : Fragment (R.layout.fragment_login) {
    private lateinit var editTextMail: TextView
    private lateinit var editTextPassword: TextView
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button
    private lateinit var forgotPassword: Button
    private lateinit var navControler: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextMail = view.findViewById(R.id.editTextTextEmailAddress)
        editTextPassword = view.findViewById(R.id.editTextTextPassword)
        loginButton = view.findViewById(R.id.Login)
        registerButton = view.findViewById(R.id.Registration)
        forgotPassword = view.findViewById(R.id.PasswordForgot)
        navControler = Navigation.findNavController(view)


        registerButton.setOnClickListener {
            var email = "შეიყვანეთ მაილი"
            if (editTextMail.text.isNotEmpty()) {
                email = editTextMail.text.toString()
            }

            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            navControler.navigate(action)


        }


        forgotPassword.setOnClickListener{

            var password = "შეიყვანე მაილი"

            if (editTextPassword.text.isNotEmpty()){

                password = editTextPassword.text.toString()
            }
            val action = LoginFragmentDirections.actionLoginFragmentToPasswordForgotFragment()
            navControler.navigate(action)
        }
    }

}