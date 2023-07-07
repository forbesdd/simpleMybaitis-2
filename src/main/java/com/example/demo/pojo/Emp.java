package com.example.demo.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 従業員管理
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id; //ID
    private String username; //ニックネーム
    private String password; //パスワード
    private String name; //名前
    private Short gender; //性別 , 1 男, 2 女
    private String image; //図url
    private Short job; //職位
    private LocalDate entrydate; //入職日
    private Integer deptId; //部門ID
    private LocalDateTime createTime; //作成時間
    private LocalDateTime updateTime; //修正時間
}
