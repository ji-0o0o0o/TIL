package 복습.객체지향1;

public class 멤버변수초기화2 {
    static int[] arr = new int[10];//배열 자리 10개 생성

    static{
        for (int i = 0; i < arr.length ; i++) {
            arr[i]=(int)(Math.random()*10)+1;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.printf("arr[%d] : %d\n",i,arr[i]);
        }
    }
    //배열이나 예외처리가 필요한 초기화에서는 명시적 초기화만으로 복잡한 초기화 작업할 수 없다
    //이런 경우 추가적으로 클래스 초기화 블럭 사용
}
