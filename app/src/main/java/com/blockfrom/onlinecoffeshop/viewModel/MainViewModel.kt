package com.blockfrom.onlinecoffeshop.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blockfrom.onlinecoffeshop.model.CategoryModel
import com.blockfrom.onlinecoffeshop.model.ItemsModel
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainViewModel : ViewModel() {

    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val _category = MutableLiveData<MutableList<CategoryModel>>()

    val category: LiveData<MutableList<CategoryModel>> = _category
    private val _popular = MutableLiveData<MutableList<ItemsModel>>()


    fun loadCategory(){

        val Ref = firebaseDatabase.getReference("Category")
        Ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<CategoryModel>()

                for(childSnapShot in snapshot.children){

                    val list = childSnapShot.getValue(CategoryModel::class.java)

                    if (list != null){
                        lists.add(list)
                    }
                }
                _category.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }

    fun loadPopular(){
        val Ref = firebaseDatabase.getReference("Items")
        Ref.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemsModel>()
                for (childSnapshot in snapshot.children ){

                    val list = childSnapshot.getValue((ItemsModel::class.java))
                    if (list!= null){
                        lists.add(list)
                    }
                }
                _popular.value = lists

            }

            override fun onCancelled(error: DatabaseError) {

            }


        })
    }

}