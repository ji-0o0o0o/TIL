package 복습.객체지향1;

import java.util.Arrays;

public class 연습문제17 {
    public static int[] suffle(int[] original) {
        if(original==null || original.length==0) return original;//유효성검사


        for (int i = 0; i < original.length; i++) {
            int j=(int)(Math.random()*original.length);
            int tmp = original[j];
            original[j] = original[i];
            original[i] = tmp;

        }
        return original;
    }

    public static void main(String[] args) {
        int[] original = {1,2,3,4,5,6,7,8,9};
        System.out.println(java.util.Arrays.toString(original));

        int[] result = suffle(original);
        System.out.println(Arrays.toString(result));
        }


}
