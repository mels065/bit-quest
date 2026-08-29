package test.java.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.java.actors.Hero;
import main.java.actors.Enemy;
import main.java.actors.Stats;

public class ActorTest {
    @Test
    void alterHp_reducesHealth() {
        Hero hero = new Hero("Hero", new Stats(100, 10, 5, 10)) {};
        hero.alterHp(-25);

        assertEquals(75, hero.getHp());
    }

    @Test
    void alterHp_neverGoesBelowZero() {
        Hero hero = new Hero("Hero", new Stats(100, 10, 5, 10)) {};
        hero.alterHp(-200);

        assertEquals(0, hero.getHp());
    }

    @Test
    void alterHp_normalConditionAtOrAbove20PercentHp() {
        Hero hero = new Hero("Hero", new Stats(100, 10, 5, 10)) {};
        hero.alterHp(-80);

        assertTrue(!hero.isCriticalCond() && !hero.isDead());
    }

    @Test
    void alterHp_criticalConditionBelow20PercentHp() {
        Hero hero = new Hero("Hero", new Stats(100, 10, 5, 10)) {};
        hero.alterHp(-81);

        assertTrue(hero.isCriticalCond());
    }

    @Test
    void alterHp_deadConditionAtZeroHp() {
        Hero hero = new Hero("Hero", new Stats(100, 10, 5, 10)) {};
        hero.alterHp(-100);

        assertTrue(hero.isDead());
    }

    @Test
    void attack_damagesEnemy() {
        Hero hero = new Hero("Hero", new Stats(100, 10, 5, 10)) {};
        Enemy enemy = new Enemy("Goblin", new Stats(100, 10, 5, 10)) {};
        hero.attack(enemy);

        assertEquals(92, enemy.getHp());
    }

    @Test
    void attack_damagesHero() {
        Hero hero = new Hero("Hero", new Stats(100, 10, 5, 10)) {};
        Enemy enemy = new Enemy("Goblin", new Stats(100, 10, 5, 10)) {};
        enemy.attack(hero);

        assertEquals(92, hero.getHp());
    }
}
