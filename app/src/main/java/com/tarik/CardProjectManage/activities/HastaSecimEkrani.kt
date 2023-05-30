package com.tarik.CardProjectManage.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tarik.CardProjectManage.databinding.ActivityHastaSecimEkraniBinding

class HastaSecimEkrani : AppCompatActivity() {
    lateinit var binding: ActivityHastaSecimEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hasta_secim_ekrani)
        binding = ActivityHastaSecimEkraniBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.hastaGiriYapButton.setOnClickListener {
            startActivity(Intent(this, HastaGirisYapEkrani::class.java))
            finish()
        }
        binding.hastaKaydolYapButton.setOnClickListener {
            startActivity(Intent(this, HastaKaydolEkrani::class.java))
            finish()
        }
    }
}