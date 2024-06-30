package de.todo.domain.services

import de.todo.domain.models.Todo
import org.springframework.stereotype.Service

@Service
class TodoDomainService {
    fun validate(): Boolean {
        return true
    }

    fun completed(todo: Todo): Todo {
        return todo.copy(status = true)
    }
}