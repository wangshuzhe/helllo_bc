package com.ws.fjj.fuds.dao;


import com.ws.fjj.fuds.pojo.FudsFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Mapper
public interface FudsFileDao {
    void saveFudsFile(@Param("file")FudsFile fudsFile);
}
