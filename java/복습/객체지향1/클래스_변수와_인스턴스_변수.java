package 복습.객체지향1;

public class 클래스_변수와_인스턴스_변수 {
    public static void main(String[] args) {
        System.out.println("Card.height"+Card.height);//클래스 변수-> '클래스 이름.클래스 변수'로 이용 가능
        System.out.println("Card.width"+Card.width);

        Card c1 = new Card();
        c1.kind = "heart";
        c1.num=7;

        Card c2 = new Card();
        c2.kind = "spade";  //인스턴스 값 변환
        c2.num=4;

        System.out.printf("c1은 %s, %d이며, 크기는 (%d,%d)\n",c1.kind,c1.num,Card.height,Card.width);//클래스변수는 '클레스이름.변수이름'으로 가져올 수 있음
        System.out.printf("c2은 %s, %d이며, 크기는 (%d,%d)\n",c2.kind,c2.num,Card.height,Card.width);

        Card.width =50 ; //클래스 변수값을 지정
        Card.height=80;

        System.out.printf("c1은 %s, %d이며, 크기는 (%d,%d)\n",c1.kind,c1.num,Card.height,Card.width);
        System.out.printf("c2은 %s, %d이며, 크기는 (%d,%d)\n",c2.kind,c2.num,Card.height,Card.width);
    }
}
class Card {
    //인스턴스변수
    String kind;
    int num;
    //클래스변수
    static int width = 100;
    static int height = 250;
}
