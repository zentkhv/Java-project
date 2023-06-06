package src.study;

public class Orc extends Person{
    public Orc (int health, int attack){
        this.health = health * 2;
        this.attack = attack * 2;
    }

    @Override
    public void Speak () {
        System.out.println("ARRRRR! My health = " + health);
    }

}
