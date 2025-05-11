public class topic9 {

    //回文数
    public static boolean isPalindrome(int x) {
        if(x<11 && x!=0){
            return false;
        }
        int num =x;
        int temp=0;
        while (x>0){
            temp = temp*10+x%10;
            x/=10;
        }
        return num==temp;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(111));
    }
}
