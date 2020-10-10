package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.domain.Todo
import com.daisuzz.samplethymeleaftodo.domain.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoUpdateService(private val todoRepository: TodoRepository) {

    fun updateTodo(id: String, isDone: Boolean) {

        val todo = todoRepository.getTodo(id)

        val newTodo = Todo(todo.id, todo.title, todo.detail, isDone)

        todoRepository.updateTodo(newTodo)
    }
}
