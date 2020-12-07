package com.daisuzz.samplethymeleaftodo.domain.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class TodoUserDetails(
    private val todoUser: TodoUser,
    private val authorities: List<GrantedAuthority>
) : UserDetails {

    fun getTodoUser(): TodoUser {
        return todoUser
    }

    override fun getUsername(): String {
        return todoUser.userId
    }

    override fun getPassword(): String {
        return todoUser.password
    }

    override fun getAuthorities(): List<GrantedAuthority> {
        return authorities
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
