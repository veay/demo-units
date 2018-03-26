package com.lee.jpa.core.dao;

import com.lee.jpa.core.entity.UserCreateLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jack
 * @since 2018/3/26
 */
public interface UserCreateRsp extends JpaRepository<UserCreateLog,Integer> {
}
