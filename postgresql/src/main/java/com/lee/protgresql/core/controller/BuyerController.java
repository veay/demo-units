package com.lee.protgresql.core.controller;

import com.lee.protgresql.core.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jack
 * @since 2017/12/21
 */
@RestController
@RequestMapping("/")
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @RequestMapping("/get")
    public Object getBuyerByNick(String buyerNick){
        return buyerService.getBuyerByNick(buyerNick);
    }

    @RequestMapping("/save")
    public Object saveBuyer(){
        return buyerService.saveBuyer();
    }
}
