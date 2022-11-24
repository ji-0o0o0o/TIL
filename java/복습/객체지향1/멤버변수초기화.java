package 복습.객체지향1;

public class 멤버변수초기화 {
    static class data4 {
        //클래스 초기화 블럭
        static {
            System.out.println("static{}");
        }

        //인스턴스 초기화 블럭
        {
            System.out.println("{ }");
        }

        public data4() {
            System.out.println("생성자");
        }

        public static void main(String[] args) {
            System.out.println("data4 d4 = new data4();");
            data4 d4 = new data4();

            System.out.println("data4 d5 = new data4();");
            data4 d5 = new data4();

        }
        //결과
//        static{} -> 클래스 처음 로딩 될 떄 단 한번(메모리 올라갈때)
//        data4 d4 = new data4();
//        { }-> 인스턴스 메서드는 생성될때마다
//        생성자
//        data4 d5 = new data4();
//        { }
//        생성자

    }
}
