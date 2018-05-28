package javaCode;

import java.util.Arrays;

/**
 * @author XP
 * @date 2018/5/24 15:56
 */
public class HeapSort {
//    public void HeapAdjust(int[] array, int parent, int length) {
//
//        int temp = array[parent]; // temp保存当前父节点
//
//        int child = 2 * parent + 1; // 先获得左孩子
//
//
//
//        while (child < length) {
//
//            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
//
//            if (child + 1 < length && array[child] < array[child + 1]) {
//
//                child++;
//
//            }
//
//
//
//            // 如果父结点的值已经大于孩子结点的值，则直接结束
//
//            if (temp >= array[child])
//
//                break;
//
//
//
//            // 把孩子结点的值赋给父结点
//
//            array[parent] = array[child];
//
//
//
//            // 选取孩子结点的左孩子结点,继续向下筛选
//
//            parent = child;
//
//            child = 2 * child + 1;
//
//        }
//
//
//
//        array[parent] = temp;
//
//    }
//
//
//
//    public void heapSort(int[] list) {
//
//        // 循环建立初始堆
//
//        for (int i = list.length / 2; i >= 0; i--) {
//
//            HeapAdjust(list, i, list.length - 1);
//            System.out.println(i+"初 始 堆: \t"+Arrays.toString(list));
//        }
//        System.out.println("初 始 堆: \t"+Arrays.toString(list));
//
//
//        // 进行n-1次循环，完成排序
//
//        for (int i = list.length - 1; i > 0; i--) {
//
//            // 最后一个元素和第一元素进行交换
//
//            int temp = list[i];
//
//            list[i] = list[0];
//
//            list[0] = temp;
//
//
//
//            // 筛选 R[0] 结点，得到i-1个结点的堆
//
//            HeapAdjust(list, 0, i);
//
//            System.out.format("第 %d 趟: \t", list.length - i);
//
//            System.out.println(Arrays.toString(list));
//
//        }
//
//    }
//
//    public static void main(String[] args){
//        int[] array = {6,5,3,1,7,2,4};
//        System.out.println(Arrays.toString(array));
//        HeapSort hs = new HeapSort();
//        hs.heapSort(array);
//        System.out.println(Arrays.toString(array));
//    }

    void Swap(int A[], int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    void Heapify(int A[], int i, int size)  // 从A[i]向下进行堆调整
    {
        int left_child = 2 * i + 1;         // 左孩子索引
        int right_child = 2 * i + 2;        // 右孩子索引
        int max = i;                        // 选出当前结点与其左右孩子三者之中的最大值
        if (left_child < size && A[left_child] > A[max])
            max = left_child;
        if (right_child < size && A[right_child] > A[max])
            max = right_child;
        if (max != i)                       // 迭代必须有终止条件不然会出现StackOverflowError异常，这里的max！= i，指的是要不找到没有子节点的A[i]，
        {                                   // 要不找到父节点本来就比子节点大，但这种情况应该是在子节点都比父节点大的前提下，所以在BuildHeap时应该从
                                            //下层父节点，即i大的节点开始,当max=i时说明这个节点已经比它的左右孩子节点大了
            Swap(A, i, max);                // 把当前结点和它的最大(直接)子节点进行交换
            Heapify(A, max, size);          // 递归调用，继续从当前结点向下进行堆调整
        }
    }

    int BuildHeap(int A[], int n)           // 建堆，时间复杂度O(n)
    {
        int heap_size = n;
        for (int i = heap_size / 2 - 1; i >= 0; i--) // 从每一个非叶结点开始向下进行堆调整,为了保证各个父节点都大于子节点
            Heapify(A, i, heap_size);
        return heap_size;
    }

    void heapSort(int A[], int n) {
        int heap_size = BuildHeap(A, n);    // 建立一个最大堆，每个节点的值大于等于其左、右孩子的值
        System.out.println("最大堆" + Arrays.toString(A));
        while (heap_size > 1)  // 堆（无序区）元素个数大于1，未完成排序\
        {
            // 将堆顶元素与堆的最后一个元素互换，并从堆中去掉最后一个元素
            // 此处交换操作很有可能把后面元素的稳定性打乱，所以堆排序是不稳定的排序算法
            Swap(A, 0, --heap_size);
            Heapify(A, 0, heap_size);     // 从新的堆顶元素开始向下进行堆调整，时间复杂度O(logn)
        }
    }



    public static void main(String[] args){
        int[] array = {6,5,3,1,7,2,4};
        System.out.println(Arrays.toString(array));
        HeapSort hs = new HeapSort();
        hs.heapSort(array,array.length);
        System.out.println(Arrays.toString(array));
    }

}
