package com.early.paixu;

import org.junit.Test;

import java.util.Arrays;

public class ChaRuPaiXu {

    @Test
    public void test(){
        int[] a = {3,9,6,80,89,99,97,65,54,9,69,21,39,1,23,71};
//        insertionSort(a);

        selectionSort(a);

    }

    public void selectionSort(int[] a){
        int minIndex;
        int temp;
        for(int i = 0; i < a.length - 1; i++){ //外层循环，从无序区第一个元素开始到数组倒数第二个元素，时间复杂度N
            minIndex = i; //每次外层循环假设无序区第一个元素是最小元素
            for(int j = i + 1; j < a.length; j++){	//内层循环，从假设的最小元素的后一个位置开始，到数组最后一个元素，时间复杂度N
                if(a[j] < minIndex){ //判断内层循环的元素是否小于假设的最小元素
                    minIndex = j; //如果比最小元素小，标记该元素的位置为新的最小元素的位置，内层循环完毕，会找出无序区的最小值
                }
            }
            temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;	//无序区真正最小值和第一个元素交换位置，下一次循环无序区从下一个值开始
        }
        System.out.println(Arrays.toString(a));
    }






    public void insertionSort(int[] a){
        int insertIndex; // 需要插入的索引
        int insertElement;//   需要插入的元素

        for(int i = 1; i < a.length; i++){ //外层循环
            insertIndex = i - 1; //插入的位置，默认有序数列的第一个元素的位置
            insertElement = a[i]; //新插入的元素，默认外层循环的元素

            while(insertIndex >= 0 && a[insertIndex] > insertElement){ //内层循环，a[insertIndex] > insertElement 只要新元素比待插入位置的元素小就继续向前
                a[insertIndex + 1] = a[insertIndex]; //比待插入的新元素大的元素后移一位
                insertIndex--; //插入位置前移一位
            }
            a[insertIndex + 1] = insertElement; //内层循环结束，把新元素放到插入位置后面
        }

    }




}
