package com.doganur.myrecipesapp.data.repository

import androidx.lifecycle.LiveData
import com.doganur.myrecipesapp.data.model.CategoryList
import com.doganur.myrecipesapp.data.model.MealList
import com.doganur.myrecipesapp.data.model.MealsByCategoryList
import com.doganur.myrecipesapp.data.model.entity.Meal
import com.doganur.myrecipesapp.domain.datasource.local.LocalDataSource
import com.doganur.myrecipesapp.domain.datasource.remote.RemoteDataSource
import com.doganur.myrecipesapp.domain.repository.MealsRepository
import retrofit2.Call
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : MealsRepository {

    override suspend fun getRandomMeal(): List<MealList> {
        return remoteDataSource.getRandomMeal()
    }

    override suspend fun getCategoriesMeal(): List<CategoryList> {
        return remoteDataSource.getCategoriesMeal()
    }
    override suspend fun getMostPopularMeals(categoryName: String): List<MealsByCategoryList> {
        return remoteDataSource.getMostPopularMeals(categoryName)
    }

    override suspend fun getMealDetail(id: String): List<MealList> {
        return remoteDataSource.getMealDetail(id)
    }

    override suspend fun getMealsByCategory(categoryName: String): List<MealsByCategoryList> {
        return remoteDataSource.getMealsByCategory(categoryName)
    }

    override suspend fun getAllFavouriteMeals(): LiveData<List<Meal>>  = localDataSource.getAllFavouriteMeals()

    override suspend fun addToFavouriteMeal(meal: Meal)  = localDataSource.addToFavouriteMeal(meal)

    override suspend fun deleteFavouriteMeal(meal: Meal) = localDataSource.deleteFavouriteMeal(meal)
}