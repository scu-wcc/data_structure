package medium_problem;

import java.util.Arrays;
import java.util.Random;

public class topic912 {
    /*给你一个整数数组 nums，请你将该数组升序排列。
    你必须在 不使用任何内置函数 的情况下解决问题，时间复杂度为 O(nlog(n))，并且空间复杂度尽可能小。*/

    static Random r =new Random();

    public static void main(String[] args) {
        int [] arr={5,2,3,1};
        System.out.println(Arrays.toString(sortArray(arr)));
    }
    public static int[] sortArray(int[] nums) {



        quickSort(nums,0,nums.length-1);

        return nums;
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left>=right){
            return;
        }


        int randomIndex= r.nextInt(0,right-left+1) +left;

        int num =arr[randomIndex];
        arr[randomIndex]=arr[right];
        arr[right]=num;


        int minCur=left-1;
        int maxCur=right;
        int index=left;
        while (index<maxCur){
            if(arr[index]<num){
                minCur++;
                int temp=arr[minCur];
                arr[minCur]=arr[index];
                arr[index] =temp;
                index++;
            }else if(arr[index]==num){
                index++;
            }else {
                maxCur--;
                int temp= arr[maxCur];
                arr[maxCur]=arr[index];
                arr[index]=temp;
            }
        }
        arr[right]=arr[maxCur];
        arr[maxCur]=num;
        maxCur++;

        quickSort(arr,left,minCur);
        quickSort(arr,maxCur,right);

    }



  /*  public static int[] mergeSort(int[] arr, int L, int R){
        if(L>=R){
            return arr;
        }

        int mid = L+((R-L)>>1);
        mergeSort(arr,L,mid);
        mergeSort(arr,mid+1,R);

        System.out.println("L="+L+", R="+R);
        sort(arr,L,R,mid);

        return arr;
    }

    private static void sort(int[] arr, int l, int r, int m) {
        int left =l;
        int right=m+1;
        int index=0;
        int[] mergedArr = new int[r-l+1];
        while (left<=m && right<=r){
            mergedArr[index++]= arr[left]<=arr[right]?arr[left++]:arr[right++];
        }
        while (left<=m){
            mergedArr[index++]=arr[left++];
        }
        while ((right<=r)){
            mergedArr[index++]=arr[right++];
        }

        System.out.println(Arrays.toString(mergedArr));
        for (int i = 0; i < mergedArr.length; i++) {
            arr[l+i]=mergedArr[i];
        }
    }

    */
}
