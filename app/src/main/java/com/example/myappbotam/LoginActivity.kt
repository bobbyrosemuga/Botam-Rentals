package com.example.myappbotam

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var img : ImageView
    lateinit var txt : TextView
    lateinit var edtEmail: EditText
    lateinit var edtPass : EditText
    lateinit var btn : Button
//    lateinit var db: SQLiteDatabase
    lateinit var progressDialog:ProgressDialog
    lateinit var mAuth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        img = findViewById(R.id.car_logo)
        txt = findViewById(R.id.textView)
        edtEmail = findViewById(R.id.email)
        edtPass = findViewById(R.id.edtPass)
        btn = findViewById(R.id.threebtn)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()
        // Create a database called eMobilisDb
//        db = openOrCreateDatabase("eMobilisDb", Context.MODE_PRIVATE,null)
        // Create a table called users inside the database
//        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")
        //Set on click listeners to the buttons
        btn.setOnClickListener {
            //Receive the data from the user

            var email = edtEmail.text.toString().trim()
            var password = edtPass.text.toString().trim()
            // Check if th user is submitting the empty fields
            if (email.isEmpty() || password.isEmpty()){
                // Display an error message using the defined message function
                message("EMPTY FIELDS!!!!", "Please fill all the inputs!!")
            }else{
                //Proceed to login
                /*db.execSQL("INSERT INTO users VALUES('"+email+ "', '"+password+"')")
                clear()
                message("SUCCESS!!","User saved successfully")*/
                progressDialog.show()
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(this@LoginActivity,"Login successful", Toast.LENGTH_LONG).show()
                        var tembea = Intent(this,DashboardActivity::class.java)
                        startActivity(tembea)
                        finish()
                    }else{
                        message("ERROR!!",it.exception!!.message.toString())
                    }
                }
            }

        }
        var tembea = Intent(this,DashboardActivity::class.java)
        startActivity(tembea)
    }
    fun message(title:String, message:String){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Close",null)
        alertDialog.create().show()
    }
    fun clear(){
        edtEmail.setText("")
        edtPass.setText("")
    }

        }




