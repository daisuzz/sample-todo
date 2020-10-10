package com.daisuzz.samplethymeleaftodo.util

import org.springframework.stereotype.Component
import java.util.*

@Component
class IDGenerator {

    fun generateId(): String {
        return UUID.randomUUID().mostSignificantBits.toString()
    }
}
