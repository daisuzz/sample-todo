package com.daisuzz.samplethymeleaftodo.infrastructure.auth

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserRoleMapper {

    @Select("select m_role.name from t_user_role left join m_role on m_role.id = t_user_role.role_id where user_id = #{userId}")
    fun findAllByUserId(userId: String): List<String>
}
