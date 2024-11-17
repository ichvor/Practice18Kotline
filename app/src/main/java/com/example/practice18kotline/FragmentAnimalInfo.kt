package com.example.practice18kotline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentAnimalInfo : Fragment() {

    private lateinit var animalImage: ImageView
    private lateinit var animalInfo: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal_info, container, false)
        animalImage = view.findViewById(R.id.animal_image)
        animalInfo = view.findViewById(R.id.animal_info)
        return view
    }

    fun updateAnimalInfo(animal: String?) {
        if (animal == null) return

        val imageResId: Int
        val textResId: Int

        // Assign appropriate image and text based on the selected animal
        when (animal) {
            "Кошка" -> {
                imageResId = R.drawable.cat
                textResId = R.string.cat_info
            }
            "Собака" -> {
                imageResId = R.drawable.dog
                textResId = R.string.dog_info
            }
            else -> {
                imageResId = 0
                textResId = 0
            }
        }

        // Update the UI if valid resources are found
        if (imageResId != 0 && textResId != 0) {
            animalImage.setImageResource(imageResId)
            animalInfo.setText(textResId)
        } else {
            animalInfo.text = getString(R.string.unknown_animal)
            animalImage.setImageDrawable(null)
        }
    }
}
