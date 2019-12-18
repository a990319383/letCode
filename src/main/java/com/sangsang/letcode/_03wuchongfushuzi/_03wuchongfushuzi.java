package com.sangsang.letcode._03wuchongfushuzi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _03wuchongfushuzi {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * 示例 1:
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public Object lengthOfLongestSubstring(String s) {
        if (s.length() < 2)
            return 1;
        int maxLength = 1;//存储最大不重复长度
        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(0, i);
            int b = 0;
            if (str.length() == 1)
                b = 0;
            int length = str.length();
            for (int j = 1; j <= length / 2; j++) {
                String str1 = str.substring(length - j);
                String str2 = str.substring(length - str1.length() - j, length - j);
                if (str1.equals(str2)) {
                    return str1.length();
                }
            }
            b = 0;
            if (b == 0) {
                maxLength = str.length();
            } else {
                return b;
            }
        }
        return maxLength;
    }

    @Test
    public void test() {
        Object result = lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }

    /**
     * 判断一个字符串是否有重复的
     * true 为不重复
     */
    public int test1(String str) {
        if (str.length() == 1)
            return 0;
        int length = str.length();
        for (int i = 1; i <= length / 2; i++) {
            String str1 = str.substring(length - i);
            String str2 = str.substring(length - str1.length() - i, length - i);
            if (str1.equals(str2)) {
                return str1.length();
            }
        }
        return 0;
    }

}