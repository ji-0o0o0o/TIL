package 복습.객체지향2;


import java.util.Arrays;

class Product {
    int price;
    int bonusPoint;

    Product(int price) {
        this.price = price;
        bonusPoint = (int) (price / 10.0);//보너스 점수는 가격의 10%
    }
    Product(){};//기본생성자
}

class Tv1 extends Product {

    Tv1() {//조상클래스의 생성자 호출됨
        super(100);
    }

    public String toString() {
        return "Tv";
    }//Object클래스 toString() 오버라이당
}

class Computer extends Product {
    Computer() {
        super(200);
    }

    public String toString() {
        return "Computer";
    }//Object클래스 toString() 오버라이당
}
class Audio extends Product{
    Audio(){
        super(50);
    }
    public String toString(){return "Audio";}
}

 class Buyer {
    int money = 1000;
    int bonusPoint = 0;
    Product[] cart = new Product[10];//장바구니 만들어줌
    int i =0;

    void Buy(Product p) { //다형성을 이용해 같은 조상의 매개변수를 공유할 수 있도록 적어주었다.
        if (money < p.price) {
            System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
            return;
        }
        money -= p.price;
        bonusPoint += p.bonusPoint;
        cart[i++]=p;
        System.out.println(p + "을/를 구매하셨습니다.");
    }
    void summary(){
        int sum=0;
        String itemList ="";

        for (int j = 0; j <cart.length ; j++) {
            if (cart[j]==null)break;
            sum+=cart[j].price;
            itemList+=cart[j]+",";
        }
        System.out.println("총금액은 "+sum);
        System.out.println("쇼핑한 종류는  "+itemList);
    }

}


public class 매개변수의_다형성 {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        b.Buy(new Tv1());
        b.Buy(new Computer());
        b.Buy(new Audio());
        b.summary();

        System.out.println("현재 남은 돈은 " + b.money);
        System.out.println("현재 보너스점수는  " + b.bonusPoint);
    }
}
