package com.tarik.CardProjectManage.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import com.tarik.CardProjectManage.activities.DoktorGirisYapEkrani
import com.tarik.CardProjectManage.activities.DoktorKaydolEkrani
import com.tarik.CardProjectManage.models.Doktor_user
import com.tarik.CardProjectManage.utils.DoktorConstans

class DoktorFirestoreClass {
    private val mFireStore = FirebaseFirestore.getInstance()
    fun registerDoktor(activity: DoktorKaydolEkrani, userInfo : Doktor_user) {
        mFireStore.collection(DoktorConstans.USERS)
            .document(getCurrentUserId())
            .set(userInfo,SetOptions.merge())
            .addOnSuccessListener {
                activity.DoktorRegisteredSuccess()
            }.addOnFailureListener { e-> Log.e(activity.javaClass.simpleName,"Hata") }
    }
    fun doktorsignInuser(activity : DoktorGirisYapEkrani){
        mFireStore.collection(DoktorConstans.USERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener {
                document->
                val doktorLoggedInUser = document.toObject(Doktor_user::class.java)!!
                activity.DoktorsignInSuccess(doktorLoggedInUser)
            }.addOnFailureListener { e-> Log.e(activity.javaClass.simpleName,"Hata") }
    }
    fun getCurrentUserId():String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
}