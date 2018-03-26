package com.lee.jpa.core.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author jack
 * @since 2018/3/26
 */
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
public class User {

    public User(){}

    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;
}
