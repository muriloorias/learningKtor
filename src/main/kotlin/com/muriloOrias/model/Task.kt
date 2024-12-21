package com.muriloOrias.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table
import java.util.*
// modelo principal
data class Task (
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val isDone: Boolean = false
)

//tabela do banco de dados
object Tasks: Table(){
    val id = uuid("id").autoGenerate()
    val title = text("title")
    val description = text("description")
    val isDone = bool("isDone")

    override val primaryKey = PrimaryKey(id)
}