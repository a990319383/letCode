package com.sangsang.letcode._03wuchongfushuzi;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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
     * 超时 0.0
     *
     * @param s
     * @return
     */
    public Object lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int maxLenth = 1;//存储最大的不重复字符长度
        for (int i = 1; i <= s.length(); i++) {
            String sNew = s.substring(0, i);
            int length = sNew.length();
            for (int j = 1; j <= length; j++) {
                String substr = sNew.substring(length - j);
                String[] split1 = substr.split("");
                HashSet set = new HashSet(Arrays.asList(split1));
                if (split1.length != set.size()) {//有重复的
                    continue;
                } else {
                    if (maxLenth < split1.length)
                        maxLenth = split1.length;
                }
            }

        }
        return maxLenth;
    }

    /**
     * 判断重复还是一样的思路
     * 之前是先一个字符开始判断重复，现在反过来直接判断整个字符串是不是重复的
     *
     * @param s
     * @return
     */
    public Object lengthOfLongestSubstring2(String s) {
        if (s.length() == 0)
            return 0;
        int maxLenth = 1;//存储最大的不重复字符长度
        for (int i = s.length(); i >= 1; i--) {
            String sNew = s.substring(0, i);
            int length = sNew.length();
            for (int j = length; j >= 1; j--) {
                String substr = sNew.substring(length - j);
                String[] split1 = substr.split("");
                HashSet set = new HashSet(Arrays.asList(split1));
                if (split1.length != set.size()) {//有重复的
                    return maxLenth;
                } else {
                    if (maxLenth < split1.length)
                        maxLenth = split1.length;
                }
            }

        }
        return maxLenth;
    }

    /**
     * 采用双指针
     *
     * @param s
     * @return
     */
    public Object lengthOfLongestSubstring3(String s) {
        if (s.length() == 0)
            return 0;
        int maxLength = 1;
        int length = s.length();
        //比较的字符长度
        for (int i = length; i >= 1; i--) {
            for (int j = 1; j <= (length - i) / 2 + 1; j++) {
                //正向切割
                String start = s.substring(j - 1, j + i - 1);
                String[] startSplit = start.split("");
                List<String> strings = Arrays.asList(startSplit);
                int startSize = Arrays.asList(startSplit).stream().distinct().collect(Collectors.toList()).size();
                if (startSplit.length == startSize) {//没有重复的
                    return startSize;
                }
                //反向切割
                String end = s.substring(length - j - i + 1, length - j + 1);
                if(!end.equals(start)){
                    String[] endSplit = end.split("");
                    int endSize  = Arrays.asList(endSplit).stream().distinct().collect(Collectors.toList()).size();
                    if (endSplit.length == endSize) {//没有重复的
                        return endSize;
                    }
                }
            }
        }
        return maxLength;
    }

    @Test
    public void _03wuchongfushuziTest() {
        Object qwertt = lengthOfLongestSubstring3("dvdf");
        System.out.println(qwertt);
    }

    @Test
    public void test() {
        Object result = lengthOfLongestSubstring2("aufad");
        System.out.println(result);
    }


    /**
     * 这个方法不符合这个题意，理解错题意了
     * 判断一个字符串是否有   连续重复的
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
