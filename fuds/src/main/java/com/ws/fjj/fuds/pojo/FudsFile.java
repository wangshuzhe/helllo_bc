package com.ws.fjj.fuds.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FudsFile {
    private String id;
    private String name;
    private String path;
    private Date uploadTime;
}
