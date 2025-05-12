package class02;

import java.util.Arrays;
import java.util.StringJoiner;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {3,6,9,9,2,3,5,1,4,5,9,2,2,9,5,3};
        process(arr,0, arr.length-1);
        StringJoiner sj = new StringJoiner(",","[","]");
        Arrays.stream(arr).forEach(s->{
            sj.add(s+"");
        });
        System.out.println(sj);
    }

    public static void process(int[] arr, int L, int R){

        //递归结束条件
        if(L==R){
            return;
        }

        int mid = L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,R,mid);
    }

    public static void merge(int[] arr,int L, int R, int M){
        int left=L;
        int right=M+1;
        int index=0;
        int[] mergedArr=new int[R-L+1];
        while (left<=M && right<=R){
            if(arr[left]<=arr[right]){
                mergedArr[index] = arr[left];
                left++;
                index++;
            }else {
                mergedArr[index] = arr[right];
                right++;
                index++;
            }
        }
        while (left<=M){
            mergedArr[index] = arr[left];
            left++;
            index++;
        }
        while (right<=R){
            mergedArr[index] = arr[right];
            right++;
            index++;
        }

        for (int i = 0; i < mergedArr.length; i++) {
            arr[L+i] = mergedArr[i];
        }
        System.out.println(Arrays.toString(mergedArr));

    }


}
