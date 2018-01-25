/**
 * Weidai
 * Copyright (C), 2011 - 2018, 微贷网.
 */
package com.reus.tinyioc.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 常用工具类
 * @author reus
 * @version $Id: Utils.java, v 0.1 2018-01-25 reus Exp $
 */
public class Utils {

    /**
     * 计算汉诺塔
     * @param n
     * @param fromTower
     * @param toTower
     * @param auxTower
     * @return
     */
    public static int moveDisks(int n, char fromTower, char toTower, char auxTower) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            return 1;
        } else {
            int left = moveDisks(n - 1, fromTower, auxTower, toTower) + 1;
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            int right = moveDisks(n - 1, auxTower, toTower, fromTower);
            return left + right;
        }

    }

    /**
     * 将驼峰风格替换为下划线风格
     * @param str
     * @return
     */
    public static String camelhumpToUnderline(String str) {
        Matcher matcher = Pattern.compile("[A-Z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() + i, matcher.end() + i,
                "_" + matcher.group().toLowerCase());
        }
        if (builder.charAt(0) == '_') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    /**
     * 将下划线风格替换为驼峰风格
     * @param str
     * @return
     */
    public static String underlineToCamelhump(String str) {
        Matcher matcher = Pattern.compile("_[a-z]").matcher(str);
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; matcher.find(); i++) {
            builder.replace(matcher.start() - i, matcher.end() - i,
                matcher.group().substring(1).toUpperCase());
        }
        if (Character.isUpperCase(builder.charAt(0))) {
            builder.replace(0, 1, String.valueOf(Character.toLowerCase(builder.charAt(0))));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String name = "camelhumpToUnderline";
        name = camelhumpToUnderline(name);
        System.out.println(name);
        name = underlineToCamelhump(name);
        System.out.println(name);

    }

}