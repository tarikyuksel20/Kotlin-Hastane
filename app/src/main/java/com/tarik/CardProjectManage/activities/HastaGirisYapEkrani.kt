package com.tarik.CardProjectManage.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.firebase.auth.FirebaseAuth
import com.tarik.CardProjectManage.databinding.ActivityHastaGirisYapEkraniBinding
import com.tarik.CardProjectManage.models.Hasta_user

class HastaGirisYapEkrani : AppCompatActivity() {
    lateinit var binding : ActivityHastaGirisYapEkraniBinding
    private lateinit var actionBar: ActionBar
    private lateinit var progressDialog: ProgressDialog
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hasta_giris_yap_ekrani)
        binding = ActivityHastaGirisYapEkraniBinding.inflate(layoutInflater)
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
        binding.HastaGiriButton.setOnClickListener {
            SignInRegistiredUser_Hastagiriş()
    }
}
    fun HastaSignInSuccess(user:Hasta_user){
        startActivity(Intent(this,HastaAnaSayfa::class.java))
        finish()
    }
    private fun SignInRegistiredUser_Hastagiriş(){
        val email : String = binding.EmailHastaGiriYap111.text.toString().trim(){it <= ' '}
        val password : String = binding.HastaGirisEditPasword1111.text.toString().trim(){it <= ' '}
        if (validateForm(email,password)){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(
                            this@HastaGirisYapEkrani,
                            "Başarılı",
                            Toast.LENGTH_LONG
                        ).show()

                        startActivity(Intent(this@HastaGirisYapEkrani, HastaAnaSayfa::class.java))
                    } else {
                        Toast.makeText(
                            this@HastaGirisYapEkrani,
                            "Başarısız",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

    }
    private fun validateForm(email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this@HastaGirisYapEkrani, "Email alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this@HastaGirisYapEkrani, "Şifre alanı boş bırakılamaz", Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                true
            }
        }
    }}