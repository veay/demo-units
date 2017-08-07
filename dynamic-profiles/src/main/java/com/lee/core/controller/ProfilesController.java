package com.lee.core.controller;

import com.lee.base.ProfilesProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jackl on 2017.8.5.
 */
@Controller
@RequestMapping("/")
public class ProfilesController {

    @Autowired
    ProfilesProperty profilesProperty;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public Object index(){
        return profilesProperty;
    }
}
