package com.example.reto_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.reto_room.database.DatabaseManager.Companion.instance
import com.example.reto_room.database.User
import com.example.reto_room.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val instancia=MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var cont=1
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnUser.setOnClickListener {
            instancia.saveUser(User(
                cont.toString()+"",
                binding.etUserAmount.text.toString()+"",
            ))
        }
        cont++
    }
}