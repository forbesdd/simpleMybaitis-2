package com.example.demo.controller;

import com.example.demo.pojo.Emp;
import com.example.demo.pojo.Result;
import com.example.demo.service.EmpService;
import com.example.demo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
//ログイン管理Cotroller
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("ログイン{}", emp);
        Emp e = empService.login(emp);
        //登録成功後jwt生成
        if (e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims); //jwt登録した従業員の情報が含めている
            return Result.success(jwt);
        }

//        登录失败, 返回错误信息
<<<<<<< HEAD
        return Result.error("IDとPASSWORDが間違いました！");
       // return e != null ? Result.success() : Result.error("えらです");
=======
        return Result.error("用户名或密码错误");
       // return e != null ? Result.success() : Result.error("エラーです");
>>>>>>> master


    }

}
