package com.lee.distributedlock.core.task;

import com.lee.distributedlock.core.service.DistributedLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author jack
 * @since 2018/1/25
 */
@Component
@EnableScheduling
@EnableAsync
public class DistributedLockTask {

    @Autowired
    DistributedLockService distributedLockService;



    @Async
    @Scheduled(cron = "0/1 * *  * * ? ")
    public void startSchedule() {
        for(int i=1;i<=10;i++){
            System.out.println("task1-"+(i)+":"+distributedLockService.getId());
        }
    }
    @Async
    @Scheduled(cron = "0/1 * *  * * ? ")
    public void startSchedule2() {
        for(int i=1;i<=10;i++){
            System.out.println("task2-"+(i)+":"+distributedLockService.getId());
        }
    }
}
