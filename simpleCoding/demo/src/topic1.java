import java.util.HashMap;
import java.util.Map;

public class topic1 {
    /*给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。*/
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> hashMap = new HashMap<>();
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }
            hashMap.put(nums[i],i);
        }

        return new int[0];
    }

    public static void main(String[] args) {

    }

}
