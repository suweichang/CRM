package com.ssm.service;

import com.ssm.pojo.AddPower;
import com.ssm.pojo.Power;
import com.ssm.pojo.RoleUpdate;
import com.ssm.pojo.Rolees;

import javax.management.relation.Role;
import java.util.*;

public interface RoleesService {
    List<Rolees> getAllRoles();
    List<Rolees> getAllRoless();
    boolean updateRoleStatus(RoleUpdate roleUpdate);
    List<Power> getPowerByRoleid(Integer role_id);
    Rolees getRoleByid(Integer role_id);
    boolean deletePower(Integer role_id);
    boolean addPower(AddPower addPower);
    boolean updateRoleName(Integer role_id, String role_name);
    boolean addRole(String role_name);
    Rolees getRoleesByName(String role_name);
}
