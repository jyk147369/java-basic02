package day03;

public class Tristana extends Champion{
    Integer z;

    void jump(){
        z = z + 10;
    }

    public Tristana(String name, Integer attackDamage, Integer attackRange, Integer hp, Integer defence, Integer level, Integer exp, Integer x, Integer y, String[] itemList) {
        super(name, attackDamage, attackRange, hp, defence, level, exp, x, y, itemList);
    }

    Tristana(String name) {
        super(name);
    }

    Tristana(Integer hp) {
        super(hp);
    }
}
