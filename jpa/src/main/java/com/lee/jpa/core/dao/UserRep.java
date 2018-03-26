package com.lee.jpa.core.dao;

import com.lee.jpa.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jack
 * @since 2018/3/26
 */
public interface UserRep extends JpaRepository<User,Integer>{
}
