package com.example.demo.controller;

import com.example.demo.entity.Result;
import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zongguang on 2017/8/21 0021.
 */
@Controller
public class DemoController {

    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public Object index() {
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Object upload(MultipartFile fileData) throws Exception {
        Result result = this.fileService.upLoad(fileData);
        return result;
    }

}
