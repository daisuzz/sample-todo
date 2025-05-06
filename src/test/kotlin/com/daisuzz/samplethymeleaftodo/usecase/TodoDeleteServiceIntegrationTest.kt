package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.infrastructure.todo.TodoMapper
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.bean.override.mockito.MockitoBean

@SpringBootTest
class TodoDeleteServiceIntegrationTest : AbstractIntegrationTest() {

    @MockitoBean
    lateinit var todoMapper: TodoMapper

    @Autowired
    lateinit var todoDeleteService: TodoDeleteService

    @Test
    fun TODOを削除できる() {
        doNothing().`when`(todoMapper).delete("1")

        todoDeleteService.deleteTodo("1")

        verify(todoMapper).delete("1")
    }
}
