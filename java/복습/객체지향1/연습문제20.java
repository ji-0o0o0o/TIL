package 복습.객체지향1;

import java.util.Arrays;


public class 연습문제20 {

    public static int max(int[] arr) {
        if (arr == null || arr.length == 0) return -999999;//유효성검사

        int max = 0;
//        for (int i = 0; i <arr.length ; i++) {
//            if (max<arr[i]){
//                max=arr[i];
//            }
//        }
        for(int j:arr){
            if(max<j){
                max=j;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] data = {3,2,9,4,7};
        System.out.println(Arrays.toString(data));
        System.out.println("최대값 : "+max(data) );
        System.out.println("최대값 : "+max(null) );
        System.out.println("최대값 : "+max(new int[]{}) );
    }

}
