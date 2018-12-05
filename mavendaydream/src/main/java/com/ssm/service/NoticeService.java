package com.ssm.service;

import com.ssm.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeService {
    List<Notice> GetAllNotices(String notice_title,String notice_content);
    Notice GetAllNoticeById(Integer notice_id);
    Integer AddNotice(Notice notice);
    Integer UpDAteNotice(Notice notice);
    Integer DelNoticeById(Integer notice_id);
}
