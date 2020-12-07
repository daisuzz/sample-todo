package com.daisuzz.samplethymeleaftodo.domain.auth

interface TodoUserRepository {
    fun findByUserId(userId: String): TodoUser?
}
