package com.cy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		int a[]={1,2,3};
		int b[]={1,2,3};
		System.out.println(a.equals(b));//false
		System.out.println(Arrays.toString(a).equals(Arrays.toString(b)));//true

		ObjectMapper objectMapper=new ObjectMapper();
		String s1=objectMapper.writeValueAsString(a);
		String s2=objectMapper.writeValueAsString(b);
		System.out.println(s1+"/"+s2);
		System.out.println(s1.equals(s2));//true


	}

}
