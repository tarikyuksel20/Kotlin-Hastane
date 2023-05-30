package com.tarik.CardProjectManage.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityDoktorAnaSayfaBinding
import com.tarik.CardProjectManage.models.Doktor_user

class DoktorAnaSayfa : AppCompatActivity() {
    private lateinit var binding : ActivityDoktorAnaSayfaBinding
    private lateinit var actionBar : ActionBar
    lateinit var toggle : ActionBarDrawerToggle
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoktorAnaSayfaBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_hasta_ana_sayfa)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        val drawerLayout : DrawerLayout = binding.doktorDrawerLayout
        val navView : NavigationView = binding.doktorNavView
        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.aç,R.string.kapa)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayShowHomeEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_doktor_sign_out->finish()
                R.id.nav_doktor_profile->
                    startActivity(Intent(this@DoktorAnaSayfa,DoktorProfil::class.java))
                R.id.doktor_hasta_takibi->
                    startActivity(Intent(this@DoktorAnaSayfa,HastaTakibi::class.java))
                    //startActivity()
                R.id.nav_doktor_ilacyaz->
                    startActivity(Intent(this@DoktorAnaSayfa,DoktorilacYazihastaisimleri::class.java))
            }
            true
        }}
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toggle.onOptionsItemSelected(item)){
                return true
            }
            return super.onOptionsItemSelected(item)


    }
}