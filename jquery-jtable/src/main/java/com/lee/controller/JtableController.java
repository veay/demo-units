package com.lee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jack on 2017/8/9.
 */
@Controller
@RequestMapping("/")
public class JtableController {

    @RequestMapping("/")
    public Object index(){
        return "index";
    }

    @RequestMapping("/fetch")
    @ResponseBody
    public Object fetch(){
        return getData();
    }

    private Map<String,Object> getData(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> temp;
        List<Map<String,Object>> dataList = new ArrayList<>();
        for (int i = 0;i<5;i++){
            temp = new HashMap<>();
            temp.put("id",i+1);
            temp.put("time",System.currentTimeMillis());
            temp.put("name","name"+i);
            temp.put("address","address"+i);
            dataList.add(temp);
        }
        map.put("TotalRecordCount",5);
        map.put("Records",dataList);
        map.put("Result", "OK");
        return map;
    }
}
