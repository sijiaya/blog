package com.soft1841.web.blog.util;

/**

/**
 * @ClassName StringUtil
 * @Description 字符串验证工具类
 * @Author sj_yao
 * @Date 2019/12/4
 **/
public class StringUtil {
    public static boolean isEmpty(String str){
        if ("".equals(str) || str==null){
            return true;
        }else {
            return false;
        }
    }
    public static boolean isNotEmpty(String str){
        if (!"".equals(str) && str!=null){
            return true;
        }else {
            return false;
        }
    }
}
