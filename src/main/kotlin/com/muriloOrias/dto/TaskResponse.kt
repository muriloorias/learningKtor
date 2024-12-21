package com.muriloOrias.dto

import com.muriloOrias.model.Task
import kotlinx.serialization.Serializable


@Serializable
data class TaskResponse(
    val id: String,
    val title: String,
    val description: String,
    val isDone: Boolean
)

fun Task.toTaskResponse() = TaskResponse(
    id = id.toString(),
    title = title,
    description = description,
    isDone = isDone
)