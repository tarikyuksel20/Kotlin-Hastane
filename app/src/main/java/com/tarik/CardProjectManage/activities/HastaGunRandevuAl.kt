package com.tarik.CardProjectManage.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityHastaGunRandevuAlBinding
import com.tarik.CardProjectManage.utils.HastaAyAdapter
import com.tarik.CardProjectManage.utils.HastaAyItemViewModel
import com.tarik.CardProjectManage.utils.HastaGünAdapter
import com.tarik.CardProjectManage.utils.HastaGünItemViewModel

class HastaGunRandevuAl : AppCompatActivity() {
    lateinit var binding : ActivityHastaGunRandevuAlBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasta_gun_randevu_al)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityHastaGunRandevuAlBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<HastaGünItemViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..30) {
            if(i == 1){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "1(Pazartesi)"))}
            if(i == 2){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "2(Salı)"))}
            if(i == 3){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "3(Çarşamba)"))}
            if(i == 4){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "4(Perşembe)"))}
            if(i == 5){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "5(Cuma)"))}
            if(i == 6){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "6(Cumatesi)"))}
            if(i == 7){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "7(Pazar)"))}

            if(i == 8){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "8(Pazartesi)"))}
            if(i == 9){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "9(Salı)"))}
            if(i == 10){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "10(Çarşamba)"))}
            if(i == 11){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "11(Perşembe)"))}
            if(i == 12){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "12(Cuma)"))}
            if(i == 13){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "13(Cumatesi)"))}
            if(i == 14){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "14(Pazar)"))}

            if(i == 15){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "15(Pazartesi)"))}
            if(i == 16){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "16(Salı)"))}
            if(i == 17){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "17(Çarşamba)"))}
            if(i == 18){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "18(Perşembe)"))}
            if(i == 19){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "19(Cuma)"))}
            if(i == 20){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "20(Cumatesi)"))}
            if(i == 21){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "21(Pazar)"))}

            if(i == 22){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "22(Pazartesi)"))}
            if(i == 23){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "23(Salı)"))}
            if(i == 24){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "24(Çarşamba)"))}
            if(i == 25){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "25(Perşembe)"))}
            if(i == 26){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "26(Cuma)"))}
            if(i == 27){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "27(Cumatesi)"))}
            if(i == 28){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "28(Pazar)"))}

            if(i == 29){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "29(Pazartesi)"))}
            if(i == 30){data.add(HastaGünItemViewModel(R.drawable.baseline_calendar_month_24,  "30(Salı)"))}

        }
        val adapter = HastaGünAdapter(data)
        recyclerview.adapter = adapter
        adapter.setOnClickListener(object : HastaGünAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                startActivity(Intent(this@HastaGunRandevuAl,HastaRandevuAl::class.java))
                finish()
            }

        })
    }
}