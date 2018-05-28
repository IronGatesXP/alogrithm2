package javaCode;

import java.util.Arrays;

/*把相邻的两个元素比较大小后移动位置，从头到尾比较一轮后可以得出一个最大值（假设需要得到从小到大的顺序）
	  但最后一个元素不需要参与循环，因为他的右方没有元素
	  第一个循环决定要循环多少轮，第二个决定相邻元素比较的次数
	  测试前把注释删掉
	*/

/**
 * @author XP
 * @date 2018/5/22 16:53
 */
public class BubbleSort {
    void sort(int[] array){
        int temp;
        int sum = 0;
        for(int i = 0;i<array.length - 1;i++){
            for(int j = 0;j<array.length - i - 1;j++){
                sum++;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("sum is: " + sum);
    }
    public static void main(String[] args){
        int[] array = {2,3,5,1,4,6};
        System.out.println(Arrays.toString(array));
        BubbleSort bs = new BubbleSort();
        bs.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
