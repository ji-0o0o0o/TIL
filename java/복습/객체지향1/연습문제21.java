package 복습.객체지향1;

public class 연습문제21 {

    public static int abs(int value){
        return Math.abs(value);
        //return value>=0?value:-value;
    }

    public static void main(String[] args) {
        int value =5;
        System.out.printf("%d의 절대값: %d\n",value,abs(value));
        value=-10;
        System.out.printf("%d의 절대값: %d",value,abs(value));
    }
}
