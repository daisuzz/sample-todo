package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.domain.Todo
import com.daisuzz.samplethymeleaftodo.domain.TodoRepository
import com.daisuzz.samplethymeleaftodo.presentation.TodoCreateForm
import com.daisuzz.samplethymeleaftodo.util.IDGenerator
import org.springframework.stereotype.Service

@Service
class TodoCreateService(private val todoRepository: TodoRepository,
                        private val idGenerator: IDGenerator) {

    fun createTodo(form: TodoCreateForm) {
        requireNotNull(form.title)
        requireNotNull(form.detail)

        val id = idGenerator.generateId()

        val todo = Todo(id, form.title, form.detail)

        todoRepository.createTodo(todo)
    }
}
