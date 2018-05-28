package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/22 17:37
 */
public class SelectionSort {
    void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void SelectionMaxSort(int[] array){
        int sum = 0;
        for(int i = 0;i<array.length;i++){
            int maxIndex = 0;
            for(int j = 1;j < array.length - i;j++){

                if(array[maxIndex] < array[j]){
                    maxIndex = j;
                }

                sum++;
            }
//            int max = array.length-1-i;
//            System.out.println("此时最大值应放的位置： " + max);
            swap(array,maxIndex,array.length-1-i);
        }
        System.out.println("选择排序(max)执行次数是: " + sum);
    }

    void SelectionMinSort(int[] array){
        int sum = 0;
        for(int i = 0;i < array.length;i++){
            int minIndex = i;
            for(int j = i+1;j < array.length;j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
                sum++;
            }
            swap(array,minIndex,i);
        }
        System.out.println("选择排序(min)执行次数是: " + sum);
    }

    public static void main(String[] args){
        int[] array = {8,5,2,6,9,3,1,4,0,7};
        System.out.println(Arrays.toString(array));
        SelectionSort ss = new SelectionSort();
        ss.SelectionMinSort(array);
        System.out.println(Arrays.toString(array));
    }
}
