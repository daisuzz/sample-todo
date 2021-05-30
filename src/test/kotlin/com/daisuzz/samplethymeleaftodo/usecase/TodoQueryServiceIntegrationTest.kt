package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.domain.todo.Todo
import com.daisuzz.samplethymeleaftodo.infrastructure.todo.TodoEntity
import com.daisuzz.samplethymeleaftodo.infrastructure.todo.TodoMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class TodoQueryServiceIntegrationTest : AbstractIntegrationTest() {

    @MockBean
    lateinit var todoMapper: TodoMapper

    @Autowired
    lateinit var todoQueryService: TodoQueryService

    @Test
    fun TODOを取得できる() {

        val todoEntityList = listOf(
            TodoEntity("1", "title", "detail", false),
            TodoEntity("2", "title", "detail", false)
        )
        `when`(todoMapper.findAll()).thenReturn(todoEntityList)

        val actual = todoQueryService.getAllTodo()

        val expect = listOf(
            Todo("1", "title", "detail", false),
            Todo("2", "title", "detail", false)
        )
        Assertions.assertThat(actual).isEqualTo(expect)
        verify(todoMapper).findAll()
    }
}
