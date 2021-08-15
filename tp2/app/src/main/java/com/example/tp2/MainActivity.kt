package com.example.tp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var buttonLogin: Button = findViewById(R.id.login) as Button
        buttonLogin.setOnClickListener(View.OnClickListener {
            login()
        })
    }

    fun login(){
        var emailTextView = findViewById(R.id.email) as EditText
        var passwordTextView = findViewById(R.id.password) as EditText
        if (emailTextView.text.toString()=="") {
            Toast.makeText(this,"L'email est vide", Toast.LENGTH_LONG).show()
        } else if (passwordTextView.text.toString()==""){
            Toast.makeText(this,"Le mot de passe est vide", Toast.LENGTH_LONG).show()
        } else {
            FirebaseAuth.getInstance().signInWithEmailAndPassword(emailTextView.text.toString(), passwordTextView.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Succes", "signInWithEmail:success")
                        val intent = Intent(this, home::class.java).apply {}
                        startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("Error", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
