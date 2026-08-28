package actors;

public class Hero extends Actor {
    public Hero(String n, Stats stats) {
        super(n, stats);
    }

    public void attack(Enemy target) {
        super.attack(target);
    }
}
