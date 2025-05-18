package class02;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static Random r = new Random();

    public static void main(String[] args) {
        int[] arr= new int[]{3,6,9,9,2,3,5,1,4,5,9,2,2,9,5,3};
        int num=5;
        /*sort(arr,num);*/

        //partition(arr,0,7);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

 /*   private static void sort(int[] arr, int num) {
        int minCur=-1;
        int maxCur=arr.length;

        int index = 0;
        while (index<maxCur){
            if(arr[index]<num){
               minCur++;
               int temp = arr[minCur];
               arr[minCur]=arr[index];
               arr[index] = temp;
               index++;
            }else if(arr[index]==num){
                index++;
            }else {
                maxCur--;
                int temp =arr[maxCur];
                arr[maxCur]=arr[index];
                arr[index]=temp;
            }

        }

    }*/

    public static int[] partition(int[] arr, int L, int R){
        int sortedNum = arr[R];
        int minCur=L-1;
        int maxCur=R;

        int index = L;
        while (index<maxCur){
            if(arr[index]<sortedNum){
                minCur++;
                int temp = arr[minCur];
                arr[minCur]=arr[index];
                arr[index] = temp;
                index++;
            }else if(arr[index]==sortedNum){
                index++;
            }else {
                maxCur--;
                int temp =arr[maxCur];
                arr[maxCur]=arr[index];
                arr[index]=temp;
            }
        }

        int temp=arr[R];
        arr[R] =arr[maxCur];
        arr[maxCur] =temp;

        //System.out.println(minCur+","+maxCur);
        return new int[]{minCur,maxCur+1};

    }

    public static void quickSort(int[] arr, int L, int R){

        if(L>=R){
            return;
        }

        int randomIndex = r.nextInt(0,R - L + 1);
        int temp = arr[L+randomIndex];
        arr[L+randomIndex]=arr[R];
        arr[R] = temp;

        int[] part = partition(arr, L, R);
        quickSort(arr,L,part[0]);
        quickSort(arr,part[1],R);


    }

}
