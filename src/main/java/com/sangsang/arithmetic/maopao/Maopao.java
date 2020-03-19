package com.sangsang.arithmetic.maopao;

import java.util.Arrays;

public class Maopao {
    //普通的冒泡排序
    public static Integer[]  normal(Integer[] nums){
        int temp ;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <nums.length-i-1 ; j++) {
                if (nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    //优化后的冒泡排序，在第二层循环中添加一个标识，如果这一轮都没有发生数据交换，说明已经是有序的了，直接跳出循环
    public static  Integer[] optimized(Integer[] nums){
        int temp ;
        for (int i = 0; i <nums.length ; i++) {
            boolean isOk=true;//判断是否是有序的标识
            for (int j = 0; j <nums.length-1-i ; j++) {
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isOk = false;//如果发生了数据交换说明现在的数组还是无序的
                }
            }
            //第一层循环中判断是否有序，有序了直接退出
            if(isOk){
                break;
            }
        }
        return nums;
    }


    //优化后内层比较边界
    public static  Integer[] optimized2(Integer[] nums){
        int temp ;
        int board = nums.length-1 ;
        int lastBoard=0;//记录最后一次交换的位置
        for (int i = 0; i <nums.length ; i++) {
            boolean isOk=true;//判断是否是有序的标识
            for (int j = 0; j <board ; j++) {
                int border = 0;
                if(nums[j]>nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isOk = false;//如果发生了数据交换说明现在的数组还是无序的
                    lastBoard = j;//移动有序的边界
                }
            }
            //上一次最后一次交换的位置作为下一次的边界，注意这里是两个变量
            board = lastBoard;
            //第一层循环中判断是否有序，有序了直接退出
            if(isOk){
                break;
            }
        }
        return nums;
    }



    public static void main(String[] args) {
        Integer[] integers = {2, 4, 3, 7, 5, 9, 12, 43, 1,56,57,59};
//        System.out.println(Arrays.toString(normal(integers)));
        System.out.println(Arrays.toString(optimized2(integers)));
    }
}
