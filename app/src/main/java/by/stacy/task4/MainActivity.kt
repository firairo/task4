package by.stacy.task4

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.stacy.task4.databinding.ActivityMainBinding
import by.stacy.task4.db.AnimalRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
        val db = AnimalRoomDatabase.getDatabase(this)
        GlobalScope.launch(Dispatchers.IO) {
            val animalList = db.animalDao().getAllAnimal()
            binding.recyclerView.adapter = AdapterRV(animalList)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddNewAnimalActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initToolbar(){
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_filter, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_search -> {
                val intent = Intent(this, AddNewAnimalActivity::class.java)
                startActivity(intent)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}