package com.daisuzz.samplethymeleaftodo.domain.auth

import java.io.Serializable

data class TodoUser(
    val userId: String,
    val userName: String,
    val password: String
) : Serializable
