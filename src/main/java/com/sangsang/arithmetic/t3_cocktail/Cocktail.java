package com.sangsang.arithmetic.t3_cocktail;

import java.util.Arrays;

//冒泡排序的升级版，鸡尾酒排序，适用于大部分数据是有序的
public class Cocktail {
    public static int[] cocktail(int[] nums) {
        int count = 0;//记录循环的次数
        int temp;
        boolean isOk = true;//是否是有序的标志，有序后直接跳出循环
        int boardL=nums.length-1;//正向比较的边界
        int boardR=0;//反向比较的边界
        int lastBoardL = 0;//正向最后一次数据交换的位置
        int lastBoardR = 0;//反向最后一次数据交换的位置
        for (int i = 0; i < nums.length / 2; i++) {
            //正向比较
            for (int j = boardR; j < boardL-i; j++) {
                count++;//记录比较次数
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isOk = false;//交换了数据就判定为不是有序的
                    lastBoardL = j;//修改数据交换的位置
                }
            }
            boardL = lastBoardL;
            if(isOk){//有序了直接返回
                break;
            }
            isOk = true;//反向比较的时候恢复默认值
            //反向比较
            for (int j = boardL; j >boardR+i; j--) {
                count++;//记录比较次数
                if(nums[j-1]>nums[j]){
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    isOk = false;//交换了数据就判定为不是有序的
                    lastBoardR = j;//修改数据交换的位置
                }
            }
            boardR = lastBoardR;
            if(isOk){
                break;
            }
        }
        System.out.println(count);
        return nums;
    }

    public static void main(String[] args) {
        int[] ints =  {2, 3, 4, 5, 6, 7, 8, 1};
        int[] ints2 = {6, 1, 9, 8, 10, 12, 13};
        System.out.println(Arrays.toString(cocktail(ints)));
    }
}
