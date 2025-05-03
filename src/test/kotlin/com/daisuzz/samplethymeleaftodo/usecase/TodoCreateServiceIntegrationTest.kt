package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.infrastructure.todo.TodoMapper
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoBean

@SpringBootTest
class TodoCreateServiceIntegrationTest : AbstractIntegrationTest() {

    @MockitoBean
    lateinit var todoMapper: TodoMapper

    @Autowired
    lateinit var todoCreateService: TodoCreateService

    @Test
    fun TODOを作成することができる() {

        doNothing().`when`(todoMapper).create(any())

        val todoCreateDto = TodoCreateDto("title", "detail")
        todoCreateService.createTodo(todoCreateDto)

        verify(todoMapper).create(any())
    }
}
