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

    private static final String logExceptionFormat = "Capture Exception By GlobalExceptionHandler: Code: {} Detail: {}";


    @ExceptionHandler(RuntimeException.class)
    public ResultVO runtimeExceptionHandler(RuntimeException ex) {
        log.error("运行时异常");

        return exceptionFormat(1, ex);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResultVO nullPointerExceptionHandler(NullPointerException ex) {
        log.error("空指针异常");
        return exceptionFormat(2, ex);
    }

    @ExceptionHandler(ClassCastException.class)
    public ResultVO classCastExceptionHandler(ClassCastException ex) {
        log.error("类型转换异常");

        return exceptionFormat(3, ex);
    }

    @ExceptionHandler(IOException.class)
    public ResultVO iOExceptionHandler(IOException ex) {
        log.error("IO异常");

        return exceptionFormat(4, ex);
    }

    @ExceptionHandler(NoSuchMethodException.class)
    public ResultVO noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        log.error("未知方法异常");

        return exceptionFormat(5, ex);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResultVO indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        log.error("数组越界异常");

        return exceptionFormat(6, ex);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResultVO requestNotReadable(HttpMessageNotReadableException ex) {
        log.error("400错误");

        return exceptionFormat(7, ex);
    }

    @ExceptionHandler({TypeMismatchException.class})
    public ResultVO requestTypeMismatch(TypeMismatchException ex) {
        log.error("400错误");

        return exceptionFormat(8, ex);
    }

    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResultVO requestMissingServletRequest(MissingServletRequestParameterException ex) {
        log.error("400错误");

        return exceptionFormat(9, ex);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResultVO request405(HttpRequestMethodNotSupportedException ex) {
        log.error("405错误");

        return exceptionFormat(10, ex);
    }

    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ResultVO request406(HttpMediaTypeNotAcceptableException ex) {
        log.error("406错误");

        return exceptionFormat(11, ex);
    }

    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResultVO server500(RuntimeException ex) {
        log.error("500错误");

        return exceptionFormat(12, ex);
    }

    @ExceptionHandler({StackOverflowError.class})
    public ResultVO requestStackOverflow(StackOverflowError ex) {
        log.error("栈溢出");

        return exceptionFormat(13, ex);
    }

    @ExceptionHandler({Exception.class})
    public ResultVO exception(Exception ex) {
        log.error("其他错误");

        return exceptionFormat(14, ex);
    }

    //自定义异常捕获
    @ExceptionHandler({YooException.class})
    public ResultVO yooException(YooException ex) {
        return exceptionFormat(999, ex);
    }

    private <T extends Throwable> ResultVO exceptionFormat(Integer code, T ex) {
        log.error(logExceptionFormat, code, ex);

        return ResultVOUtil.error(code, ex.getMessage());
    }
}
