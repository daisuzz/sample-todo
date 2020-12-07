package com.daisuzz.samplethymeleaftodo.domain.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class TodoUserDetailsService(
    private val todoUserRepository: TodoUserRepository,
    private val todoRoleRepository: TodoRoleRepository
) : UserDetailsService {

    override fun loadUserByUsername(userId: String): UserDetails {

        val roleList: List<String> = todoRoleRepository.findAllByUserId(userId)

        val authorities: List<GrantedAuthority> =
            AuthorityUtils.createAuthorityList(*roleList.toTypedArray())

        val todoUser: TodoUser? = todoUserRepository.findByUserId(userId)

        return todoUser?.let { TodoUserDetails(todoUser, authorities) }
            ?: throw UsernameNotFoundException("not found")
    }
}
