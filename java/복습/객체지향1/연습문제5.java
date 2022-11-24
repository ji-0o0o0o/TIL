package 복습.객체지향1;

class PlayingCard{
    int kind;//인스턴스 변수
    int num;//인스턴스 변수

    static int width; //클래스 변수
    static int height;//클래스 변수

    public PlayingCard(int k, int n) {
        this.kind = k;
        this.num = n;
        //인스턴스변수(kind,num)  지역변수(k,n)
    }

    public static void main(String[] args) {
        PlayingCard card = new PlayingCard(1,1);
    }
    //card, args 지역변수
}
