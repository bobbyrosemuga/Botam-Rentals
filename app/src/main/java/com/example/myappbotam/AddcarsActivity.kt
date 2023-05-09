package com.example.myappbotam

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myappbotam.databinding.ActivityAddcarsBinding
import com.google.firebase.storage.FirebaseStorage
import java.net.URI
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AddcarsActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddcarsBinding
    lateinit var ImageUri:Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityAddcarsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.SelectImage.setOnClickListener {
            selectImage()
        }
        binding.UploadImage.setOnClickListener {
            uploadImage()
        }
    }

    private fun uploadImage() {
       val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading File...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().



    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "images/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent,100)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK){
            ImageUri = data?.data!!
            binding.firebaseImage.setImageURI(ImageUri)
        }
    }
}
