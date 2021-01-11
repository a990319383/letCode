package com.sangsang.arithmetic.sort.t3_select;

import java.util.Arrays;

//选择排序
public class Select {
    //每次选出最小的，把最小的放到最左边，第二轮就选出其它的最小的，放在左边第二个
    //类比与冒泡，数据交换次数会降低
    public static Integer[] select(Integer[] nums) {
        for (int i = 0; i <nums.length-1 ; i++) {
            int minIndex = i;//存放最小的数的索引
            for (int j = i; j <nums.length-1 ; j++) {
                //选出未排序好的最小的数
                minIndex = nums[minIndex]>nums[j] ? j : minIndex;
            }
            //将每一轮最小的数进行交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Integer[] integers = {2, 4, 3, 7, 5, 9, 12, 43, 1,56,57,59};
        System.out.println(Arrays.toString(select(integers)));
    }
}
