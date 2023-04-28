package com.example.myappbotam

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var img : ImageView
    lateinit var txt : TextView
    lateinit var edtEmail: EditText
    lateinit var edtPass : EditText
    lateinit var btn : Button
    lateinit var progressDialog : ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        img = findViewById(R.id.car_logo)
        txt = findViewById(R.id.textView)
        edtEmail = findViewById(R.id.email)
        edtPass = findViewById(R.id.passy)
        btn = findViewById(R.id.threebtn)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait...")
        btn.setOnClickListener {
            var email = edtEmail.text.toString().trim()
            var password = edtPass.text.toString().trim()
            var id = System.currentTimeMillis().toString()

             if (email.isEmpty()){
              edtEmail.setError("Please fill this field")
               edtEmail.requestFocus()
            }else if (password.isEmpty()){
                edtPass.setError("Please fill this field")
                edtPass.requestFocus()
            }else{
                //Proceed to save
                //Prepare the user to be saved
                var user = Users( email, password)
                // Create a reference in the firebase database
                var ref = FirebaseDatabase.getInstance().
                getReference().child("Users/")
                // Show the program to start saving
                progressDialog.show()
                ref.setValue(user).addOnCompleteListener{
                    // Dismiss the progress and check if the task is successfully
                        task->
                    progressDialog.dismiss()
                    if (task.isSuccessful){
                        Toast.makeText(this,"User saved successfully",
                            Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this,"User saving failed",
                            Toast.LENGTH_LONG).show()
                    }
                }

            }
            var tembea = Intent(this,UserActivity::class.java)
            startActivity(tembea)
        }
        }


}

