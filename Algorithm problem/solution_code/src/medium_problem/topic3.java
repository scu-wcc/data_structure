package medium_problem;

import java.util.*;

public class topic3 {
    /*给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。*/

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int left = 0;
        int len = s.length();
        int count=0;
        int max=0;
        for (int i=0; i<len; i++){
            char ch = s.charAt(i);

            if(set.contains(ch)){
                while (true){
                    if(s.charAt(left)==ch){
                        left++;
                        break;
                    }else {
                        set.remove(s.charAt(left));
                        left++;
                        count--;
                    }
                }
                continue;
            }
            set.add(ch);
            count++;
            if(count>max){
                max=count;
            }

        }
        return max;
    }

    public static int test2(String s){

        int len =s.length();
        int[] arr=new int[128];
        //设置字符位置，-1为未出现
        Arrays.fill(arr,-1);
        int maxShuttle=0;
        int curLeft=0;

        for (int i = 0; i < len; i++) {
            char ch= s.charAt(i);

            if(arr[ch]>=curLeft){
                curLeft=arr[ch]+1;
            }

            if(i-curLeft+1>maxShuttle){
                maxShuttle=i-curLeft+1;
            }
            arr[ch]=i;
        }
        return maxShuttle;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

}
