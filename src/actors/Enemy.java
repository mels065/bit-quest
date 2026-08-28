package actors;

public class Enemy extends Actor {
    Enemy(String n, Stats stats) {
        super(n, stats);
    }

    public void attack(Hero target) {
        super.attack(target);
    }
}
