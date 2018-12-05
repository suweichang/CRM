package com.ssm.service.impl;

import com.ssm.dao.NoticeDao;
import com.ssm.pojo.Notice;
import com.ssm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<Notice> GetAllNotices(String notice_title, String notice_content) {
        return noticeDao.GetAllNotices(notice_title,notice_content);
    }

    @Override
    public Notice GetAllNoticeById(Integer notice_id) {
        return noticeDao.GetAllNoticeById(notice_id);
    }

    @Override
    public Integer AddNotice(Notice notice) {
        return noticeDao.AddNotice(notice);
    }

    @Override
    public Integer UpDAteNotice(Notice notice) {
        return noticeDao.UpDAteNotice(notice);
    }

    @Override
    public Integer DelNoticeById(Integer notice_id) {
        return noticeDao.DelNoticeById(notice_id);
    }
}
