package com.daisuzz.samplethymeleaftodo.infrastructure.auth

import com.daisuzz.samplethymeleaftodo.domain.auth.UserRoleMapper
import com.daisuzz.samplethymeleaftodo.domain.auth.TodoRoleRepository
import org.springframework.stereotype.Repository

@Repository
class TodoRoleRepositoryImpl(private val userRoleMapper: UserRoleMapper) : TodoRoleRepository {
    override fun findAllByUserId(userId: String): List<String> {
        return userRoleMapper.findAllByUserId(userId)
    }
}
