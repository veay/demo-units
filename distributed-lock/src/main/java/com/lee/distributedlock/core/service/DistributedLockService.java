package com.lee.distributedlock.core.service;

import com.lee.distributedlock.common.entity.RedissonConnector;
import com.lee.distributedlock.core.dao.DistributedLockDao;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jack
 * @since 2017/12/15
 */
@Service
public class DistributedLockService {


    @Autowired
    DistributedLockDao distributedLockDao;

    @Autowired
    private RedissonConnector redissonConnector;
    /**
     * 获取唯一主键
     * @return
     */
    public long getId(){
        long id = 0;

        RedissonClient redisson= redissonConnector.getClient();
        RLock rlock = redisson.getLock("lock");
        try {
            boolean isLock = rlock.tryLock(1100,5000, TimeUnit.MILLISECONDS);
            if (isLock) {
                id = distributedLockDao.getId();
                if (id>0){
                   distributedLockDao.updateId(id);
                }
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException){
                return 0;
            }
        }
        rlock.unlock();
        return id;
    }

    public void initData(){
        distributedLockDao.initData();
    }


}
