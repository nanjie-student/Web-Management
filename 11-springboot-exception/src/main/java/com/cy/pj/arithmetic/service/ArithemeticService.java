package com.cy.pj.arithmetic.service;

import com.cy.pj.common.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class ArithemeticService {

     public int sum(Integer... nums){//可变参数可以看成是一个特殊的数组
         if(nums==null||nums.length==0)
             //throw new RuntimeException("参数值不能为负数");
             throw new ServiceException("数组不能为空");//自定义异常
         int sum=0;
         for(int i=0;i<=nums.length;i++){
             sum+=nums[i];
         }
         return sum;
     }
}
