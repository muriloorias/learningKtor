package com.muriloOrias.dto

import com.muriloOrias.model.Task
import kotlinx.serialization.Serializable

@Serializable
class TaskRequest(
    val title: String,
    val description: String
) {
    fun toTask() = Task(
        title = title,
        description = description
    )
}