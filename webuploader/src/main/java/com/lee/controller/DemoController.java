package com.lee.controller;

import com.lee.utils.UploaderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * WebUploader案例controller
 * @author jack
 * @since 2017/9/28
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object  upload(HttpServletRequest request, HttpServletResponse response) {
        UploaderUtil.UploadResult result = UploaderUtil.uploader(request, "d:/", "filenameUploader", "/uploader", null, 1024 * 1024);
        return result;
    }
}
