package com.tarik.CardProjectManage.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityDoktorilacYazihastaisimleriBinding
import com.tarik.CardProjectManage.databinding.ActivityHastaGirisYapEkraniBinding
import com.tarik.CardProjectManage.utils.DoktoriacYazihastaisimleriViewModel
import com.tarik.CardProjectManage.utils.DoktorilacYazihastaisimleriAdapter

class DoktorilacYazihastaisimleri : AppCompatActivity() {
    lateinit var binding : ActivityDoktorilacYazihastaisimleriBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        println("1233333")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doktorilac_yazihastaisimleri)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityDoktorilacYazihastaisimleriBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview2)
        val firestore = FirebaseFirestore.getInstance()
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<DoktoriacYazihastaisimleriViewModel>()
        val adapter = DoktorilacYazihastaisimleriAdapter(data)
        firestore.collection("hasta_users").get().addOnSuccessListener {
            println("assaddsadsa")
            for (documents in it){
                data.add(DoktoriacYazihastaisimleriViewModel(
                    R.drawable.baseline_person_24
                    ,documents.data["name"] as String)
                )
            }
            recyclerview.adapter=adapter


        }.addOnFailureListener {
            println(it.localizedMessage)
        }
        adapter.setOnClickListener(object :DoktorilacYazihastaisimleriAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(this@DoktorilacYazihastaisimleri,Ilacsondurum::class.java))
            }
        })
    }
}