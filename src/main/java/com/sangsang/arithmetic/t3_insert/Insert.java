package com.sangsang.arithmetic.t3_insert;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;

//插入排序
public class Insert {
    public static int[] insert(int[] nums) {
        for (int i = 0; i <nums.length-1 ; i++) {
            int prepare = nums[i+1];//准备要插入的数据
            //i+1前面的数据都是有序区
            for (int j = i+1; j >0; j--) {
                if(nums[j]<nums[i+1]){
                    int tem = nums[i+1];
                    nums[i+1] = nums[j];
                    nums[j] = tem;
                }
            }
        }
        return nums;
    }
}
