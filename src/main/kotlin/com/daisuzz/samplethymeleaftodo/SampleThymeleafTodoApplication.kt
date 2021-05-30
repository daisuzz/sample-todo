package com.daisuzz.samplethymeleaftodo

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.daisuzz.samplethymeleaftodo.infrastructure")
class SampleThymeleafTodoApplication

fun main(args: Array<String>) {
    runApplication<SampleThymeleafTodoApplication>(*args)
}
