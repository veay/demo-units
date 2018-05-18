package com.lee.service;

import com.lee.dto.AppointExecution;
import com.lee.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jack
 * @since 2018/5/17
 */
public interface BookService {

    /**
     * 查询一本图书
     *
     * @param bookId
     * @return
     */
    Book getById(long bookId);

    /**
     * 查询所有图书
     *
     * @return
     */
    List<Book> getList();

    /**
     * 预约图书
     *
     * @param bookId
     * @param studentId
     * @return
     */
    AppointExecution appoint(long bookId, long studentId);
}
