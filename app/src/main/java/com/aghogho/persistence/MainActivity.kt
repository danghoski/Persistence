package com.aghogho.persistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aghogho.persistence.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    private lateinit var myShoppingAdapter: ShoppingAdapter
    private lateinit var myShoppingList: MutableList<ShoppingModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        myShoppingList = mutableListOf()

        myShoppingAdapter = ShoppingAdapter(listOf())
        binding.recyclerView.adapter = myShoppingAdapter

        binding.button.setOnClickListener {
            val category : String = binding.editText1.text.toString()
            val description : String = binding.editText1.text.toString()

            val shoppingItem = ShoppingModel(category, description)
            myShoppingList.add(shoppingItem)
            myShoppingAdapter.notifyDataSetChanged()
        }
    }
}