package com.muriloOrias

import com.muriloOrias.dto.TaskRequest
import com.muriloOrias.dto.toTaskResponse
import com.muriloOrias.repository.TasksRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val repository = TasksRepository()
    routing {
        get("/tasks") {
            val response = repository.tasks().map {
                it.toTaskResponse()
            }
            call.respond(response)
        }
        post("/tasks"){
            val rquest = call.receive<TaskRequest>()
            repository.save(rquest.toTask())?.let {
                call.respondText("tarefa foi criada", status = HttpStatusCode.Created)
            } ?: call.respondText("a tarefa nao foi criada", status = HttpStatusCode.BadRequest)

        }
    }
}
