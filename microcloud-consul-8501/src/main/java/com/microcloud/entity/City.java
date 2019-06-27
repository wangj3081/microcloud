package com.microcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: wangjian
 */
@Data // 免写 Get、Set、toString 方法
public class City implements Serializable {

    private String city;

    private String provinces;
}
