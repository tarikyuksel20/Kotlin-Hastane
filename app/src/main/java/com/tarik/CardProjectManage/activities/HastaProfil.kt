package com.tarik.CardProjectManage.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityHastaProfilBinding

class HastaProfil : AppCompatActivity() {
    lateinit var bindig : ActivityHastaProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasta_profil)
        bindig = ActivityHastaProfilBinding.inflate(layoutInflater)
        val view = bindig.root
        setContentView(view)
    }
}