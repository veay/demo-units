package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Echos
 * @since 2017/9/14
 */

@Controller
@RequestMapping("activity")
public class ActivityController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/demo")
    public String demo(){
        return "activity1";
    }
}
