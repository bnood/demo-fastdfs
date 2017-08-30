package com.example.demo.service.impl;

import com.example.demo.entity.Result;
import com.example.demo.fastdfs.FastDFSFile;
import com.example.demo.fastdfs.FileManager;
import com.example.demo.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by zongguang on 2017/8/29 0029.
 */
@Service
public class FileServiceImpl implements FileService {

    private Logger logger = LoggerFactory.getLogger(FileService.class);
    private String format[] = {"image/bmp", "image/jpg", "image/jpeg", "image/png", "image/gif"};
    private long maxSize = 3 * 1024;

    public Result upLoad(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return Result.empty();
        }
        long size = multipartFile.getSize();
        logger.info("图片大小:{}kB", size / 1024);
        if (size / 1024 > maxSize) {
            return Result.fail("请上传小于3M的图片");
        }
        String contentType = multipartFile.getContentType();
        if (!Arrays.asList(format).contains(contentType.toLowerCase())) {
            return Result.fail("请选择图片文件");
        }
        InputStream inputStream = null;
        byte[] file_buff = new byte[0];
        try {
            inputStream = multipartFile.getInputStream();
            int len = inputStream.available();
            file_buff = new byte[len];
            inputStream.read(file_buff);
        } finally {
            if (null != inputStream) {
                inputStream.close();
            }
        }
        String[] split = multipartFile.getOriginalFilename().split("\\.");
        FastDFSFile dfsFile = new FastDFSFile(split[0], file_buff, split[1]);
        String fileAbsolutePath = FileManager.upload(dfsFile);
        return Result.ok().setT(fileAbsolutePath);
    }
}