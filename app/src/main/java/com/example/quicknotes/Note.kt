package com.example.quicknotes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity

@Entity(tableName = "Note_Table") //using entity annotation, there will be created a table of Note class in SQLite
class Note(@ColumnInfo("text")val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}