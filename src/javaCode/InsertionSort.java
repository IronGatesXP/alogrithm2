package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/22 19:54
 */
public class InsertionSort {
    void insertionSort(int[] array){
        int sum = 0;
        for(int i = 1;i < array.length;i++){
            int get = array[i]; // 从已经排好序的数的右方去一个数来进行比较，默认第一个元素已经排好序，故从i=1开始取
            int j = i - 1;      // j+1代表了需要和get进行比较的左边数据的个数
            // while里找出比get小的元素的index，get就应该插在j+1处，同时要将数组元素往右移，不需要用交换swap，这时会有两个相同的元素，用get去覆盖最左边那个
            while(j>=0 && array[j] > get){
                array[j+1] = array[j];
                j--;
                sum++;
            }
            array[j+1] = get;
        }
        System.out.println("插入排序执行次数是: " + (sum + array.length-1));
    }

    public static void main(String[] args){
        int[] array = {6,5,3,1,8,7,2,4};
        System.out.println(Arrays.toString(array));
        InsertionSort is = new InsertionSort();
        is.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
