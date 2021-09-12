package by.stacy.task4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import by.stacy.task4.databinding.ActivityFilterBinding
import by.stacy.task4.databinding.AddNewAnimalAcvtivityBinding
import by.stacy.task4.db.AnimalRoomDatabase

class FilterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFilterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = AnimalRoomDatabase.getDatabase(this)

        TODO("он клик")
        when {
            binding.buttonName -> {}
            binding.buttonAge -> {}
            binding.buttonName -> {}
        }
}
}