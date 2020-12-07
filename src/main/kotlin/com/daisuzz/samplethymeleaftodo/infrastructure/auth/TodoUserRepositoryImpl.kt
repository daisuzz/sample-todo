package com.daisuzz.samplethymeleaftodo.infrastructure.auth

import com.daisuzz.samplethymeleaftodo.domain.auth.TodoUser
import com.daisuzz.samplethymeleaftodo.domain.auth.TodoUserRepository
import com.daisuzz.samplethymeleaftodo.domain.auth.UserMapper
import org.springframework.stereotype.Repository

@Repository
class TodoUserRepositoryImpl(private val userMapper: UserMapper) : TodoUserRepository {
    override fun findByUserId(userId: String): TodoUser? {
        return userMapper.findByUserId(userId)
    }
}
