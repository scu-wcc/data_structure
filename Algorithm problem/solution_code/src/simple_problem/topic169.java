package simple_problem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class topic169 {
    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */

/*    public int majorityElement(int[] nums) {
        int len = nums.length;
        int flag = len/2;
        int max=1;
        int result=nums[0];
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if(map.containsKey(cur)){
                int count = map.get(cur)+1;
                if(count>max){
                    max=count;
                    result =cur;
                }
                map.put(cur,count);
            }else {
                map.put(cur,1);
            }
        }

        return result;
    }*/


/*
    public int majorityElement(int[] nums) {
        int len = nums.length/2;
        Arrays.sort(nums);
        return nums[len];

    }
*/
//    public void heapFy(int[] arr, int heapSize){
//        swap(arr,0, --heapSize);
//        int cur=0;
//        int left =1;
//        while (left<heapSize){
//            int right = left+1;
//            int maxKid = right<heapSize && arr[right]>arr[left]? right:left;
//            int max = arr[maxKid]>arr[cur]? maxKid:cur;
//
//            if(max==cur){
//                break;
//            }
//
//            swap(arr,max,cur);
//            cur=max;
//            left = cur*2+1;
//        }
//
//
//    }
//
//
//    public int majorityElement(int[] nums){
//        int len = nums.length;
//        for (int i = 0; i< len ; i--) {
//           heapInset(nums,i);
//        }
//
//        for (int i = 0; i < len; i++) {
//            heapFy(nums,len-i);
//        }
//
//        return nums[len/2];
//
//    }
//
//    public void swap(int[] arr, int i, int j){
//        int temp= arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public void heapInset(int[] arr,int i){
//        while (arr[i]>arr[(i -1)/2]){
//            swap(arr, i,(i -1)/2);
//            i = (i-1)/2;
//        }
//
//    }
    public static void main(String[] args) {
        int[] arr = {2,9,3,6,4,1,3,6};
        topic169 p = new topic169();
        p.quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public int majorityElement(int[] nums) {

        quickSort(nums,0,nums.length-1);

        return nums[nums.length/2];
    }

    private void quickSort(int[] nums, int left, int right) {
        if(left>=right){
            return;
        }
        int minIndex= left-1;
        int maxIndex = right;
        int index = left;
        while (index<maxIndex){
            if(nums[index]<nums[right]){
                int temp = nums[minIndex+1];
                nums[minIndex+1]=nums[index];
                nums[index] = temp;
                index++;
                minIndex++;
            }else if(nums[index]>nums[right]){
               int temp =  nums[index];
                nums[index] = nums[maxIndex-1];
                nums[--maxIndex] = temp;
            }else {
                index++;
            }

        }
       int temp =  nums[maxIndex];
        nums[maxIndex]=nums[right];
        nums[right] = temp;
        quickSort(nums,left,minIndex);
        quickSort(nums,maxIndex+1,right);

    }

}
