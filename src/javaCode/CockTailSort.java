package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/22 17:00
 */

/**
 * 鸡尾酒排序，也叫定向排序，是冒泡排序的改进，在一轮从低到高的比较后，再执行从高到低的执行
 */

public class CockTailSort {
    void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    void sort(int[] array){
        int sum = 0;
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            for(int i = left;i < right;i++){
                if(array[i] > array[i+1]){
                    swap(array,i,i+1);
                }
            }
            right--;
            for(int i = right;i>left;i--){
                if(array[i] < array[i-1]){
                    swap(array,i,i-1);
                }
            }
            left++;
            sum++;
        }
        System.out.println("排序比较的总次数是: " + sum);
    }

    public static void main(String[] args){
        int[] array = {2,3,5,1,4,6};
        System.out.println(Arrays.toString(array));
        CockTailSort cs = new CockTailSort();
        cs.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
