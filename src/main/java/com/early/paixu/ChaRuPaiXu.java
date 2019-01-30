package com.early.paixu;

import org.junit.Test;

public class ChaRuPaiXu {

    @Test
    public void test(){
        int[] a = {3,9,6};
        insertionSort(a);

    }


    public void insertionSort(int[] a){
        int insertIndex,insertElement;// 需要插入的索引   需要插入的元素
        for(int i = 1; i < a.length; i++){ //外层循环
            insertIndex = i - 1; //插入的位置，默认有序数列的第一个元素的位置
            insertElement = a[i]; //新插入的元素，默认外层循环的元素
            while(insertIndex >= 0 && a[insertIndex] > insertElement){ //内层循环，只要新元素比待插入位置的元素小就继续，时间复杂度N
                a[insertIndex + 1] = a[insertIndex]; //比待插入元素大的元素后移一位
                insertIndex--; //插入位置前移一位
            }
            a[insertIndex + 1] = insertElement; //内层循环结束，把新元素放到插入位置后面
        }
        System.out.println(a[0]+"---"+a[1]+"-----"+a[2]);
    }




}
