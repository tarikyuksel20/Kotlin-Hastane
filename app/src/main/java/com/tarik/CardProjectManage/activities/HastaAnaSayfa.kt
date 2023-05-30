package com.tarik.CardProjectManage.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityHastaAnaSayfaBinding

class HastaAnaSayfa : AppCompatActivity() {
    lateinit var binding:ActivityHastaAnaSayfaBinding
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hasta_ana_sayfa),
        binding = ActivityHastaAnaSayfaBinding.inflate(layoutInflater)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val view = binding.root
        setContentView(view)
        val drawerLayout : DrawerLayout = binding.drawerLayout
        val navView : NavigationView = binding.navView
        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.aç,R.string.kapa)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayShowHomeEnabled(true)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_hasta_sign_out->finish()
                R.id.nav_hasta_randevularım->
                    startActivity(Intent(this@HastaAnaSayfa,HastaAyRandevuAl::class.java))
                R.id.nav_hasta_profile->
                    startActivity(Intent(this@HastaAnaSayfa,HastaProfil::class.java))
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}