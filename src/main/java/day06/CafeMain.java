package day06;

public class CafeMain {
    public static void main(String[] args) {
        Americano americano = new Americano("tall",4000);
        Latte latte = new Latte("tall",6000);

        Customer customer = new Customer(5000);

        customer.buyCoffee(americano);
        customer.buyCoffee(latte);
    }
}
