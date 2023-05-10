package com.example.myappbotam

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ContactActivity : AppCompatActivity() {
    lateinit var contactBtn : ImageButton
    lateinit var smsBtn :ImageButton
    lateinit var emailBtn : ImageButton
    lateinit var contact : TextView
    lateinit var sms : TextView
    lateinit var email : TextView
    lateinit var text : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)
        contactBtn = findViewById(R.id.c_image)
        smsBtn = findViewById(R.id.s_image)
        emailBtn = findViewById(R.id.e_mail)
        contact = findViewById(R.id.c_phone)
        sms = findViewById(R.id.s_sms)
        email = findViewById(R.id.e_text)
        text = findViewById(R.id.contactView)
        contactBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0753357051"))
            if (ContextCompat.checkSelfPermission(
                    this@ContactActivity,
                    android.Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    this@ContactActivity,
                    arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                    1
                )
            } else {
                startActivity(intent)
            }

        }
        smsBtn.setOnClickListener {
            val uri: Uri = Uri.parse("sms to:0753357051")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello ..")
            startActivity(intent)
        }
        emailBtn.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "roseM@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "CONTACT US")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Botam,....")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
    }
}