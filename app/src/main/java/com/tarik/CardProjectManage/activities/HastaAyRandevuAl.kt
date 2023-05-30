package com.tarik.CardProjectManage.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityHastaAyRandevuAlBinding
import com.tarik.CardProjectManage.databinding.ActivityHastaRandevuAlBinding
import com.tarik.CardProjectManage.utils.HastaAyAdapter
import com.tarik.CardProjectManage.utils.HastaAyItemViewModel
import com.tarik.CardProjectManage.utils.HastaCustomAdapter
import com.tarik.CardProjectManage.utils.HastaItemViewModel

class HastaAyRandevuAl : AppCompatActivity() {
    lateinit var binding : ActivityHastaAyRandevuAlBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_hasta_ay_randevu_al)
        binding = ActivityHastaAyRandevuAlBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<HastaAyItemViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..12) {
            if(i == 1){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Ocak"))}
            if(i == 2){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Şubat"))}
            if(i == 3){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Mart"))}
            if(i == 4){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Nisan"))}
            if(i == 5){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Mayıs"))}
            if(i == 6){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Haziran"))}
            if(i == 7){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Temmuz"))}
            if(i == 8){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Ağustos"))}
            if(i == 9){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Eylül"))}
            if(i == 10){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Ekim"))}
            if(i == 11){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Kasım"))}
            if(i == 12){data.add(HastaAyItemViewModel(R.drawable.baseline_calendar_month_24,  "Aralık"))}
        }

        // This will pass the ArrayList to our Adapter

        val adapter = HastaAyAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        adapter.setOnClickListener(object : HastaAyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(this@HastaAyRandevuAl,HastaGunRandevuAl::class.java))
                finish()
            }

        })

    }
}