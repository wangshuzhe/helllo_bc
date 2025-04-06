package com.ws.fjj.fuds.controller;

import com.ws.fjj.fuds.service.FileService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileController {

    @Resource
    private FileService service;
    @PostMapping("/file")
    public void uploadFile(@RequestParam("file1")MultipartFile file) {
        if (file.isEmpty()) {
            return;
        }
        service.upload(file);
    }
}
