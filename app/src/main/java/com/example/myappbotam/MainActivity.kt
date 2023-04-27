package com.example.myappbotam

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var myimage: ImageView
        lateinit var mText: TextView
        lateinit var mTextMain: TextView
        lateinit var btnSignIn: Button
        lateinit var mName: EditText
        lateinit var mEmail: EditText
        lateinit var mPassword: EditText
        lateinit var btnlogin : Button
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
        btnSignIn.setOnClickListener {
            var name = mName.text.toString().trim()
            var email = mEmail.text.toString().trim()
            var password = mPassword.text.toString().trim()
            var id = System.currentTimeMillis().toString()
            if (name.isEmpty()){
                mName.setError("Please fill this field")
                mName.requestFocus()
            }else if (email.isEmpty()){
                mEmail.setError("Please fill this field")
                mEmail.requestFocus()
            }else if (password.isEmpty()){
                mPassword.setError("Please fill this field")
                mPassword.requestFocus()
            }
            var tembea = Intent(this,UserActivity::class.java)
            startActivity(tembea)
        }
        btnlogin.setOnClickListener {
            var tembea = Intent(this,UserActivity::class.java)
            startActivity(tembea)
        }


    }
}