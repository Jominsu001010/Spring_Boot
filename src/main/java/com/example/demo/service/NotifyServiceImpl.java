package com.example.demo.service;

import com.example.demo.dao.MemberDao;
import com.example.demo.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.NotifyDO;

import java.util.List;

@Service
public class NotifyServiceImpl implements NotifyService {

    @Autowired
    private MemberDao notifyDao;

    @Override
    public NotifyDO getNotify(String notifyId) {
        return notifyDao.getNotify(notifyId);
    }

    @Override
    public List<NotifyDO> getAllNotifies() {
        return null;
    }

    @Override
    public int registerNotify(NotifyDO notify) {
        return notifyDao.insertNotify(notify);
    }

    @Override
    public int updateNotify(NotifyDO notify) {
        return 0;
    }


    @Override
    public int deleteNotify(String notifyId) {
        return notifyDao.deleteNotify(notifyId);
    }
}
