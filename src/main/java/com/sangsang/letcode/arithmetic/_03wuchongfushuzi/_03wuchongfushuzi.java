package com.sangsang.letcode.arithmetic._03wuchongfushuzi;

import org.junit.Test;

import java.util.*;

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


    /**
     * 思路：利用set去重，判断和字符串长度是否相等
     *每次执行重复之后就将前面的指针向后移动一位
     */
    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //左索引
        int lIndex = 0;
        //最大长度
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            //有重复的左指针就一直++
            while (repetition(s.substring(lIndex, i + 1))) {
                lIndex++;
            }
            maxLength = Math.max(maxLength, (i - lIndex + 1));
        }
        return maxLength;
    }

    //用于判断是否重复的一个set
    private static Set<Character> set = new HashSet<>();

    /**
     * 判断当前字符串是否有重复的
     *
     * @author liutangqi
     * @date 2025/2/20 15:40
     * @Param [str]
     **/
    private boolean repetition(String str) {
        //清空
        set.clear();
        //利用set去重判断是否重复
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            set.add(chars[i]);
        }
        return set.size() != str.length();
    }

    @Test
    public void test1() {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println("abcdefg".substring(1,3));
    }
}
