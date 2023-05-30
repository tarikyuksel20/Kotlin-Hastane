package com.tarik.CardProjectManage.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.tarik.CardProjectManage.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_intro)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnHasta.setOnClickListener{
            startActivity(Intent(this, HastaSecimEkrani::class.java))
            finish()
        }
        binding.btnDoktor.setOnClickListener {
            startActivity(Intent(this, DoktorSecimEkrani::class.java))
            finish()
        }

    }
}