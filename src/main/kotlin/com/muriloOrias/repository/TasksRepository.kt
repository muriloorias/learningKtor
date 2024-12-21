package com.muriloOrias.repository

import com.muriloOrias.database.dao.TaskDao
import com.muriloOrias.model.Task

class TasksRepository(
    private val dao: TaskDao = TaskDao()
) {

    suspend fun tasks() = dao.findAll()

    suspend fun save(task: Task) = dao.save(task)


}