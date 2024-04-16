package com.example.aula06

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_city") // definindo a data class como entidade no banco de dados
data class City(
    @PrimaryKey(autoGenerate = true) // definindo id como primary key da entidade
    @ColumnInfo(name = "id") // nome da coluna na tabela
    var id : Int,
    @ColumnInfo(name = "city_name") // nome da coluna na tabela
    var name : String,
    @ColumnInfo(name = "city_population") // nome da coluna na tabela
    var population : Int,
    @ColumnInfo(name = "city_capital", defaultValue = "false") // nome da coluna na tabela
    var isCapital : Boolean = false
)
