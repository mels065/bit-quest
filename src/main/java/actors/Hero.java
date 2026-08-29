package main.java.actors;

public class Hero extends Actor<Enemy> {
    public Hero(String n, Stats stats) {
        super(n, stats);
    }

    @Override
    public void attack(Enemy target) {
        super.attack(target);
    }
}
