package com.example.demo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SimpleMybits2ApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void testGenJwt(){
		Map<String, Object> claims = new HashMap<>();
		claims.put("id",1);
		claims.put("name","tom");

		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, "itheima")//签名算法
				.setClaims(claims) //自定义内容(载荷)
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置有效期为1h
				.compact();
		System.out.println(jwt);
	}

	}





