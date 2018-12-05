package com.ssm.aop;

import com.ssm.pojo.Logs;
import com.ssm.pojo.Useres;
import com.ssm.service.LogsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Aspect
public class LogAccept {
    @Autowired
    private LogsService logsServiceImpl;

    @After("execution(* com.ssm.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        int count=0;
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes()))
                    .getRequest();
        String methodName = joinPoint.getSignature().getName();
        Logs logs=new Logs();
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
       String addip=address.getHostAddress(); //返回IP地址
        logs.setIp_address(addip);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date=format.format(new Date());
        Timestamp timestamp=Timestamp.valueOf(date);
        logs.setOperation_time(timestamp);
        Useres useres=(Useres) request.getSession().getAttribute("user");
        if (useres!=null){
            logs.setUser_id(useres.getUser_id());
            if(methodName.equals("useresLogin")){

                logs.setOperation("登录");
                logsServiceImpl.addLogs(logs);

            }
            if(methodName.equals("updateModelStatus")){

                logs.setOperation("修改模块");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("updateModelStatus") || methodName.equals("updateModel")){

                logs.setOperation("修改模块");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("addParentModel") || methodName.equals("addChildModel")){

                logs.setOperation("增加模块");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("updateRoleStatus")){

                logs.setOperation("修改角色状态");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("updateRoleName") ){

                logs.setOperation("修改角色");
                logsServiceImpl.addLogs(logs);

            }
            if(methodName.equals("addRole")){

                logs.setOperation("增加角色");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("AddReview")){

                logs.setOperation("增加评审");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("ChangReviewStatus")){

                logs.setOperation("修改评审");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("AddNotice")){

                logs.setOperation("增加公告");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("UpDAteNotice")){

                logs.setOperation("修改公告");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("DelNoticeById")){

                logs.setOperation("删除公告");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("addStu")){

                logs.setOperation("增加学生");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("updateStu")){

                logs.setOperation("修改学生");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("delStuById")){
                logs.setOperation("删除学生");
                logsServiceImpl.addLogs(logs);
            }
            if(methodName.equals("addStu")){
                logs.setOperation("增加学生");
                logsServiceImpl.addLogs(logs);
            }
        }

    }
}
