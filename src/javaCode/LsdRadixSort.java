package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/25 16:07
 */

/*
    为什么基数排序要调用具有稳定性的排序方法？
    因为我们采用的是低位优先的比较方法，所以在比较高位时地位的大小已经确定，而我们只需要确定高位的大小，用
    稳定的排序就能保证高位相同的数低位会按照之前低位已经比较过的顺序存放，如123和134
 */
public class LsdRadixSort {
    static int getDigit(int x, int d){
        //int[] radix = {1,1,10,100};
        int radix = 1;
        //System.out.println(radix);
        while(d>1){
            radix *= 10;
            d--;
            //System.out.println(radix);
        }
        return (x/radix) % 10;
    }

    static void countSort(int[] A,int d){
        int[] C = new int[10];
        int[] B = new int[A.length];
        for(int i=0;i<A.length;i++){
            // System.out.println("第 " + d + "数是" + getDigit(A[i],d));
            C[getDigit(A[i],d)]++;
        }
        System.out.println("第" + d + "位： " + "出现次数 "+Arrays.toString(C));
        for(int i=1;i<C.length;i++){
            C[i] += C[i-1];
        }
        System.out.println("第" + d + "位： " + "出现总次数 "+Arrays.toString(C));
        for(int i=A.length-1;i>=0;i--){
            B[C[getDigit(A[i],d)]-1] = A[i];
            C[getDigit(A[i],d)]--;
        }
        System.out.println("第" + d + "位： " + "B数组 "+Arrays.toString(B));
        for(int i=0;i<A.length;i++){
            A[i] = B[i];
        }
    }

    static void lsdRadixSort(int[] A,int d){
        for(int i = 1;i<=d;i++){
            countSort(A,i);
        }
    }

    public static void main(String[] args){
        int[] A = {329,457,657,839,436,720,355};
        System.out.println(Arrays.toString(A));
        lsdRadixSort(A,3);
        System.out.println(Arrays.toString(A));
    }

}
