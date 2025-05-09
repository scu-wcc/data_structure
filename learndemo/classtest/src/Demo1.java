import java.util.Arrays;

public class Demo1 {


    public static void main(String[] args){

        int[] arr={1,2,3,3,2,1,4,1,2,3,3,2,1};
        oddNumber(arr);

        int[] arr2={1,2,3,3,2,1,4,1,2,3,7,3,2,1};
        evenNumber(arr2);

        int[] arr3 = {1,6,9,3,6,4,2,1,6};
        insetSort(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {9,6,9,3,6,4,2,1,6};
        System.out.println(getMin(arr4));
    }

    public static void oddNumber(int[] arr){
        int eor=0;

        for(int i:arr){
            eor^=i;
        }
        System.out.println(eor);
    }

    public static void evenNumber(int[] arr){

        //取出数组中唯二的个数为奇数的数字
        int eor=0;
        for(int i:arr){
            eor^=i;
        }

        int otherOne = 0;
        int rightOne=eor&(~eor+1);
        for(int i:arr){
            if((rightOne&i) == rightOne){
                otherOne^=i;
            }
        }
        System.out.println("第一位："+(eor^otherOne)+", 第二位："+otherOne);
    }

    public static void swap(int[] arr ,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }

    //insertSort
    public static void insetSort(int[] arr){
        if(arr==null || arr.length<2){
            return;
        }
        int len=arr.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j]>=arr[j-1]){
                    break;
                }
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    //binaryQuery,查找局部最小
    public static int getMin(int[] arr){
        if(arr==null || arr.length<1){
            throw new RuntimeException("数组异常");
        }

        if(arr.length==1){
            return arr[0];
        }
        if(arr[0]<arr[1]){
            return arr[0];
        }
        if(arr[arr.length-2]>arr[arr.length-1]){
            return arr[arr.length-1];
        }
        int left=0;
        int right= arr.length-1;
        while (true){
            int indxe = (right+left)/2;
            if(arr[indxe-1]>arr[indxe]&&arr[indxe+1]>arr[indxe]){
                return arr[indxe];
            }
            if(arr[indxe]>arr[indxe-1]){
                right=indxe;
                indxe=(indxe+left)/2;
            }else {
                left=indxe;
                indxe=(indxe+right)/2;
            }
        }

    }



}
