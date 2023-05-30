package com.tarik.CardProjectManage.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

open class BaseActivity : AppCompatActivity() {
    private var doubleBackToExitPressedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    fun getCurrentUserID():String{
     return FirebaseAuth.getInstance().currentUser!!.uid
    }
    fun doubleBacktoExit(){
        if(doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce =true
        Handler().postDelayed({
            doubleBackToExitPressedOnce = false},2000)

    }

}