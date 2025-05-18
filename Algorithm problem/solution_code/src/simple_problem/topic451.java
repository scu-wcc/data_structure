package simple_problem;

import java.util.*;

public class topic451 {
    public static void main(String[] args) {

        topic451 p = new topic451();
        String  str = "abcesesadsae";
        System.out.println(p.frequencySort(str));

    }

    Map<Character, Integer> map = new HashMap<>();

    public String frequencySort(String s) {
        if(s.isEmpty()){
            return "";
        }

        String result="";

        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                int count = map.get(ch);
                count++;
                map.put(ch,count);
            }else {
                map.put(ch,1);
            }
        }



        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));

        int size = list.size();
        for (int i = 0; i < size; i++) {
            char  ch = list.get(i);
            int count = map.get(ch);
            for (int j = 0; j < count; j++) {
                result+=ch;
            }
        }

        return result;
    }

}
