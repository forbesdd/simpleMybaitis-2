package com.example.demo.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部門管理
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id; //ID
    private String name; //部門名
    private LocalDateTime createTime; //作成時間
    private LocalDateTime updateTime; //修正時間
}
