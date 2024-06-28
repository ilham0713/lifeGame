package org.example

import io.ktor.application.*
import io.ktor.features.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.serialization.kotlinx.json
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json(Json { prettyPrint = true })
        }
        routing {
            post("/gameoflife") {
                val request = call.receive<GameOfLifeRequest>()
                val result = runGameOfLife(request.boards, request.iterations)
                call.respondText(result, ContentType.Application.Json)
            }
        }
    }.start(wait = true)
}

@Serializable
data class GameOfLifeRequest(val boards: Array<Array<Array<Int>>>, val iterations: Int)

fun runGameOfLife(startingBoards: Array<Array<Array<Int>>>, iterations: Int): String {
    val results = mutableListOf<Array<Array<Int>>>()
    for (board in startingBoards) {
        var prevBoard = board
        for (i in 0 until iterations) {
            prevBoard = gameOfLife(prevBoard)
        }
        results.add(prevBoard)
    }
    return Json.encodeToString(results)
}
