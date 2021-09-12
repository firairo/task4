package by.stacy.task4.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [AnimalEntity::class], version = 1, exportSchema = true)
abstract class AnimalRoomDatabase : RoomDatabase() {

    abstract fun animalDao(): AnimalDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AnimalRoomDatabase? = null

        fun getDatabase(context: Context): AnimalRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimalRoomDatabase::class.java,
                    "animal_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}