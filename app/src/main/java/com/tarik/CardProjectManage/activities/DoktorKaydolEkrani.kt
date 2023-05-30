package com.tarik.CardProjectManage.activities

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.get
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.auth.User
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityDoktorKaydolEkraniBinding
import com.tarik.CardProjectManage.firebase.DoktorFirestoreClass
import com.tarik.CardProjectManage.models.Doktor_user

class DoktorKaydolEkrani : AppCompatActivity() {
    private lateinit var binding: ActivityDoktorKaydolEkraniBinding
    private lateinit var actionBar : ActionBar
    private lateinit var progressDialog : ProgressDialog
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_doktor_kaydol_ekrani)
        binding = ActivityDoktorKaydolEkraniBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Configure Action Bar
        //Enable ActionBar
        //configure progress dialog
        binding.DoktorkaydolButton1.setOnClickListener {
            registerUser_doktor()
        }

    }
    fun DoktorRegisteredSuccess(){
        FirebaseAuth.getInstance().signOut()
        finish()
    }
    @SuppressLint("SuspiciousIndentation")
    private fun registerUser_doktor(){
        val name: String = binding.isimTextField1.text.toString().trim { it <= ' ' }
        val email: String = binding.EmailTextField1.text.toString().trim { it <= ' ' }
        val password: String = binding.EditTextPassword1.text.toString().trim { it <= ' ' }
        if (validateForm(name, email, password)) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener((
                    OnCompleteListener<AuthResult> { task ->
                        println(name)
                        if (task.isSuccessful) {
                    val firebaseUser: FirebaseUser = task.result!!.user!!
                    val registeredEmail = firebaseUser.email!!
                            val user = Doktor_user(firebaseUser.uid,name,registeredEmail)
                            DoktorFirestoreClass().registerDoktor(this,user)
                            startActivity(Intent(this@DoktorKaydolEkrani, DoktorAnaSayfa::class.java))

                } else {
                    Toast.makeText(this@DoktorKaydolEkrani, "Başarısız!", Toast.LENGTH_SHORT).show()
                }
            }))
        }
    }
    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                Toast.makeText(this@DoktorKaydolEkrani, "İsim alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this@DoktorKaydolEkrani, "Email alanı boş bıraklamaz", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this@DoktorKaydolEkrani, "Şifre alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }
}

