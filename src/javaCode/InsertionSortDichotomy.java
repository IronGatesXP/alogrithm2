package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/22 21:00
 */
public class InsertionSortDichotomy {
    void insertionSortDichotomy(int[] array){
        for(int i=1;i<array.length;i++){
            int get = array[i];
            int left = 0;
            int right = i - 1;
            // 这里的=必须有，之前认为不必有是觉得反正得到的mid和left、right一样，没有意义，但是array[mid]是不一样的，这就导致left可能改变，如3,4的排列，如果
            // 没有等号，就会变成4,3的排列
            while(left<=right){
                int mid = (left + right)/2;
                if(array[mid]>get){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            for(int j=i-1;j>=left;j--){
                array[j+1] = array[j];
            }
            array[left] = get;
        }
    }

    public static void main(String[] args){
        int[] array = {6,5,3,1,8,7,2,4};
        System.out.println(Arrays.toString(array));
        InsertionSortDichotomy isd = new InsertionSortDichotomy();
        isd.insertionSortDichotomy(array);
        System.out.println(Arrays.toString(array));
    }
}
