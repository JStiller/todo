package de.todo.adapters.output.database

import de.todo.application.port.output.TodoRepository
import de.todo.domain.models.Todo
import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.dao.EmptyResultDataAccessException

@Repository
class TodoRepositoryImpl(val db: JdbcTemplate): TodoRepository {
    override fun save(todo: Todo): Todo {
        db.update("insert into todos (id, title, category, description, status) values (?, ?, ?, ?, ?)", todo.id, todo.title, todo.category, todo.description, todo.status)

        return todo.copy()
    }

    override fun update(todo: Todo): Todo {
        db.update("update todos set title = ?, category = ?, description = ?, status = ? where id = ?", todo.title, todo.category, todo.description, todo.status, todo.id)

        return todo.copy()
    }

    override fun getById(id: String): Todo? {
        return try {
            db.queryForObject("select * from todos where id = ? limit 1", RowMapper { response, _ ->
                Todo(
                    response.getString("id"),
                    response.getString("title"),
                    response.getString("category"),
                    response.getString("description"),
                    response.getBoolean("status")
                )
            }, id)
        } catch (error: EmptyResultDataAccessException) {
            null
        }
    }

    override fun getAll(): List<Todo> {
        return db.query("select * from todos") { response, _ ->
            val resultList = mutableListOf<Todo>()
            
            while (response.next()) {
                val todo = Todo(
                    response.getString("id"),
                    response.getString("title"),
                    response.getString("category"),
                    response.getString("description"),
                    response.getBoolean("status")
                )
                resultList.add(todo)
            }

            resultList
        }.flatten()
    }
}