package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.infrastructure.todo.TodoEntity
import com.daisuzz.samplethymeleaftodo.infrastructure.todo.TodoMapper
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class TodoUpdateServiceTest : AbstractIntegrationTest() {

    @MockBean
    lateinit var todoMapper: TodoMapper

    @Autowired
    lateinit var todoUpdateService: TodoUpdateService

    @Test
    fun TODOを更新できる() {
        val oldTodo = TodoEntity("1", "title", "detail", false)

        `when`(todoMapper.find("1")).thenReturn(oldTodo)
        doNothing().`when`(todoMapper).update(any())

        todoUpdateService.updateTodo("1", true)

        verify(todoMapper).find("1")
        verify(todoMapper).update(any())
    }
}
