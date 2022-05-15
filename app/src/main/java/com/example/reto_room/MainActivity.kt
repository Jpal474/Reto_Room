package com.example.reto_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.reto_room.database.DatabaseManager.Companion.instance
import com.example.reto_room.database.User
import com.example.reto_room.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val instancia : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cont=1
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUser.setOnClickListener {

            instancia.saveUser(User(
                0,
                user_name = binding.etUserAmount.text.toString()+"",
            ))
           // cont++
            Log.d("prueba", "datos del edit")
            updateList()
        }

    }
    fun updateList(){
        instancia.getUsers()
        instancia.savedUsers.observe(this){usersList ->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_name)

                    binding.rvUserEntries.adapter = MainAdapter(usersList)
                }


            }else {
                Log.d("users", "null or empty")
            }
        }
    }
}