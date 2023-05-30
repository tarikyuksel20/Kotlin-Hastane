package com.tarik.CardProjectManage.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tarik.CardProjectManage.databinding.ActivityDoktorSecimEkraniBinding

class DoktorSecimEkrani : AppCompatActivity() {
    lateinit var binding: ActivityDoktorSecimEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_doktor_secim_ekrani)
        binding = ActivityDoktorSecimEkraniBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.doktorGiriYapButton.setOnClickListener {
            startActivity(Intent(this, DoktorGirisYapEkrani::class.java))
            finish()
        }
        binding.doktorKaydolButton.setOnClickListener {
            startActivity(Intent(this, DoktorKaydolEkrani::class.java))
            finish()
        }
    }
}