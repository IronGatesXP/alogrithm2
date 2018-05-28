package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/23 14:20
 */
public class MergeSort {
    public  int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        System.out.println("low is " + low);
        System.out.println("mid is " + mid);
        System.out.println("high is " + high);
        // 这里的判断条件就是为了让
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
            System.out.println(Arrays.toString(a));
        }else{
            System.out.println("结束判断");
        }
        return a;
    }

    public  void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

    public static void main(String[] args){
        int[] array = {6,5,3,1,7,2,4};
        System.out.println(Arrays.toString(array));
        MergeSort ms = new MergeSort();
        array = ms.sort(array,0,6);
        System.out.println(Arrays.toString(array));
    }
}
