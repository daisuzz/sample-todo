package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.infrastructure.TodoEntity
import com.daisuzz.samplethymeleaftodo.infrastructure.TodoMapper
import com.daisuzz.samplethymeleaftodo.presentation.TodoCreateForm
import com.daisuzz.samplethymeleaftodo.util.IDGenerator
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class TodoCreateServiceTest(@Autowired val todoCreateService: TodoCreateService) {

    @MockBean(name = "todoMapper")
    lateinit var todoMapper: TodoMapper

    @MockBean
    lateinit var idGenerator: IDGenerator

    @Test
    fun createTodo() {

        val form = TodoCreateForm("breakfast", "at 9 am")
        val entity = TodoEntity("12345", "breakfast", "at 9 am", false)

        doNothing().`when`(todoMapper).create(entity)
        `when`(idGenerator.generateId()).thenReturn("12345")

        todoCreateService.createTodo(form)

        verify(todoMapper, times(1)).create(entity)
    }
}
