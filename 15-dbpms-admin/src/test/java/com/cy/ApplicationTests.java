package com.cy;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

import java.util.Base64;
import java.util.UUID;

@SpringBootTest
class ApplicationTests {
	@Test
	void testBase64(){
		//加密
		Base64.Encoder encoder=Base64.getEncoder();//加密对象
		byte[] array=encoder.encode("123456".getBytes());
		String pwd=new String(array);
		System.out.println(pwd);

		//解密
		Base64.Decoder decoder=Base64.getDecoder();//解密对象
		array=decoder.decode(array);
		System.out.println(new String(array));

	}
	@Test
	void testMd502() {
		String pwd="123456";
		String salt= UUID.randomUUID().toString();//随机字符串
		SimpleHash sh= new SimpleHash("MD5",pwd,salt,10);
        String hashedPwd=sh.toHex();
		System.out.println("hashedPwd="+hashedPwd);
	}

	@Test
	void testMd501() {
		String pwd="123456";
		String hashedPwd=
				DigestUtils.md5DigestAsHex(pwd.getBytes());
		System.out.println(hashedPwd);//e10adc3949ba59abbe56e057f20f883e
		                              //e10adc3949ba59abbe56e057f20f883e
		String salt= UUID.randomUUID().toString();//随机字符串
		System.out.println("salt="+salt);
		hashedPwd=
		   DigestUtils.md5DigestAsHex((pwd+salt).getBytes());
		System.out.println(hashedPwd);
	}

}
