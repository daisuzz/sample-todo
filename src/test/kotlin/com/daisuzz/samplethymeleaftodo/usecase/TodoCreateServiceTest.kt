package com.daisuzz.samplethymeleaftodo.usecase

import com.daisuzz.samplethymeleaftodo.infrastructure.todo.TodoMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.junit.jupiter.Testcontainers
import java.io.File

@SpringBootTest
@Testcontainers
class TodoCreateServiceTest {

    private val instance: KDockerComposeContainer by lazy { defineDockerCompose() }

    class KDockerComposeContainer(file: File) : DockerComposeContainer<KDockerComposeContainer>(file)

    private fun defineDockerCompose() = KDockerComposeContainer(File("docker-compose.yml"))
        .withExposedService("db-server", 3306)

    @MockBean
    lateinit var todoMapper: TodoMapper

    @Autowired
    lateinit var todoCreateService: TodoCreateService

    @BeforeEach
    fun setup() {
        instance.start()
    }

    @Test
    fun TODOを作成することができる() {

        doNothing().`when`(todoMapper).create(any())

        val todoCreateDto = TodoCreateDto("title", "detail")
        todoCreateService.createTodo(todoCreateDto)

        verify(todoMapper).create(any())
    }
}
