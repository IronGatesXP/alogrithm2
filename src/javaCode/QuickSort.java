package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/24 21:15
 */

/*
快排算法：如果要将一个数组按从小到大的顺序排列，一般选取第一个元素作为key，首先j=len-1,即数组的最右边开始寻找小于key的元素（要把index=j这个元素也考虑进去，这里一定要从右向左先寻
找，找到了再执行从左往右找的命令，但如果是将数组最后一个元素作为key，那么就应该先执行从左往右寻找的命令），如果找到则让j等于它的index，然后再从左往右寻找
大于key的值，如果找到了则让i等于它的index，如果此时i<j（即停止寻找的条件是i=j），交换i和j代表的元素，然后继续执行以上步骤，直到i=j，这时交换array[i]与key的
值，并在key的左边和右边执行以上操作，即将数组划分为了两个新数组，对这两个新数组重复执行以上操作。
 */
public class QuickSort {
//    public static void main(String[] args) {
//        int[] a = {1, 2, 4, 5, 7, 4, 5 ,3 ,9 ,0};
//        System.out.println(Arrays.toString(a));
//        //quickSort(a);
//        quickSort(a,0,a.length-1);
//        System.out.println(Arrays.toString(a));
//    }
//
//    public static void quickSort(int[] a) {
//        if(a.length>0) {
//            quickSort(a, 0 , a.length-1);
//        }
//    }
//
//    private static void quickSort(int[] a, int low, int high) {
//        //1,找到递归算法的出口，很重要，迭代如果没有终止条件，那么就会导致异常，这里的迭代会执行到直到key的左边右边只有一个值，即low=high
//        if( low >= high) {
//            return;
//        }
//        //2, 存
//        int i = low;
//        int j = high;
//        //3,key
//        int key = a[ low ];
//        //4，完成一趟排序
//        while( i< j) {
//            //4.1 ，从右往左找到第一个小于key的数，如果a[j]>key才j--,如果小于则执行下一步，因为我们要找的是小于key的元素
//            while(i<j && a[j] > key){
//                j--;
//            }
//            // 4.2 从左往右找到第一个大于key的数,这里的=号很重要，因为如果没有等号，那这里的i++永远执行不了，因为首次判断时a[i]恒等于key，程序会卡在这儿
              // 即a[low]也就是首次判断的a[i]不应该参与a[i]<key的判断
//            while( i<j && a[i] <= key) {
//                i++;
//            }
//            //4.3 交换
//            if(i<j) {
//                int p = a[i];
//                a[i] = a[j];
//                a[j] = p;
//            }
//        }
//        // 4.4，调整key的位置
//        int p = a[i];
//        a[i] = a[low];
//        a[low] = p;
//        //5, 对key左边的数快排
//        quickSort(a, low, i-1 );
//        //6, 对key右边的数快排
//        quickSort(a, i+1, high);
//    }


    static void quickSort(int[] array,int low,int high){
        if(low>=high){
            return ;
        }
        int i = low;
        int j = high;
        int key = array[low];
        while(i<j){
            while(i<j && array[j]>key){
                j--;
            }
            System.out.println("j is" + j);
            System.out.println("i1 is" + i);
            while(i<j && array[i]<=key){
                i++;
            }
            System.out.println("i2 is" + i);
            if(i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i];
        array[i] = array[low];
        array[low] = temp;
        quickSort(array,low,i-1);
        quickSort(array,i+1,high);
    }

    public static void main(String[] args){
        int[] array = {1, 2, 4, 5, 7, 4, 5 ,3 ,9 ,0};
        System.out.println(Arrays.toString(array));
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
