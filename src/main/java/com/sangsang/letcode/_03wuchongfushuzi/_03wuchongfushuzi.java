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
        if(s.length()<2)
            return 1;
        int maxLength = 1;//存储最大不重复长度
        for (int i = 1; i <s.length() ; i++) {
            String str = s.substring(0,i);
            boolean b = test1(str);
            if(b){
                maxLength = str.length();
            }
        }
        return maxLength;
    }

    @Test
    public void test() {
        Object result = lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }

    /**
     * 判断一个字符串是否有重复的
     * true 为不重复
     */
    public boolean test1(String str) {
        if(str.length()==1)
            return false;
        int length = str.length();
        for (int i = 1; i <= length / 2; i++) {
            String str1 = str.substring(length - i);
            String str2 = str.substring(length/2 - i,length );
            if(str1.equals(str2)){
                return false;
            }
        }
        return true;
    }

}
