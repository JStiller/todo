package de.todo.adapters.input.api

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import de.todo.application.services.TodoService
import de.todo.domain.models.Todo

@RestController
@CrossOrigin(origins = ["http://127.0.0.1:4200"])
@RequestMapping("/api/v1/todo")
class TodoController(private val todoService: TodoService) {
    @PostMapping("/")
    fun createTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        val savedTodo = todoService.createTodo(todo)

        return ResponseEntity(savedTodo, HttpStatus.CREATED)
    }

    @PutMapping("/")
    fun updateTodo(@RequestBody todo: Todo): ResponseEntity<Todo> {
        val updatedTodo = todoService.updateTodo(todo)

        return ResponseEntity(updatedTodo, HttpStatus.OK)
    }

    @GetMapping("/")
    fun getAllTodos(): ResponseEntity<List<Todo>> {
        val todo = todoService.getAll()

        return ResponseEntity(todo, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: String): ResponseEntity<Todo> {
        val todo = todoService.getById(id)

        return if (todo != null) {
            ResponseEntity(todo, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }

    }
}