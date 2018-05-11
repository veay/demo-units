package com.example.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author Echos
 * @since 2017/9/15
 */
@Component
public class Task {

    public static Random random =new Random();

    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");

        return new AsyncResult<>("完成任务一");
    }

    @Async
    public Future<String> doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("完成任务二");
    }
    @Async
    public Future<String> doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("完成任务三");
    }

    /**
     * @author Echos
     * @since 2017/9/26
     */
    @Component
    public static class TaskTest {


        @Autowired
        Task task;

    //    @Autowired
    //    TaskTest task2;


        @Scheduled(cron = "0/1 * * * * ?")
        public void test() throws Exception {
            task.doTaskOne();
    //        task2.task();
            System.out.println(System.currentTimeMillis());
        }

        @Async
        public void task(){
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("work");
        }

        @Async
        public void task2(){
            System.out.println(System.currentTimeMillis());
        }
    }
}
