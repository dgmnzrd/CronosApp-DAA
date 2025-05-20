package com.example.cronoapps.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cronoapps.model.Cronos
import kotlinx.coroutines.flow.Flow

// Interface -> Repositorios -> ViewModel -> View

@Dao // Data Access Object
interface CronosDatabaseDao {
    // Crud

    @Query("Select * From cronos")
    fun getCronos(): Flow<List<Cronos>>

    @Query("Select * From cronos Where id = :id")
    fun getCronosById(id: Long): Flow<Cronos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cronos: Cronos)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(cronos: Cronos)

    @Delete
    suspend fun delete(cronos: Cronos)

}