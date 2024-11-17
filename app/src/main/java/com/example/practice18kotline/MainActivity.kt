package com.example.practice18kotline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentAnimalList.OnAnimalSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_list, FragmentAnimalList())
                .replace(R.id.fragment_container_info, FragmentAnimalInfo())
                .commit()
        }
    }

    override fun onAnimalSelected(animal: String?) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container_info) as? FragmentAnimalInfo

        fragment?.updateAnimalInfo(animal)
    }
}
