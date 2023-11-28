package day03;

import java.util.Arrays;

public class Champion {
    String name;
    Integer atk;
    Integer range;
    Integer hp;
    Integer def;
    Integer lv;
    Integer exp;
    Integer x;
    Integer y;
    String[] itemList;

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", attackDamage=" + atk +
                ", attackRange=" + range +
                ", hp=" + hp +
                ", defence=" + def +
                ", level=" + lv +
                ", exp=" + exp +
                ", x=" + x +
                ", y=" + y +
                ", itemList=" + Arrays.toString(itemList) +
                '}';
    }


    // Alt + Insert 키를 누르면 개발 도구를 통해 자동으로 여러 메소드 생성 가능
    // Constructor가 생성자
    // 변수를 선택해서 생성자를 만들면 객체를 생성하면서 실행하는 생성자를 통해
    // 매개변수로 값을 전달 받고 전달받은 값으로 객체의 변수들을 초기화할 수 있다.
    public Champion(String name, Integer attackDamage, Integer attackRange, Integer hp, Integer defence, Integer level, Integer exp, Integer x, Integer y, String[] itemList) {
        this.name = name;
        this.atk = attackDamage;
        this.range = attackRange;
        this.hp = hp;
        this.def = defence;
        this.lv = level;
        this.exp = exp;
        this.x = x;
        this.y = y;
        this.itemList = itemList;
        for (int i=0; i<this.itemList.length; i++) {
            this.itemList[i] = "빈칸";
        }
    }

    // 이동
    void move(Integer x, Integer y) {
        // 클래스 안에 있는 x와 전달받은 void move(Integer x, Integer y)의 x와 구분해주기 위해서 this.를 씀
        // 전달 받은 매개변수 x를 객체의 x에 저장
        this.x = x;
        // 전달 받은 매개변수 y를 객체의 y에 저장
        this.y = y;
    }

    // 귀환
    void recall(){
        this.x = 0;
        this.y = 0;
    }

    // 아이템 구매
    String[] buy(String item) {
        for (int i=0; i< this.itemList.length; i++) {
            if(this.itemList[i]=="빈칸"){
                this.itemList[i]=item;
                break;
            }
        }
        return itemList;
    }

    // 데스
    void die() {
        this.recall();
        this.hp = 100;
    }

    // 공격
    Integer attacked(Integer atk){
        this.hp = this.hp - atk;
        if(hp<=0) {
            this.die();
        }
        return hp;
    }

    // 메소드 오버로딩
    // 똑같은 이름의 메소드를 여러개 만드는 것. 단, 매개변수 수나 매개변수의 타입이 달라야 함
    // 메소드를 사용하는 쪽에게 여러 사용 방법을 제공해주는 것
    Champion(String name){
        this.name = name;
    }

    Champion(Integer hp){
         this.hp = hp;
     }

    // attacked 메소드를 오버로딩을 이용해서
    // 숫자를 하나 더 전달 받는 메소드를 만든다

    Integer attacked(Integer atk, Integer num) {
        this.hp = this.hp - atk * num;
        if(hp<=0) {
            this.die();
        }
        return hp;
    }

    void attackTo(Champion target){
        // 1부터 100 사이의 랜덤 숫자를 생성
        // 만약에 90 이상이면
        //      3배 크리티컬 공격
        // 그렇지 않고 만약에 80 이상이면
        //      2배 크리티컬 공격
        Integer critical = (int)(Math.random()*100)+1;
        if(critical>=90){
            target.attacked(this.atk, 3);
        } else if (critical>=80) {
            target.attacked(this.atk, 2);
        }

        target.attacked(this.atk);
    }

    // 레벨업
    Integer levelUp(){
        // 현재 lv에 1 더해서 저장
        // atk에 10%를 증가
        // def에 5%를 증가
        // hp에 20%를 증가
        this.lv = this.lv + 1;
        this.atk = this.atk * 110 / 100;
        this.def = this.def * 105 / 100;
        this.hp = this.hp * 120 / 100;

        // this는 앞으로 쓰일 객체를 대신 표현해준 것. 생략 가능함

        return lv;
    }

    // 경험치업
    Integer expUp(String enemy){
        // 만약에 enemy가 미니언이면
        //      현재 경험치에 10 추가
        // 그렇지 않고 만약에 enemy가 용이면
        //      현재 경험치에 50 추가
        // 그렇지 않고 만약에 enemy가 타워면
        //      현재 경험치에 100 추가

        // 만약에 현재 경험치가 100보다 크면
        //      레벨업
        //      현재 경험치를 초기화 시킨다.
        if(enemy=="미니언"){
            exp =  exp + 10;
        } else if(enemy=="용") {
            exp = exp + 50;
        } else if(enemy=="타워"){
            exp = exp + 100;
        }

        if (exp>=100){
            this.levelUp();
            exp = exp % 100;
        }

        return exp;
    }

}
