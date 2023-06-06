package src.study;

public class Person {
    protected int health;
    protected int attack;
    public Person(int health, int attack){
        this.attack = attack;
        this.health = health;
    }

    public Person() {
        this.attack = 0;
        this.health = 1;
    }

    public void Speak(){
        System.out.println("I am Person! My health = " + health);
    }
}
