package com.early.paixu;

import org.junit.Test;

import java.util.Arrays;

public class PaiXu {

    int[] a = {3,9,6,80,89,99,97,65,54,9,69,21,39,1,23,71};


    /**
     * 希尔排序（Wiki官方版）
     *
     * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；（注意此算法的gap取值）
     * 2. 按增量序列个数k，对序列进行k 趟排序；
     * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     *             时间复杂度O(nlog2 n)
     */
    public static void shell_sort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1;      // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }

    @Test
    public void shell_sortTest(){
        shell_sort(a);
    }






    /**
     * 插入排序
     *
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置后
     * 6. 重复步骤2~5
     * @param arr  待排序数组
     *  时间复杂度是O(n^2)
     *             由于每次只移动一个元素的位，并不会改变值相同的元素之间的排序，因此它是一种稳定排序
     */
    public static void insertionSort(int[] arr){
        for( int i=0; i<arr.length-1; i++ ) {
            for( int j=i+1; j>0; j-- ) {
                if( arr[j-1] <= arr[j] )
                    break;
                int temp = arr[j];      //交换操作
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }

    @Test
    public void insertionSortTest(){
        insertionSort(a);
    }







    /**
     * 选择排序
     *
     * 1. 从待排序序列中，找到关键字最小的元素；
     * 2. 如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换；
     * 3. 从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     *    仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     * @param arr  待排序数组
     *   * 简单选择排序（先比较个遍选出最小值再交换）
     *  * 时间复杂度最好最坏都是不变的   O(n^2)
     *  * 无论何种情况哪怕数组已经排序完成还是要花费将近n^2/2次遍历来确认一遍
     *  * 即便是这样它的排序结果也是不稳定的  唯一值得高兴的是它并不消耗额外的内存空间
     */
    public static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = i;
            for(int j = i+1; j < arr.length; j++){    //选出之后待排序中值最小的位置
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[min];      //交换操作
                arr[min] = arr[i];
                arr[i] = temp;
                System.out.println("Sorting:  " + Arrays.toString(arr));
            }
        }
    }
    @Test
    public void selectionSortTest(){
        selectionSort(a);
    }




    /**
     * 冒泡排序
     *
     * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * ③. 针对所有的元素重复以上的步骤，除了最后一个。
     * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     *
     * 添加标识flag是为了避免原来数组都是有序的还要遍历比较
     *
     *  * （两两比较符合条件就交换）
     *  * 冒泡排序相对于代码而言就是两个循环嵌套
     *  *
     *  * 平均时间复杂度  O(n^2)
     *  *  最坏情况O(n^2)
     *  *  最好情况O(n)
     *  *
     *  *  由于冒泡排序只在相邻元素大小不符合要求时才调换他们的位置  所以它并不改变相同元素之间的相对顺序  所以是稳定的排序算法
     *
     */
    public static void bubbleSort(int[] arr){
        boolean flag = true;
        for (int i = arr.length - 1; i > 0 && flag; i--) {//外层循环移动游标
            flag = false;
            for(int j = 0; j < i; j++){    //内层循环遍历游标及之后(或之前)的元素
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                    System.out.println("Sorting: " + Arrays.toString(arr));
                }
            }
        }
    }

    @Test
    public void bubbleSortTest(){
        bubbleSort(a);
    }
}
