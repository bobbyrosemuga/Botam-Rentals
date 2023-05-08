package com.example.myappbotam

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var myimage: ImageView
    lateinit var mText: TextView
    lateinit var mTextMain: TextView
    lateinit var btnSignIn: Button
    lateinit var mName: EditText
    lateinit var mEmail: EditText
    lateinit var mPassword: EditText
    lateinit var btnlogin : Button
//    lateinit var db: SQLiteDatabase
    lateinit var mAuth: FirebaseAuth
    lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        myimage = findViewById(R.id.mImg)
        mText = findViewById(R.id.mTxtMain)
        mTextMain = findViewById(R.id.mMain)
        btnSignIn = findViewById(R.id.mBtnSign)
        mName = findViewById(R.id.mPlain)
        mEmail = findViewById(R.id.mEmail)
        mPassword = findViewById(R.id.mPass)
        btnlogin = findViewById(R.id.mBtnLogin)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()
        // Create a database called eMobilisDb
//        db = openOrCreateDatabase("eMobilisDb", Context.MODE_PRIVATE,null)
        // Create a table called users inside the database
//        db.execSQL("CREATE TABLE IF NOT EXISTS users(jina VARCHAR, arafa VARCHAR, kitambulisho VARCHAR)")
        //Set on click listeners to the buttons
        btnSignIn.setOnClickListener {
            //Receive the data from the user
            var name = mName.text.toString().trim()
            var email = mEmail.text.toString().trim()
            var password = mPassword.text.toString().trim()
            // Check if th user is submitting the empty fields
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
                // Display an error message using the defined message function
                message("EMPTY FIELDS!!!!", "Please fill all the inputs!!")
            }else{
                //Proceed to register to firebase
                /*db.execSQL("INSERT INTO users VALUES('" +name+ "','"+email+ "', '"+password+"')")
                clear()
                message("SUCCESS!!","User saved successfully")
                var tembea = Intent(this,UserActivity::class.java)
                startActivity(tembea)*/
                progressDialog.show()
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                    progressDialog.dismiss()
                    if (it.isSuccessful){
                        Toast.makeText(this@MainActivity,"Registration successful",Toast.LENGTH_LONG).show()
                        var tembea = Intent(this,DashboardActivity::class.java)
                        startActivity(tembea)
                        mAuth.signOut()
                        finish()
                    }else{
                        message("ERROR!!",it.exception!!.message.toString())
                    }
                }

            }

        }
        btnlogin.setOnClickListener {
            var ingia = Intent(this,LoginActivity::class.java)
            startActivity(ingia)
        }

    }
    fun message(title:String, message:String){
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Close",null)
        alertDialog.create().show()
    }
    fun clear(){
        mName.setText("")
        mEmail.setText("")
        mEmail.setText("")
    }

}
