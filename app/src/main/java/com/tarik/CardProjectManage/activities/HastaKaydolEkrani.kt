package com.tarik.CardProjectManage.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.tarik.CardProjectManage.databinding.ActivityHastaKaydolEkraniBinding
import com.tarik.CardProjectManage.firebase.HastaFirestoreClass
import com.tarik.CardProjectManage.models.Hasta_user

class HastaKaydolEkrani : AppCompatActivity() {
    lateinit var binding: ActivityHastaKaydolEkraniBinding
    private lateinit var actionBar : ActionBar
    private lateinit var progressDialog : ProgressDialog
    private lateinit var firebaseAuth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hasta_kaydol_ekrani)
        binding = ActivityHastaKaydolEkraniBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.hastaKaydolllll.setOnClickListener {
            registerUser_Hasta()
        }
    }
    fun HastaRegisteredSuccess(){
        FirebaseAuth.getInstance().signOut()
        finish()
    }
    private fun registerUser_Hasta(){
        val name: String = binding.HastaKaydolIsimKullanCak.text.toString().trim { it <= ' ' }
        val email: String = binding.HastaKaydolEmailKullanLcaklllllllllllllllll.text.toString().trim { it <= ' ' }
        val password: String = binding.HastaKaydolPasswordKullanLcaklllllllllllllll.text.toString().trim { it <= ' ' }
        if (validateForm(name, email, password)) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener((
                    OnCompleteListener<AuthResult> { task ->
                        //println(task)
                        if (task.isSuccessful) {
                            val firebaseUser: FirebaseUser = task.result!!.user!!
                            val registeredEmail = firebaseUser.email!!
                            val user1 = Hasta_user(firebaseUser.uid,name,registeredEmail)
                            //HastaFirestoreClass().registerHasta(this,user1)
                            HastaFirestoreClass().registerHasta(this,user1)
                            startActivity(Intent(this@HastaKaydolEkrani, HastaAnaSayfa::class.java))
                        } else {
                            Toast.makeText(this@HastaKaydolEkrani, "Başarısız!", Toast.LENGTH_SHORT).show()
                        }
                    }))
        }
    }
    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                Toast.makeText(this@HastaKaydolEkrani, "İsim alanı boş bırakılamaz!", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this@HastaKaydolEkrani, "Email alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this@HastaKaydolEkrani, "Şifre alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }
}