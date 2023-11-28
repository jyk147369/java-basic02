package day06;

public class Customer {
    int money;

    public Customer(int money) {
        this.money = money;
    }

    void buyCoffee(Coffee coffee) {
        if(this.money >= coffee.price) {
            System.out.println("구매 가능");
        } else {
            System.out.println("구매 불가능");
        }
    }

}







