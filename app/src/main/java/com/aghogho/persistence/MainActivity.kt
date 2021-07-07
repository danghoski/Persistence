package com.aghogho.persistence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
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

        myShoppingAdapter = ShoppingAdapter(myShoppingList){
            val intent = Intent(this, MainActivity::class.java)

        }
        binding.recyclerView.adapter = myShoppingAdapter

        binding.button.setOnClickListener {
            val category : String = binding.editText1.text.toString()
            val description : String = binding.editText1.text.toString()

            val db = Room.databaseBuilder(
                applicationContext,
                ShoppingDatabase::class.java,"shopping-database"
            ).allowMainThreadQueries().build()

            val shoppingDAO = db.ShoppingDAO()

            myShoppingList = shoppingDAO.getAllShoppingItems().toMutableList()
            myShoppingAdapter.notifyDataSetChanged()


            val shoppingItem = ShoppingModel(category, description)

            shoppingDAO.addShoppingItem(shoppingItem)

            myShoppingAdapter.notifyDataSetChanged()
        }


    }
}