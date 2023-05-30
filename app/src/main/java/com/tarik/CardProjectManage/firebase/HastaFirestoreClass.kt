package com.tarik.CardProjectManage.firebase

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.tarik.CardProjectManage.activities.HastaGirisYapEkrani
import com.tarik.CardProjectManage.activities.HastaKaydolEkrani
import com.tarik.CardProjectManage.models.Hasta_user
import com.tarik.CardProjectManage.utils.HastaConstans

class HastaFirestoreClass {
    private val mFireStore = FirebaseFirestore.getInstance()
    fun registerHasta(activity: HastaKaydolEkrani, userInfo: Hasta_user) {
        mFireStore.collection(HastaConstans.HASTAUSERS)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.HastaRegisteredSuccess()
            }.addOnFailureListener { e-> Log.e(activity.javaClass.simpleName,"Hata") }
    }
    fun hastaSignInUser(activity:HastaGirisYapEkrani){
        mFireStore.collection(HastaConstans.HASTAUSERS)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener {
                    document->
                val hastaLoggedInUser = document.toObject(Hasta_user::class.java)!!
                activity.HastaSignInSuccess(hastaLoggedInUser)
            }.addOnFailureListener { e-> Log.e(activity.javaClass.simpleName,"Hata") }
    }
    fun getCurrentUserId():String{
        return FirebaseAuth.getInstance().currentUser!!.uid
    }
}