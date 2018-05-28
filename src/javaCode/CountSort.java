package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/25 10:49
 */
public class CountSort {
    static void countSort(int[] array){
        int[] C = new int[10];
        int[] B = new int[array.length];
        for(int i=0;i<array.length;i++){
            C[array[i]]++;
        }
        System.out.println("出现次数 "+Arrays.toString(C));
        for(int i=1;i<C.length;i++){
            C[i]+=C[i-1];
        }
        System.out.println("确定位置 "+Arrays.toString(C));
        // 倒序遍历的目的：为了保证排序的稳定性，相同的元素对应C中的同一个元素，当每一次放入A中（从后往前遍历）的一个元素到B中后C中对应元素减一，这就会使先在A中出现的排在后面
        for(int i=array.length-1;i>=0;i--){
            B[C[array[i]]-1] = array[i];
            C[array[i]]--;
        }
        System.out.println("放入B中 "+Arrays.toString(B));
        for(int i=0;i<array.length;i++){
            array[i] = B[i];
        }
    }

    public static void main(String[] args){
        int[] array = {4,1,3,4,3};
        System.out.println(Arrays.toString(array));
        countSort(array);
        System.out.println(Arrays.toString(array));
    }
}

