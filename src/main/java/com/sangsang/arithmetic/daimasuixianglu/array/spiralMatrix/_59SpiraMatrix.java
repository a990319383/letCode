package com.sangsang.arithmetic.daimasuixianglu.array.spiralMatrix;

import java.util.Arrays;

/**
 * @Author: liutangqi
 * @Date: 2022/3/2 17:15
 * 螺旋矩阵
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * <p>
 * ## 思路
 * 循环的边界条件要把控好
 * 逆时针旋转，边界条件的等于条件一定要全部相同
 */
public class _59SpiraMatrix {

    public static void main(String[] args) {
//        int[][] ints = new int[3][3];
//        ints[0][0] = 1;
//        ints[0][1] = 2;
//        ints[0][2] = 3;
//        ints[1][2] = 4;
//        ints[2][2] = 5;
//        ints[2][1] = 6;
//        ints[2][0] = 7;
//        ints[1][0] = 8;
//        ints[1][1] = 9;
        int[][] ints = getSpiraMatrix(3);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }


    /**
     * 获取对应阶数的螺旋矩阵
     *
     * @param order 阶数
     * @return
     */
    public static int[][] getSpiraMatrix(int order) {
        int[][] result = new int[order][order];

        int leftIndex = 0;//左索引
        int rightIndex = 0;//右索引
        int upBoundary = 0;//矩阵上面第几行
        int rightBoundary = order - 1;//矩阵右边的边界
        int belowBoundary = order - 1;//矩阵下边的边界
        int leftBooundary = 0;//矩阵左边的边界
        boolean nextTurn = false;//标识是否该转弯
        //循环次数就是阶数的平方
        for (int i = 1; i <= order * order; i++) {
            try {
                result[leftIndex][rightIndex] = i;
                if (rightIndex <= rightBoundary && !nextTurn) {
                    rightIndex++;
                    if (rightIndex == rightBoundary) {
                        nextTurn = true;
                    }
                }
                if (leftIndex == belowBoundary && nextTurn) {
                    leftIndex++;
                    nextTurn = false;
                }
            } catch (Exception e) {

            }
        }

        return result;
    }
}
