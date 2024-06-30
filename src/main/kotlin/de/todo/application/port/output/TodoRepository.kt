package de.todo.application.port.output

import de.todo.domain.models.Todo

interface TodoRepository {
    fun save(todo: Todo): Todo
    fun update(todo: Todo): Todo
    fun getById(id: String): Todo?
    fun getAll(): List<Todo>
}