package com.tarik.CardProjectManage.models

import android.os.Parcel
import android.os.Parcelable

data class Hasta_user (
    val id : String = "",
    val name : String = "",
    val email : String = "",
    val password : String = "",
    val image : String = "",
    val mobil : Long = 0,
    val fcmToken : String = "",
    val saat : String = ""
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(dest: Parcel, flags: Int)= with(dest) {
        writeString(id)
        writeString(name)
        writeString(email)
        writeString(password)
        writeString(image)
        writeLong(mobil)
        writeString(fcmToken)
    }

    override fun describeContents()=0

    companion object CREATOR : Parcelable.Creator<Hasta_user> {
        override fun createFromParcel(parcel: Parcel): Hasta_user {
            return Hasta_user(parcel)
        }

        override fun newArray(size: Int): Array<Hasta_user?> {
            return arrayOfNulls(size)
        }
    }
}
