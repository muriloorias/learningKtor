package com.muriloOrias.database.dao

import com.muriloOrias.model.Task
import com.muriloOrias.model.Tasks
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TaskDao {

    suspend fun findAll(): List<Task> = dbQuery {
        Tasks.selectAll().map {
            Task(
                id = it[Tasks.id],
                title = it[Tasks.title],
                description = it[Tasks.description],
                isDone = it[Tasks.isDone]
            )
        }
    }
    suspend fun save(task: Task) = dbQuery {
        Tasks.insert {
            it[id] = task.id
            it[title] = task.title
            it[description] = task.description
            it[isDone] = task.isDone
        }
    }

}

suspend fun <T> dbQuery(block: suspend () -> T): T=
    newSuspendedTransaction(Dispatchers.IO) { block() }