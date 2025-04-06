package com.ws.fjj.fuds.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileService {
    void upload(MultipartFile file);
}
