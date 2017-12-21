package com.lee.distributedlock.common.entity;

/**
 * 全局事务锁
 * @author jack
 * @since 2017/12/15
 */
public class Lock {
    private String name;
    private String value;

    public Lock(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
