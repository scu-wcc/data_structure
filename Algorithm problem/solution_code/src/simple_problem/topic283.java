package simple_problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class topic283 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     */

    public static void main(String[] args) {
        int[] arr = {1,3,0,6,9,0,5,8,2,0,8,0,2,5,0,0,0,41,4,2,0};
        topic283 p = new topic283();
        p.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void moveZeroes(int[] nums){

        int left = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i]!=0){
                int temp=nums[left];
                nums[left] = nums[i];
            }
        }
        for (;left<len;left++){
            nums[left] = 0;
        }
    }



/*    public void moveZeroes(int[] nums) {
        if(nums.length==0){
            return;
        }
        int len = nums.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            if (nums[i] != 0){
               queue.add(nums[i]);
            }
        }

        for (int i = 0; i < len; i++) {
            if(!queue.isEmpty()){
                nums[i] = queue.remove();
                continue;
            }
           nums[i] = 0;
        }
    }*/
}
