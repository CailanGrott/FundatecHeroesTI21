package br.com.fundatec.fundatecheroesti21.login.data.local


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "userTable")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val password: String,
    val lastLoginTime: Date = Date()
)