package com.ssm.dao;

import com.ssm.pojo.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeDao {
    List<Notice> GetAllNotices(@Param("notice_title") String notice_title, @Param("notice_content") String notice_content);
    Notice GetAllNoticeById(@Param("notice_id") Integer notice_id);
    Integer AddNotice(Notice notice);
    Integer UpDAteNotice(Notice notice);
    Integer DelNoticeById(@Param("notice_id") Integer notice_id);
}
