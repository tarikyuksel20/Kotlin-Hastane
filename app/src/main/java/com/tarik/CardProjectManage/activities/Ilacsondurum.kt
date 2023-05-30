package com.tarik.CardProjectManage.activities

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityDoktorilacYazihastaisimleriBinding
import com.tarik.CardProjectManage.databinding.ActivityIlacsondurumBinding
import com.tarik.CardProjectManage.utils.HastaAyItemViewModel
import com.tarik.CardProjectManage.utils.IlacsondurumAdapter
import com.tarik.CardProjectManage.utils.IlacsondurumViewModel

class Ilacsondurum : AppCompatActivity() {
    //Başlangıç
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "i.apps.notifications"
    private val description = "Test notification"
    //Bitiş

    lateinit var binding: ActivityIlacsondurumBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ilacsondurum)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityIlacsondurumBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview3)
        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<IlacsondurumViewModel>()
        //Başlangıç
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //Bitiş
        for (i in 1..6) {
            if(i == 1){data.add(IlacsondurumViewModel(R.drawable.baseline_medical_services_24,  "Parol"))}
            if(i == 2){data.add(IlacsondurumViewModel(R.drawable.baseline_medical_services_24,  "Nurofen"))}
            if(i == 3){data.add(IlacsondurumViewModel(R.drawable.baseline_medical_services_24,  "A-ferin"))}
            if(i == 4){data.add(IlacsondurumViewModel(R.drawable.baseline_medical_services_24,  "İbucold"))}
            if(i == 5){data.add(IlacsondurumViewModel(R.drawable.baseline_medical_services_24,  "Katarin"))}
            if(i == 6){data.add(IlacsondurumViewModel(R.drawable.baseline_medical_services_24,  "Augmentin"))}
        }
        val adapter = IlacsondurumAdapter(data)
        recyclerview.adapter=adapter
        adapter.setOnClickListener(object:IlacsondurumAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                var toast = Toast.makeText(this@Ilacsondurum, "İlaç Hastaya Yazıldı", Toast.LENGTH_LONG)
                toast.show()
            }
        })
    }
}