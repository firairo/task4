package by.stacy.task4

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import by.stacy.task4.databinding.ItemRvBinding
import by.stacy.task4.db.AnimalEntity


class AdapterRV(
    private var animals: List<AnimalEntity>
) : RecyclerView.Adapter<AdapterRV.ViewHolder>() {
    private lateinit var binding: ItemRvBinding

    // Создает новый объект ViewHolder всякий раз, когда Recycler нуждается в этом
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Принимает объект ViewHolder и устанавливает необходимые данные для соответсвующей строки во View компоненте
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = "Name: " + animals[position].name
        holder.age.text = "Age: " + animals[position].age
        holder.breed.text = "Breed: " + animals[position].breed
    }

    // Возвращает общее кол-во элементов списка
    override fun getItemCount(): Int {
        return animals.size
    }

    class ViewHolder(binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root) {
        var name: TextView = binding.name
        var age: TextView = binding.age
        var breed: TextView = binding.breed
    }
}
