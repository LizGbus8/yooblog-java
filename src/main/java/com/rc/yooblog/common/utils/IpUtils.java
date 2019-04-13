package com.rc.yooblog.common.utils;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

/**
 * 作者：flandre on 2019/4/9 11:06
 * 描述：获取真实IP，由Ip获取地址
 */
@Slf4j
public class IpUtils {

    /**
     * 地址库
     */
    private static String ADDRESS_API = "http://freeapi.ipip.net/";

    /**
     * 获取远程IP
     *
     * @param request 客户端请求
     * @return
     */
    public static String getRemoteIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 根据IP获取城市
     *
     * @param ip
     * @return
     */
    public static String getCity(String ip) {
        try {
            String result = HttpClientUtil.get(HttpConfig.custom().url(ADDRESS_API + ip).timeout(2000));
            String city = JSONObject.parseArray(result).get(2).toString();
            if (city.length() <= 0) {
                city =  "C-53行星";
            }
            return city;
        } catch (Exception e) {
            log.error("地址获取异常：{}", e);
            return "C-53行星";
        }
    }

}
