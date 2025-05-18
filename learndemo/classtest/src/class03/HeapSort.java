package class03;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        int[] arr= {9,6,3,5,7,2,3,5,1,5,8};
        int len = arr.length;


        heapSort(arr);

        for (int i = 0; i <len; i++) {
            System.out.print(arr[i]+",");
        }

    }

    public static void heapSort(int[] arr){
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            heapInsert(arr,i);
        }

        for (int i = 0; i < size; i++) {
            heapFy(arr,0,size-i);
        }

    }


    //堆插入
    public static void heapInsert(int[] arr, int num, int heapSize){
        arr[heapSize] = num;
        int index = heapSize;
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    //重构方法，假设index之前的堆都已经排号了
    public static void heapInsert(int[] arr, int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }

    }

    //堆取出
    public static void heapFy(int[] arr, int index, int heapSize){
        swap(arr, index, --heapSize);
        int left= index*2+1;
        while (left<heapSize){
            int right = left+1;
            int maxIndex = right<heapSize && arr[right]>arr[left]?right:left;
            maxIndex = arr[maxIndex]>arr[index]?maxIndex:index;
            if(maxIndex== index)
            {
                break;
            }
            swap(arr,index,maxIndex);
            index = maxIndex;
            left = index*2+1;
        }


    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;

    }

}
