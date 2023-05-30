package com.tarik.CardProjectManage.activities

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tarik.CardProjectManage.R
import com.tarik.CardProjectManage.databinding.ActivityHastaRandevuAlBinding
import com.tarik.CardProjectManage.utils.HastaCustomAdapter
import com.tarik.CardProjectManage.utils.HastaItemViewModel


class HastaRandevuAl : AppCompatActivity() {
    lateinit var binding : ActivityHastaRandevuAlBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_hasta_randevu_al)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivityHastaRandevuAlBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<HastaItemViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 9..17) {
            data.add(HastaItemViewModel(R.drawable.baseline_access_time_24,  "$i.00"))

        }

        // This will pass the ArrayList to our Adapter
        val adapter = HastaCustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        adapter.setOnClickListener(object:HastaCustomAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                var toast = Toast.makeText(this@HastaRandevuAl, "Randevunuz alındı", Toast.LENGTH_LONG)
                toast.show()
            }
        })

    }
}