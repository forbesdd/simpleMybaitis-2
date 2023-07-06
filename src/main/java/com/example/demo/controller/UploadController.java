package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.pojo.Result;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
	
	@PostMapping
	public Result upload(String username,Integer age,MultipartFile image) throws IllegalStateException, IOException {
		log.info("ファイルアップロード:{},{},{}",username,age,image);
		
		String orignalFilename =image.getOriginalFilename();
		
		int index = orignalFilename.lastIndexOf(".");
        String extname = orignalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名: {}", newFileName);
		
		image.transferTo(new File("/Users/user/IT/image/" + newFileName));
		return Result.success();
		
	}
	
}
