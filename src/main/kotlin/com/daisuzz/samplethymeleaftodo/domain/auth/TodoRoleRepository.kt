package com.daisuzz.samplethymeleaftodo.domain.auth

interface TodoRoleRepository {
    fun findAllByUserId(userId: String): List<String>
}
