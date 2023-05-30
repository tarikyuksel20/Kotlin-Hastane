package com.tarik.CardProjectManage.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityHastaTakibiBinding
import com.tarik.CardProjectManage.utils.HastaAyItemViewModel
import com.tarik.CardProjectManage.utils.HastaCustomAdapter
import com.tarik.CardProjectManage.utils.HastaTakibiIsımAdapter
import com.tarik.CardProjectManage.utils.HastaTakibiIsımViewModel

class HastaTakibi : AppCompatActivity() {
    lateinit var binding : ActivityHastaTakibiBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasta_takibi)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityHastaTakibiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview1)
        val firestore = FirebaseFirestore.getInstance()
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<HastaTakibiIsımViewModel>()
        val adapter = HastaTakibiIsımAdapter(data)

        firestore.collection("hasta_users").get().addOnSuccessListener {

            for (documents in it){
                data.add(HastaTakibiIsımViewModel(
                    R.drawable.baseline_person_24
                ,documents.data["name"] as String))
            }
            recyclerview.adapter=adapter


        }.addOnFailureListener {
            print("Hata")
        }

        adapter.setOnClickListener(object:HastaTakibiIsımAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

            }

        })
    }
}