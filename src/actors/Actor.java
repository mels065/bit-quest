package actors;

import java.util.Random;

enum ActorCondition {
    NORMAL,
    CRITICAL,
    DEAD
};

record Stats(
    int maxHp,
    int atk,
    int def,
    int speed
) {};

public abstract class Actor {
    private String name;
    private int maxHP;
    private int hp;
    private int atk;
    private int def;
    private int speed;
    private ActorCondition cond;

    public Actor(String n, Stats stats) {
        name = n;
        maxHP = stats.maxHp();
        hp = maxHP;
        atk = stats.atk();
        def = stats.def();
        speed = stats.speed();
        cond = ActorCondition.NORMAL;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getSpeed() {
        return speed;
    }

    public int alterHp(int mod) {
        if (mod > 0) {
            hp = Math.min(hp + mod, maxHP);
        } else {
            hp = Math.max(0, hp + mod);
        }

        updateCondition();

        return hp;
    }

    public void attack(Actor target) {
        int damage = atk - (target.def / 2);
        if (damage <= 0) {
            damage = new Random().nextInt(1);
        }

        target.alterHp(-damage);
    }

    public boolean isCriticalCond() {
        return cond == ActorCondition.CRITICAL;
    }

    public boolean isDead() {
        return cond == ActorCondition.DEAD;
    }

    private void updateCondition() {
        float ratio = hp / maxHP;

        if (ratio >= 0.2) {
            cond = ActorCondition.NORMAL;
        } else if (ratio < 0.2 && ratio > 0) {
            cond = ActorCondition.CRITICAL;
        } else {
            cond = ActorCondition.DEAD;
        }
    }
}
