package class02;

import java.util.Map;

public class Demo2 {

    public static void main(String[] args) {

        int[] arr = {3,6,4,1,3,6,8,1,2,5,4,3,68,1,365,1,3};
        System.out.println(getMax(arr));

    }

    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    //递归求最大值，将数组不断拆分，直到每个数组只取一个位置的元素(L==R),返回该元素，上一层调用者返回两数的最大值。
    //递归的结构是一棵树，树的子叶是该数组的各个元素
    public static int process(int[] arr, int L ,int R) {
            if(L==R){
                return arr[L];
            }
            int mid = L+((R-L)>>1);
            int lefMax=process(arr,L, mid);
            int rightMax = process(arr,mid+1,R);
            return Math.max(lefMax,rightMax);
    }



}
