import java.util.HashMap;
import java.util.Map;

public class topic13 {

    private static final Map<Character,Integer> map = new HashMap<>();

    static {
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
    }

/*
    Map<Character,Integer> map =Map.of(
            'I',1,
            'V',5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000
    );
*/

    public int romanToInt(String s) {
        int len = s.length();
        int result=0;
        for (int i = 0; i < len; i++) {
            char first = s.charAt(i);
            if (i < len - 1) {
                char next = s.charAt(i + 1);
                if ((first == 'I' && (next == 'V' || next == 'X')) ||
                        (first == 'X' && (next == 'L' || next == 'C')) ||
                        (first == 'C' && (next == 'D' || next == 'M'))) {
                    result += map.get(next) - map.get(first);
                    i++;
                    continue;
                }
            }
            result += map.get(first);

        }
        return result;
    }

}
