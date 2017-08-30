package com.example.demo.service;


import com.example.demo.entity.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by zongguang on 2017/8/29 0029.
 */
@Service
public interface FileService {

    Result upLoad(MultipartFile multipartFile) throws IOException;

}
