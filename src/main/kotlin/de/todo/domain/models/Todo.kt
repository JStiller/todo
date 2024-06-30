package de.todo.domain.models

import java.util.UUID

data class Todo(val id: String = UUID.randomUUID().toString(), var title: String, var category: String, var description: String = "", var status: Boolean = false) {
    init {
        require(UUID.fromString(id).toString() == id) { "ID must be a valid uuid." }
        require(title.isNotBlank()) { "Title is required and must to be defined with an not empty string."}
        require(category.isNotBlank()) { "Category is required and must to be defined with an not empty string."}
    }
}