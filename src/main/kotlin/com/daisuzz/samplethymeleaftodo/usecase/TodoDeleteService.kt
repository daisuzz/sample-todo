package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.domain.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoDeleteService(private val todoRepository: TodoRepository) {

    fun deleteTodo(id: String) {
        todoRepository.deleteTodo(id)
    }
}
