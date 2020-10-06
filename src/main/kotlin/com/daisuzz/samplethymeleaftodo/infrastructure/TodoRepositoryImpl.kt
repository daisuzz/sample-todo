package com.daisuzz.samplethymeleaftodo.infrastructure

import com.daisuzz.samplethymeleaftodo.domain.Todo
import com.daisuzz.samplethymeleaftodo.domain.TodoRepository
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryImpl(private val todoMapper: TodoMapper) : TodoRepository {

    override fun getAllTodo(): List<Todo> {
        return todoMapper.findAll().map { Todo(it.id, it.title, it.detail, it.isDone) }
    }

    override fun createTodo(todo: Todo) {
        todoMapper.create(TodoEntity(todo.id, todo.title, todo.detail, todo.isDone))
    }

    override fun deleteTodo(id: String) {
        todoMapper.delete(id)
    }
}
