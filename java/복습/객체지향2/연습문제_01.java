package 복습.객체지향2;

import java.util.Scanner;

class SutdaDeck{
    final int CARD_NUM=20;
    private  boolean isKwang;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck(){
        //배열 SutdaDeck초기화
        for (int i = 0; i < cards.length; i++) {
            int num = i%10+1;
            boolean isKwang = (i<10)&&(num==3||num==1||num==8);

            cards[i] = new SutdaCard(num,isKwang);
        }
    }

    void shufle(){
        for (int i = 0; i <cards.length ; i++) {
            int j =(int)(Math.random()*cards.length);
            SutdaCard ids =cards[i];
            cards[i]=cards[j];
            cards[j]=ids;

        }
    }

    SutdaCard pick(int idx ){
        if (idx<0||idx>=CARD_NUM)
            return null;

        return cards[idx];
    }

    SutdaCard pick(){
    int rd = (int)(Math.random()*cards.length);
        System.out.println("임의의 자리는 "+ (rd+1));
    return pick(rd);
    }



}
class SutdaCard{
    int num;
    boolean isKwang;

    SutdaCard(){
        this(1,true);
    }

    public SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    //toString오버라이딩
    public String toString(){
        return num+(isKwang?"K":"");
    }
}
public class 연습문제_01 {
    public static void main(String[] args) {
        SutdaDeck deck = new SutdaDeck();


        for (int i = 0; i < deck.cards.length ; i++) {
            System.out.print(deck.cards[i]);
            if(i<deck.cards.length-1){
                System.out.print(",");
            }
        }
        deck.shufle();

        System.out.println("\n섞은 후");
        for (int i = 0; i < deck.cards.length ; i++) {
            System.out.print(deck.cards[i]);
            if(i<deck.cards.length-1){
                System.out.print(",");
            }
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("\n원하는 자리수 : ");
        System.out.println("원하는 자리수의 숫자는 "+deck.pick(sc.nextInt()-1));


        System.out.println("임의의 자리의 SatdaCard: "+deck.pick());
    }
}
