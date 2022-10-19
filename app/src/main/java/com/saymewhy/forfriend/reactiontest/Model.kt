package com.saymewhy.forfriend.reactiontest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Model:ViewModel() {
    var count =1;
    val db = Firebase.firestore
    private val mutableNum: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().also {
            loadUsers()
        }
    }

    fun getNum(): LiveData<Int> {
        return mutableNum
    }

    private fun loadUsers() {
        val docRef = db.collection("nums").document("first")
        docRef.addSnapshotListener { snapshot, e ->

            if (snapshot != null && snapshot.exists()) {
                count = (snapshot.data?.get("num") as Long).toInt()
                mutableNum.value = count
            }
        }
    }

    fun ap() {
        count++
        db.collection("nums").document("first").set( hashMapOf(
            "num" to count))

    }
}
