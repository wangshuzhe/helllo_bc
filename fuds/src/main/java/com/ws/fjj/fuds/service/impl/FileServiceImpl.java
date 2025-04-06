package com.ws.fjj.fuds.service.impl;

import com.ws.fjj.fuds.dao.FudsFileDao;
import com.ws.fjj.fuds.pojo.FudsFile;
import com.ws.fjj.fuds.service.FileService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Resource
    FudsFileDao fudsFileDao;
    @Override
    public void upload(MultipartFile file) {
        //记录文件上传信息
        String pathStr = "/Users/wangshuzhe/Downloads/upload/";
        String fileName = file.getOriginalFilename();
        FudsFile fudsFile = new FudsFile();
        fudsFile.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        fudsFile.setName(fileName);
        fudsFile.setPath(pathStr);
        fudsFile.setUploadTime(new Date());
        saveFileInfo(fudsFile);
        //文件上传
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
            byte [] bytes = file.getBytes();
            uploadFile(bytes, fudsFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveFileInfo(FudsFile fudsFile) {
        fudsFileDao.saveFudsFile(fudsFile);
    }
    private void uploadFile(byte [] bytes, FudsFile fudsFile) throws IOException {
        //创建文件夹
        Files.createDirectories(Paths.get(fudsFile.getPath()));
        //写入文件
        Files.write(Paths.get(fudsFile.getPath() + fudsFile.getName()), bytes);
    }
}
