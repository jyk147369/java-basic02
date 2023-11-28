package day06;

public class Latte extends Coffee{

    private String name;

    public Latte (String size, int price) {
        super(size, price);
        this.name="라떼";
    }
    public String getName() {
        return name;
    }
}
