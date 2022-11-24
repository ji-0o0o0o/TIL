package 복습.객체지향1;

public class 메서드의_실행_흐름 {
    public static void main(String[] args) {

        MyMath mm = new MyMath();//MyMath객체 생성
        long result1 = mm.add(5L, 3L);//MyMath클래스에서 add메서드에 (5L,3L)argument 적용한다.
        long result2 = mm.subtract(5L, 3L);
        long result3 = mm.multiply(5L, 3L);
        double result4 = mm.divide(5L, 3L);//L은 double보다 적은 메모리 사용하므로 자동 변환된다.

        System.out.println("add(5L, 3L) = "+ result1);
        System.out.println("subtract(5L, 3L) = "+ result2);
        System.out.println("multiply(5L, 3L) = "+ result3);
//        System.out.println("divide(5L, 3L) = "+ result4); //divide(5L, 3L) = 1.6666666666666667
        System.out.printf("divide(5L, 3L) = %.2f",result4);//divide(5L, 3L) = 1.67
        //%f 실수형 끄내올때 쓰인다. 가운데 '.2'는 소숫점아래 꺼내올 자리수

    }
}

class MyMath{//MyMath 클래스 만듬
    long add(long a, long b){ //반환타입 long, 더하는 결과를 내는 메서드, 파라미터 a,b
        return a+b;
    }
    long subtract(long a, long b){return  a- b; }
    long multiply(long a, long b){return  a* b; }
    double divide(double a, double b){return  a/ b; }

}
