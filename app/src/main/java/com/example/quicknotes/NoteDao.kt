package com.example.quicknotes

import androidx.lifecycle.LiveData
import androidx.room.*

//In the DAO (data access object), you specify SQL queries and associate them with method calls.
//The compiler checks the SQL and generates queries from convenience annotations for common queries,
// such as @Insert. Room uses the DAO to create a clean API for your code.
//The DAO must be an interface or abstract class.
//By default, all queries must be executed on a separate thread.
@Dao
interface NoteDao {

    //insert annotation : it will automtically execute insert query when 'insert' function
    //will be called
     @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)

    //suspend is coroutine in kotlin
    //It is used so these long running task execute in the backgroud without affecting the main UI
    //suspend function can be called only using background thread or another suspend function
    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from Note_Table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>//LiveData gives all the records of changes in the data
    //to the LiveDataObserve(MainActivity in our case)
}