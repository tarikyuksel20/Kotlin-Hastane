package com.tarik.CardProjectManage.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityDoktorProfilBinding

class DoktorProfil : AppCompatActivity() {
    lateinit var bindig : ActivityDoktorProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doktor_profil)
        bindig = ActivityDoktorProfilBinding.inflate(layoutInflater)
        val view = bindig.root
        setContentView(view)
    }
}