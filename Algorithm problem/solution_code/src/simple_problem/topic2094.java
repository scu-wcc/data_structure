package simple_problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class topic2094 {
    /*给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
    你需要找出 所有 满足下述条件且 互不相同 的整数：
    该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
    该整数不含 前导零
    该整数是一个 偶数*/

    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new HashSet<>();
        int sum=0;
        for (int i = 0; i < digits.length; i++) {
            sum=digits[i];
            if(sum==0){
                continue;
            }

            for (int j=0; j<digits.length;j++){
                sum*=10;
                int num=digits[j];
                sum+=num;
                for (int k=0;k<digits.length;k++){
                    sum*=10;
                    int num2=digits[k];
                    sum+=num2;
                    set.add(sum);
                }
            }

        }
        Integer[] array = (Integer[]) set.stream().filter(n -> n % 2 == 0).toArray();
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i]=array[i];
        }


        return result;
    }

}
