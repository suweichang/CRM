package com.ssm.service.impl;

import com.ssm.dao.PowerDao;
import com.ssm.dao.RoleesDao;
import com.ssm.pojo.AddPower;
import com.ssm.pojo.Power;
import com.ssm.pojo.RoleUpdate;
import com.ssm.pojo.Rolees;
import com.ssm.service.RoleesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleesServiceImpl implements RoleesService {
    @Autowired
    private RoleesDao roleesDao;
    @Autowired
    private PowerDao powerDao;

    @Override
    public List<Rolees> getAllRoles() {
        return roleesDao.getAllRoles();
    }

    @Override
    public List<Rolees> getAllRoless() {
        return roleesDao.getAllRoless();
    }

    @Override
    public boolean updateRoleStatus(RoleUpdate roleUpdate) {
        return roleesDao.updateRoleStatus(roleUpdate);
    }

    @Override
    public List<Power> getPowerByRoleid(Integer role_id) {
        return roleesDao.getPowerByRoleid(role_id);
    }

    @Override
    public Rolees getRoleByid(Integer role_id) {
        return roleesDao.getRoleesByid(role_id);
    }

    @Override
    public boolean deletePower(Integer role_id) {
        return powerDao.deletepower(role_id);
    }

    @Override
    public boolean addPower(AddPower addPower) {
        return powerDao.addPower(addPower);
    }

    @Override
    public boolean updateRoleName(Integer role_id, String role_name) {
        return roleesDao.updateRoleName(role_id,role_name);
    }

    @Override
    public boolean addRole(String role_name) {
        return roleesDao.addRole(role_name);
    }

    @Override
    public Rolees getRoleesByName(String role_name) {
        return roleesDao.getRoleesByName(role_name);
    }
}
