package com.example;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author Echos
 * @since 2017/9/26
 */
@Component
public class TaskTester {

    @Async
    public Future<String> doTask2() throws InterruptedException{
        System.out.println("Task2 started.");
        long start = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();

        System.out.println("Task2 finished, time elapsed: {} ms."+(end-start));

        return new AsyncResult<>("Task2 accomplished!");
    }
}
