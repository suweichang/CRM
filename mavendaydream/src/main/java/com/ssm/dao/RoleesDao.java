package com.ssm.dao;

import com.ssm.pojo.Power;
import com.ssm.pojo.RoleUpdate;
import com.ssm.pojo.Rolees;
import org.apache.ibatis.annotations.Param;

import java.util.*;
public interface RoleesDao {
    List<Rolees> getAllRoles();
    List<Rolees> getAllRoless();
    boolean updateRoleStatus(RoleUpdate roleUpdate);
    List<Power> getPowerByRoleid(Integer role_id);
    Rolees getRoleesByid(Integer role_id);
    boolean updateRoleName(@Param("role_id") Integer role_id, @Param("role_name") String role_name);
    boolean addRole(String role_name);
    Rolees getRoleesByName(String role_name);
}
