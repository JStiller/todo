package de.todo.application.services

import org.springframework.stereotype.Service
import de.todo.application.port.output.TodoRepository
import de.todo.domain.models.Todo
import de.todo.domain.services.TodoDomainService

@Service
class TodoService(private val todoRepository: TodoRepository, private val todoDomainService: TodoDomainService) {
    fun createTodo(todo: Todo): Todo {
        if(!todoDomainService.validate()) {
            throw IllegalArgumentException("Invalid todo")
        }

        return todoRepository.save(todo)
    }

    fun updateTodo(todo: Todo): Todo {
        if(!todoDomainService.validate()) {
            throw IllegalArgumentException("Invalid todo")
        }

        return todoRepository.update(todo)
    }

    fun getById(id: String): Todo? {
        return todoRepository.getById(id)
    }

    fun getAll(): List<Todo> {
        return todoRepository.getAll()
    }
}