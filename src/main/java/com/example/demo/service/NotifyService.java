package com.example.demo.service;

import com.example.demo.domain.NotifyDO;

import java.util.List;

public interface NotifyService {
    NotifyDO getNotify(String notifyId);

    List<NotifyDO> getAllNotifies();

    int registerNotify(NotifyDO notify);

    int updateNotify(NotifyDO notify);

    int deleteNotify(String notifyId);
}
