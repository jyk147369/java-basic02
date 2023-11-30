package day06.Generic;

// Parents 클래스에 여러 타입의 변수를 만들어서 쓸 때
public class Parents2 {
    String string;
    Integer integer;
    Character character;

    // String 타입의 생성자, 게터, 세터
    public Parents2(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }


    // Integer 타입의 생성자, 게터, 세터
    public Parents2(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    // Character 타입의 생성자, 게터, 세터
    public Parents2(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}


