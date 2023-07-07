package com.cy.pj.common.web;


import com.cy.pj.common.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice //此注解描述的类为全局异常处理类
//@ResponseBody

@RestControllerAdvice //==@ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({ArrayIndexOutOfBoundsException.class})
    public String doHandleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException e){
        return "数组下标越界";
    }
    @ExceptionHandler({ArithmeticException.class})
    public String doHandleArithmeticException(ArithmeticException e){
        return "the exception msg is "+e.getMessage();
    }

    @ExceptionHandler({ServiceException.class})
    public String doHandleServiceException(ServiceException e){
        return "the exception msg is "+e.getMessage();
    }

    @ExceptionHandler({RuntimeException.class})
    public String doHandleRuntimeException(RuntimeException e){
        e.printStackTrace();
        //log.error(...);
        return "runtime exception "+e.getMessage();
    }

    @ExceptionHandler({Throwable.class})
    public String doHandleThrowable(Throwable e){//此方法为异常处理的兜底方法
        e.printStackTrace();
        //log.error(...);
        //给运维人员发短信
        //发运维人员发email
        //播放一段音乐(报警)
        return "系统维护中";
    }
    //
    //....
}
