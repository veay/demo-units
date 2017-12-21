package com.lee.distributedlock.core.dao;

import org.springframework.stereotype.Repository;

/**
 * @author jack
 * @since 2017/12/15
 */
@Repository
public class DistributedLockDao {

    /**
     * 获取唯一主键
     * @return
     */
    public long getId(){
        return 0;
    }


    public boolean updateId(long id){

        return false;
    }
}
