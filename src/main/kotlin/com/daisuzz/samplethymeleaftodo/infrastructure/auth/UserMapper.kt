package com.daisuzz.samplethymeleaftodo.infrastructure.auth

import com.daisuzz.samplethymeleaftodo.domain.auth.TodoUser
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

    @Select("select * from t_user where user_id = #{userId}")
    fun findByUserId(userId: String): TodoUser?
}
