package simple_problem;

import java.util.HashMap;
import java.util.Stack;

public class topic20 {

    public static HashMap<Character, Character> hm = new HashMap<>();

    static {

        hm.put('}', '{');
        hm.put(']', '[');
        hm.put(')', '(');
    }

    /*public static boolean isValid(String s) {
        int len;
        if ((len = s.length()) % 2 == 1) {
            return false;
        }
        int index = 0;
        char[] chArr = new char[len];
        for (int i = 0; i < len; i++) {
            chArr[index] = s.charAt(i);
            Character c = hm.get(chArr[index]);
            if (index > 0 && c!=null) {
                if (c==chArr[index-1]) {
                    index--;
                    continue;
                }
            }
            index++;
        }

        return index == 0;

    }*/

    public static void main(String[] args) {

        System.out.println(isValid("([}}])"));

    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);

            switch (c){
                case '{','[','(':{
                    stack.push(c);
                    break;
                }
                case '}': {
                    if(stack.isEmpty() || stack.peek()!='{')
                        return false;
                    stack.pop();
                    break;
                }
                case ')': {
                    if(stack.isEmpty() || stack.peek()!='(')
                        return false;
                    stack.pop();
                    break;
                }
                case ']': {
                    if(stack.isEmpty() || stack.peek()!='[')
                        return false;
                    stack.pop();
                    break;
                }
            }


        }

        return stack.isEmpty();
    }


}
