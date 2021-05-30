package com.daisuzz.samplethymeleaftodo.usecase

import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.junit.jupiter.Testcontainers
import java.io.File

@Testcontainers
abstract class AbstractIntegrationTest {

    companion object {

        class KDockerComposeContainer(file: File) : DockerComposeContainer<KDockerComposeContainer>(file)

        private val instance: KDockerComposeContainer by lazy { defineDockerCompose() }

        private fun defineDockerCompose() = KDockerComposeContainer(File("docker-compose.yml"))
            .withExposedService("db-server", 3306)

        init {
            instance.start()
        }
    }
}
