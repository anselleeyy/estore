package cn.njxzc.estore.dao;

import org.apache.ibatis.annotations.Select;

import cn.njxzc.estore.entity.Role;

public interface IRoleDao {
    
    @Select(value = "select * from tb_role where id = #{roleId}")
    public Role getRoleById(int roleId);

}
