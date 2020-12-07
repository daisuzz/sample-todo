package com.daisuzz.samplethymeleaftodo.infrastructure.todo

import com.daisuzz.samplethymeleaftodo.domain.todo.Todo
import com.daisuzz.samplethymeleaftodo.domain.todo.TodoRepository
import org.springframework.stereotype.Repository

@Repository
class TodoRepositoryImpl(private val todoMapper: TodoMapper) : TodoRepository {

    override fun getAllTodo(): List<Todo> {
        return todoMapper.findAll().map { Todo(it.id, it.title, it.detail, it.isDone) }
    }

    override fun getTodo(id: String): Todo {
        return todoMapper.find(id).let { Todo(it.id, it.title, it.detail, it.isDone) }
    }

    override fun createTodo(todo: Todo) {
        todoMapper.create(TodoEntity(todo.id, todo.title, todo.detail, todo.isDone))
    }

    override fun updateTodo(todo: Todo) {
        todoMapper.update(TodoEntity(todo.id, todo.title, todo.detail, todo.isDone))
    }

    override fun deleteTodo(id: String) {
        todoMapper.delete(id)
    }
}
