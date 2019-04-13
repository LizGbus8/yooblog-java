package com.rc.yooblog.common.utils;

import com.rc.yooblog.common.vo.ResultVO;

/**
 * 作者：flandre on 2018/7/22 16:57
 * 描述：
 */
public class ResultVOUtil {

    /**
     * 描述: 成功
     *
     * @return
     * @Param
     */
    public static ResultVO success(Object data) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    /**
     * 描述: 成功（没有data）
     * @Param
     * @return
     */
    public static ResultVO success() {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
    /**
     * 描述:
     * @Param
     * @return
     */
    public static ResultVO error(Integer code) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg("失败");
        return resultVO;
    }

    /**
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code,String msg) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
