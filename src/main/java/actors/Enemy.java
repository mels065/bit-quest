package main.java.actors;

public class Enemy extends Actor<Hero> {
    public Enemy(String n, Stats stats) {
        super(n, stats);
    }

    @Override
    public void attack(Hero target) {
        super.attack(target);
    }
}
