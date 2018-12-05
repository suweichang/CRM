package com.ssm.service;

import com.ssm.pojo.Models;
import com.ssm.pojo.Useres;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public interface UseresService {
    boolean useresLogin(String username, String passwor, HttpServletRequest request);
    Map<Models,List<Models>> getUseresModel(String username);
    Useres getUseresByname(String username);
    List<Useres> getAllUser(Integer user_id);

    boolean updateUser(Useres useres);

    boolean updateUsers(Useres useres);
}
