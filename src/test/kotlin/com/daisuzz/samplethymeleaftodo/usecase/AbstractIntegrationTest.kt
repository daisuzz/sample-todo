package com.daisuzz.samplethymeleaftodo.usecase

import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.junit.jupiter.Testcontainers
import java.io.File

@Testcontainers
abstract class AbstractIntegrationTest {

    companion object {

        class KDockerComposeContainer(file: File) : DockerComposeContainer<KDockerComposeContainer>(file)

        init {
            val instance: KDockerComposeContainer = KDockerComposeContainer(File("docker-compose.yml"))
                .withExposedService("db-server", 3306)

            instance.start()
        }
    }
}
