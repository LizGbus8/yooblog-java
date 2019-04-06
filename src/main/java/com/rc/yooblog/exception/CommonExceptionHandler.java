package com.rc.yooblog.exception;

import com.rc.yooblog.common.utils.ResultVOUtil;
import com.rc.yooblog.common.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 作者：flandre on 2019/4/6 17:03
 * 描述：统一异常处理
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class CommonExceptionHandler {

//    /**
//     * 400 - Bad Request
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(Exception.class)
//    public ResultVO handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
//        return ResultVOUtil.error();
//    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        log.info("异常信息：{}", e);
        return ResultVOUtil.error();
    }
}