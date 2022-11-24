package 복습.객체지향1;

public class 연습문제18 {
    public static boolean isNumber(String str) {

        if(str==null || str.length()==0) return false;//유효성검사

        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        String str = "123";
        System.out.printf("%s는 숫자입니까? %b\n",str,isNumber(str));

        str = "123o";
        System.out.println(str+"는 숫자입니까?"+isNumber(str));
        System.out.printf("%s는 숫자입니까? %b\n",str,isNumber(str));
    }
}
