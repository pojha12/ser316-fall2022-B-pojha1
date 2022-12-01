import org.junit.After;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.Math;
import static org.junit.Assert.*;

public class WhiteBoxGiven {
    @Before
    public void setUp() throws Exception {
    }
    @After
    public void tearDown() throws Exception {
    }

    // simple attack test with test of experience after attack
//    @Test
//    public void equalDP() {
//        Character wiz1 = new Wizard();
//        Character wiz2 = new Wizard();
//
//        GamePlay game = new GamePlay(wiz1, wiz2);
//        game.attack(wiz1, wiz2);
//
//        assertEquals(wiz1.experience, 7);
//        assertEquals(wiz2.experience, 7);
//    }
    public void dealDamageWB() {
        Character wiz1 = new Wizard();
        GamePlay game = new GamePlay(wiz1);
        wiz1.health=9;
        game.dealDamage(wiz1);
        assertTrue(wiz1.experience > 0);
    }
    
    @Test
    public void takeDamageTestHealth() {
        Character wiz1 = new Wizard();
        GamePlay game = new GamePlay(wiz1);
        int result = game.takeDamage(wiz1, 10);
        assertTrue(wiz1.health > 0);
    }
    @Test
    public void testPlay() {
        Character wiz1 = new Wizard();
        GamePlay game = new GamePlay(wiz1);
        int result = game.play();
        assertTrue(wiz1.experience > 0);
    }
    @Test
    public void checkLevelUp() {
        Character bar1 = new Barbarian();
        GamePlay game = new GamePlay(bar1);
        bar1.experience = 75;
        bar1.pointsPerLevel = 32;
        assertEquals(game.levelUp(bar1), false);
    }
    @Test
    public void checkLevelUp1() {
        Character bard1 = new Bard();
        GamePlay game = new GamePlay(bard1);
        bard1.experience = 95;
        bard1.pointsPerLevel = 92;
        assertEquals(game.levelUp(bard1), false);
    }
    @Test
    public void checkLevelUp2() {
        Character wiz1 = new Wizard();
        GamePlay game = new GamePlay(wiz1);
        wiz1.experience = 11;
        wiz1.pointsPerLevel = 11;
        game.levelUp(wiz1);
        assertEquals(wiz1.experience, 16);

    }  
    @Test
    public void checkLevelUp3() {
        Character dru1 = new Druid();
        Character ran1 = new Ranger();
        GamePlay game = new GamePlay(dru1,ran1);
        dru1.experience = 12;
        dru1.pointsPerLevel = 11;
        game.levelUp(dru1);
        game.levelUp(ran1);
        assertTrue(dru1.damage > 0);
    }
    @Test
    public void checkLevelUp4() {
        Character ranger1 = new Ranger();
        Character rog1 = new Rogue();
        GamePlay game = new GamePlay(ranger1,rog1);
        ranger1.experience = 12;
        ranger1.pointsPerLevel = 11;
        rog1.experience = 22;
        rog1.pointsPerLevel = 19;
        game.levelUp(ranger1);
        game.levelUp(rog1);
        assertEquals(ranger1.health < 100, rog1.health < 100 );
    }
}