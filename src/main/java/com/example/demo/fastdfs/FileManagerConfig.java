package com.example.demo.fastdfs;

import java.io.Serializable;

public interface FileManagerConfig extends Serializable {

    String FILE_DEFAULT_WIDTH = "120";
    String FILE_DEFAULT_HEIGHT = "120";
    String FILE_DEFAULT_AUTHOR = "root";
    String SEPARATOR = "/";
    String CLIENT_CONFIG_FILE = "fdfs_client.conf";
}