package com.lee.service;

import com.lee.BaseTest;
import com.lee.dto.AppointExecution;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author jack
 * @since 2018/5/17
 */
public class BookServiceImplTest extends BaseTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testAppoint() throws Exception {
        long bookId = 1002;
        long studentId = 12345678910L;
        AppointExecution execution = bookService.appoint(bookId, studentId);
        System.out.println(execution);
    }

}
