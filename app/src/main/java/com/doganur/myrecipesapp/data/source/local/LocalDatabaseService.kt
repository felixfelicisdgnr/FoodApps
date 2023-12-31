package com.doganur.myrecipesapp.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.doganur.myrecipesapp.data.model.entity.Meal

@Database(entities = [Meal::class], version = 1)
@TypeConverters(MealTypeConverter::class)
abstract class LocalDatabaseService : RoomDatabase() {

    abstract fun mealDao(): MealDao //interface erişmemi sağlayacak fonk. yazacağız. Buradaki fonk. çalıştırmaya çalışacağız. Veritabanına ve Dao interfaceine erişim sağlıyor

    companion object {
        @Volatile
        var INSTANCE: LocalDatabaseService? = null

        @Synchronized
        fun getInstance(context: Context): LocalDatabaseService {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, LocalDatabaseService::class.java, "mealdetail.data")
                    .fallbackToDestructiveMigration().build()
            }
            return INSTANCE as LocalDatabaseService
        }
    }
}