package com.example.practice18kotline

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class FragmentAnimalList : Fragment() {
    private var callback: OnAnimalSelectedListener? = null

    // Interface to handle item selection
    interface OnAnimalSelectedListener {
        fun onAnimalSelected(animal: String?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAnimalSelectedListener) {
            callback = context
        } else {
            throw RuntimeException(
                "$context must implement OnAnimalSelectedListener"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_animal_list, container, false)

        val listView = view.findViewById<ListView>(R.id.animal_list_view)

        // List of animals
        val animals = arrayOf("Кошка", "Собака")

        // Use the correct reference for the system layout
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, // Use system resource
            animals
        )
        listView.adapter = adapter

        // Handle item click
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                callback?.onAnimalSelected(animals[position])
            }

        return view
    }
}
