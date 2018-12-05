package com.ssm.dao;

import com.ssm.pojo.Useres;
import org.apache.ibatis.annotations.Param;

import java.util.*;

public interface UseresDao {
    Useres useresLogin(String username);
    List<Useres> getAllUser(@Param("user_id") Integer user_id);

    boolean updateUser(Useres useres);

    boolean updateUsers(Useres useres);
}
