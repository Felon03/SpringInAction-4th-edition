package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-21 21:01
 * Description: 使用@ControllerAdvice， 为所有的控制器处理异常
 */

// 定义控制器类
@ControllerAdvice
public class AppWideExceptionHandler {

    // 定义异常处理方法
    @ExceptionHandler(DuplicateSpittleException.class)
    public String duplicateSpittleHandler() {
        return "error/duplicate";
    }
}
