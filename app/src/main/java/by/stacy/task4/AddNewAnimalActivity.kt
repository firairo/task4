package by.stacy.task4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.stacy.task4.databinding.AddNewAnimalAcvtivityBinding
import by.stacy.task4.db.AnimalEntity
import by.stacy.task4.db.AnimalRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class AddNewAnimalActivity: AppCompatActivity() {
    private lateinit var binding: AddNewAnimalAcvtivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddNewAnimalAcvtivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var id = 0
        var name = ""
        var age = ""
        var breed = ""

        val db = AnimalRoomDatabase.getDatabase(this)


        binding.addButton.setOnClickListener {
            name = binding.editName.text.toString()
            age = binding.editAge.text.toString()
            breed = binding.editBreed.text.toString()
            val animalEntity = AnimalEntity(id, name, age, breed)

            GlobalScope.launch(Dispatchers.IO) {
                db.animalDao().insert(animalEntity)
            }

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("age", age)
            intent.putExtra("breed", breed)
            startActivity(intent)
        }
    }
}