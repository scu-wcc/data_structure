package class02;

import java.util.Arrays;
import java.util.StringJoiner;

public class AddMinor {

    //在归并排序的过程中添加一个计算，算出原数组中元素左侧较小数的和
    public static int count=0;

    public static void main(String[] args) {
        int[] arr = {1,3,4,2,1,5};
        process(arr,0, arr.length-1);
        StringJoiner sj = new StringJoiner(",","[","]");
        Arrays.stream(arr).forEach(s->{
            sj.add(s+"");
        });
        System.out.println(sj);
        System.out.println("小和："+count);
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
            //左组和右组相等，先存入右组，直到找到右组中严格比左组大的数
            if(arr[left]<arr[right]){
                mergedArr[index] = arr[left];
                count+=arr[left]*(R-right+1);
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


    }

}
