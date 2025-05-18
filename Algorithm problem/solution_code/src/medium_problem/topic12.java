package medium_problem;

public class topic12 {
/*    public static String intToRoman(int num) {
        int exp=0;
        int weight;
        String result="";
        while(num>0){
            weight = num%10;

            switch (exp){
                case 0:{
                    if(weight<=3){
                        for (int i = 0; i < weight; i++) {
                            result="I"+result;
                        }
                    }else if(weight>=5 && weight<9){
                        for (int i=5;i<weight;i++){
                            result="I"+result;
                        }
                            result="V"+result;
                    }else if(weight==4){
                        result="IV"+result;
                    }else {
                        result ="IX"+result;
                    }
                    exp++;
                    num/=10;
                    break;
                }
                case 1:{
                    if(weight<=3){
                        for (int i = 0; i < weight; i++) {
                            result="X"+result;
                        }
                    }else if(weight>=5 && weight<9){
                        for (int i=5;i<weight;i++){
                            result="X"+result;
                        }
                            result="L"+result;

                    }else if(weight==4){
                        result="XL"+result;
                    }else {
                        result ="XC"+result;
                    }
                    exp++;
                    num/=10;
                    break;
                }
                case 2:{
                    if(weight<=3){
                        for (int i = 0; i < weight; i++) {
                            result="C"+result;
                        }
                    }else if(weight>=5 && weight<9){
                        for (int i=5;i<weight;i++){
                            result="C"+result;
                        }
                            result="D"+result;

                    }else if(weight==4){
                        result="CD"+result;
                    }else {
                        result ="CM"+result;
                    }
                    exp++;
                    num/=10;
                    break;
                }
                case 3:{
                    for (int i = 0; i < weight; i++) {
                        result="M"+result;
                    }
                    num/=10;
                    break;
                }

            }

        }

        return result;
    }*/

    public static void main(String[] args) {
        int  num=3749;
        topic12 t = new topic12();

        System.out.println(t.intToRoman(num));
    }


    //硬编码
  /*  String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num){
        StringBuilder sb = new StringBuilder();
        sb.append(thousands[num/1000]);
        sb.append(hundreds[num%1000/100]);
        sb.append(tens[num%100/10]);
        sb.append(ones[num%10]);


        return sb.toString();
    }*/
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int curNum = values[i];
            String curStr = symbols[i];

            while (num>=curNum){
                num-=curNum;
                sb.append(curStr);
            }

            if(num==0){
                break;
            }
        }

        return sb.toString();
    }

}
