package medium_problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class topic739 {
    /*
    给定一个整数数组 temperatures ，表示每天的温度，
    返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
    如果气温在这之后都不会升高，请在该位置用 0 来代替。
     */

    public static void main(String[] args) {
        topic739 p = new topic739();
        int[] arr= {73,74,75,71,69,72,76,73};
        int[] result = p.dailyTemperatures(arr);
        System.out.println(Arrays.toString(result));

    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int len = temperatures.length;

        for (int i = 0; i <len ; i++) {
            if (!numStack.isEmpty() && temperatures[i] > numStack.peek()) {
                while (!numStack.isEmpty() && temperatures[i] > numStack.peek()) {
                    int index = indexStack.pop();
                    numStack.pop();
                    temperatures[index] = i - index;
                }

            }
            numStack.push(temperatures[i]);
            indexStack.push(i);
        }

        while (!numStack.isEmpty()){
            numStack.pop();
            int index =  indexStack.pop();
            temperatures[index] = 0;
        }


        return temperatures;

    }

}
