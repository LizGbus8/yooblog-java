package com.rc.yooblog.exception;

/**
 * 作者：flandre on 2019/4/10 13:09
 * 描述：
 */

import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 异常处理拦截器
 * @author hll
 * @date 2018年5月25日
 */
@CrossOrigin
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";


    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResultVO runtimeExceptionHandler(RuntimeException ex) {
        return exceptionFormat(1, ex);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public ResultVO nullPointerExceptionHandler(NullPointerException ex) {
        return exceptionFormat(2, ex);
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public ResultVO classCastExceptionHandler(ClassCastException ex) {
        return exceptionFormat(3, ex);
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public ResultVO iOExceptionHandler(IOException ex) {
        return exceptionFormat(4, ex);
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public ResultVO noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return exceptionFormat(5, ex);
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResultVO indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return exceptionFormat(6, ex);
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResultVO requestNotReadable(HttpMessageNotReadableException ex) {
        System.out.println("400..requestNotReadable");
        return exceptionFormat(7, ex);
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public ResultVO requestTypeMismatch(TypeMismatchException ex) {
        System.out.println("400..TypeMismatchException");
        return exceptionFormat(8, ex);
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResultVO requestMissingServletRequest(MissingServletRequestParameterException ex) {
        System.out.println("400..MissingServletRequest");
        return exceptionFormat(9, ex);
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResultVO request405(HttpRequestMethodNotSupportedException ex) {
        return exceptionFormat(10, ex);
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ResultVO request406(HttpMediaTypeNotAcceptableException ex) {
        System.out.println("406...");
        return exceptionFormat(11, ex);
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResultVO server500(RuntimeException ex) {
        System.out.println("500...");
        return exceptionFormat(12, ex);
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public ResultVO requestStackOverflow(StackOverflowError ex) {
        return exceptionFormat(13, ex);
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public ResultVO exception(Exception ex) {
        return exceptionFormat(14, ex);
    }

//    //自定义异常捕获
//    @ExceptionHandler({MyException.class})
//    public String myException(MyException ex) {
//        System.out.println("1111111111111111111");
//        return exceptionFormat(999, ex);
//    }

    private <T extends Throwable> ResultVO exceptionFormat(Integer code, T ex) {
        ex.printStackTrace();
        return ResultVOUtil.error();
    }
}
