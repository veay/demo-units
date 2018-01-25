package com.lee.distributedlock.core.service;

import com.lee.distributedlock.common.entity.Lock;
import com.lee.distributedlock.common.handle.DistributedLockHandler;
import com.lee.distributedlock.core.dao.DistributedLockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author jack
 * @since 2017/12/15
 */
@Service
public class DistributedLockService {

    @Autowired
    DistributedLockHandler distributedLockHandler;

    @Autowired
    DistributedLockDao distributedLockDao;
    /**
     * 获取唯一主键
     * @return
     */
    public long getId(){
        long id = 0;
        Lock lock=new Lock("lockk","sssssssss");
        if (distributedLockHandler.tryLock(lock)){
            id = distributedLockDao.getId();
            if (id>0){
                boolean flag = distributedLockDao.updateId(id);
                if (!flag){
                    id = 0;
                }
            }
            distributedLockHandler.releaseLock(lock);
        }
        return id;
    }

    public void initData(){
        distributedLockDao.initData();
    }


}
