package com.manage.demoapp.utlis;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author peter  2018-12-12 11:06
 */
public class StringUtils {

    /**
     * null串转换为空串
     *
     * @param s
     * @return
     */
    public static String null2Empty(String s) {
        return s == null ? "" : s;
    }


    public static boolean isEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }


    /**
     * double 转换为字符串保留2为小数（四舍五入）
     * @param d
     * @return
     */
    public static String double2String(double d) {
        return new BigDecimal(d).setScale(2, RoundingMode.HALF_UP).toString();
    }


}
