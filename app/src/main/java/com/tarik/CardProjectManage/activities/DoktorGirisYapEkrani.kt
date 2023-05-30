package com.tarik.CardProjectManage.activities

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.firebase.auth.FirebaseAuth
import com.tarik.CardProjectManage.databinding.ActivityDoktorGirisYapEkraniBinding
import com.tarik.CardProjectManage.models.Doktor_user

class DoktorGirisYapEkrani : BaseActivity() {
    private lateinit var binding: ActivityDoktorGirisYapEkraniBinding
    private lateinit var actionBar:ActionBar
    private lateinit var progressDialog:ProgressDialog
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_doktor_giris_yap_ekrani)
        binding = ActivityDoktorGirisYapEkraniBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Configure ActionBar
        actionBar = supportActionBar!!
        actionBar.title="Login"
        //Configure Progress Dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Lütfen Bekleyin")
        progressDialog.setMessage("Giriş Yapılıyor")
        progressDialog.setCanceledOnTouchOutside(false)
        auth = FirebaseAuth.getInstance()
        binding.DoktorGiriYapButton1.setOnClickListener {
            SignInRegistiredUser()
        }
    }
    private fun SignInRegistiredUser(){
        val email : String = binding.EmailTextField1KullanLcak.text.toString().trim(){it <= ' '}
        val password : String = binding.EditTextPassword1KullanLcak.text.toString().trim(){it <= ' '}
        if (validateForm(email,password)){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(
                            this@DoktorGirisYapEkrani,
                            "Başarılı",
                            Toast.LENGTH_LONG
                        ).show()

                        startActivity(Intent(this@DoktorGirisYapEkrani, DoktorAnaSayfa::class.java))
                    } else {
                        Toast.makeText(
                            this@DoktorGirisYapEkrani,
                            "Başarısız",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

    }
    fun DoktorsignInSuccess(user:Doktor_user){
        startActivity(Intent(this,DoktorAnaSayfa::class.java))
        finish()
    }
    private fun validateForm(email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this@DoktorGirisYapEkrani, "Email alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this@DoktorGirisYapEkrani, "Şifre alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }
}