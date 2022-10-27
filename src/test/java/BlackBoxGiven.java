import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.lang.Math;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {
    double diff;
    int diff1;

    private Class<GamePlay> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<GamePlay>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
                {GamePlay1.class},
                {GamePlay2.class},
                {GamePlay3.class},
                {GamePlay4.class},
                {GamePlay5.class}
        };
        return Arrays.asList(classes);
    }

    private GamePlay createGame() throws Exception {
        Constructor<GamePlay> constructor = classUnderTest.getConstructor();
        return constructor.newInstance();
    }

    GamePlay game;

    @org.junit.Before
    public void setUp() throws Exception {
        game = createGame();
    }


    // normal experience when healthy
    @Test
    public void dealtDamageNormalExperience() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();
        Bard bard = new Bard();
        Druid dru = new Druid();
        Ranger ran = new Ranger();
        Rogue ro = new Rogue();

        game.dealDamage(wiz);
        assertEquals(wiz.experience, 5);

        game.dealDamage(bar);
        assertEquals(bar.experience, 10);

        game.dealDamage(bard);
        assertEquals(bard.experience, 6);

        game.dealDamage(dru);
        assertEquals(dru.experience, 7);

        game.dealDamage(ran);
        assertEquals(ran.experience, 8);

        game.dealDamage(ro);
        assertEquals(ro.experience, 5);

        game.dealDamage(wiz);
        assertTrue(wiz.health < 0);

        game.dealDamage(wiz);
        assertEquals(wiz.health, 0);

    }

    @Test
    public void dealDamageHealth() {
        Wizard wiz = new Wizard();
        game.dealDamage(wiz);
        assertTrue(wiz.health > 0);
    }

    @Test
    public void dealDamageHealth1() {
        Wizard wiz = new Wizard();
        game.dealDamage(wiz);
        wiz.health = 3;
        assertTrue(wiz.health < 10);

    }

    @Test
    public void takeDamageTestHealth() {
        Wizard wiz = new Wizard();
    //    double diff;
    //    int diff1 = 0;
        game.takeDamage(wiz, 10);
        wiz.protection= 14;
        if (wiz.protection > 10) {
            diff = (wiz.protection - 10);
            if ((diff / 2) % 1 == 0.5) {
                diff1 = (int) Math.floor(diff);
            }
        }
        wiz.experience = diff1;
        wiz.health = wiz.health + (int) (diff / 2);
        assertTrue(wiz.health > 0);
    }
    @Test
    public void takeDamageTestExp() {
        Wizard wiz = new Wizard();
        //    double diff;
        //    int diff1 = 0;
        game.takeDamage(wiz, 10);
        wiz.protection= 14;
        if (wiz.protection > 10) {
            diff = (wiz.protection - 10);
            if ((diff / 2) % 1 == 0.5) {
                diff1 = (int) Math.floor(diff);
            }
        }
        wiz.experience = diff1;
        wiz.health = wiz.health + (int) (diff / 2);
        assertTrue(wiz.experience < 0);
    }
    @Test
    public void takeDamageTest3() {
        Wizard wiz = new Wizard();
   //     double diff;
  //      int diff1 = 0;
        game.takeDamage(wiz, 10);
        wiz.protection = 14;
        if (wiz.protection > 10) {
            diff = (wiz.protection - 10) / 2;
            if (diff % 1 == 0.5) {
                diff1 = (int) Math.floor(diff);
            }
        }
        wiz.experience = diff1;
        wiz.health = wiz.health + (int) (diff / 2.0);
        assertEquals(diff, 0.5);//fail
    }

    @Test
    public void takeDamageTestdiff() {
        Wizard wiz = new Wizard();
        game.takeDamage(wiz, 10);
        wiz.protection = 15;
        if (wiz.protection <= 10) {
            diff = (wiz.protection - 10) / 2;
            if (diff % 1 == 0.5) {
                diff1 = (int) Math.floor(diff);
            }
        }
        wiz.experience = diff1;
        wiz.health = wiz.health - (wiz.protection - 10);
        assertEquals(diff1, 0.5);
    }

    @Test
    public void takeDamageTestCheckCondition() {
        Wizard wiz = new Wizard();
        game.takeDamage(wiz, 5);
        wiz.experience = 9;
        wiz.health = 6;
        assertTrue(wiz.experience > wiz.health);
    }

    @Test
    public void takeDamageTestLess() {
        Wizard wiz = new Wizard();
        game.takeDamage(wiz, 5);
        wiz.experience = 6;
        wiz.health = 9;
        assertTrue(wiz.experience < wiz.health);
    }

    @Test
    public void takeDamageTestSame() {
        Wizard wiz = new Wizard();
        game.takeDamage(wiz, 8);
        wiz.experience = 6;
        wiz.health = 6;
        assertEquals(wiz.experience, wiz.health);
    }

    @Test
    public void attackTestWizDru() {
        Wizard wiz = new Wizard();
        Druid dru = new Druid();
        game.attack(wiz, dru);
        wiz.health = 20;
        dru.health = 27;
        if (wiz.health > 0 && dru.health > 0) {
            //game.attack(wiz, dru);
            int dd = game.dealDamage(wiz);
            int td = game.takeDamage(dru, 8);
            if (wiz.health > 0 && dru.health > 0) {
                game.levelUp(wiz);
                game.levelUp(dru);
            }
            assertTrue(game.levelUp(wiz));//fail
            assertTrue(game.levelUp(dru));
        }
    }


    @Test
    public void attackTestHealthWiz() {
        Wizard wiz = new Wizard();
        Druid dru = new Druid();
        game.attack(dru, wiz);
        wiz.health = 1;
        dru.health = 12;
        if (wiz.health > 0 && dru.health > 0) {
            //game.attack(dru, wiz);
            int dd = game.dealDamage(dru);
            int td = game.takeDamage(wiz, 8);
            if (wiz.health > 0 && dru.health > 0) {
                game.levelUp(wiz);
                game.levelUp(dru);
            }
            //assertTrue(wiz.health < 0);
            assertEquals(wiz.health, 0);
        }
    }

        @Test
        public void attackTestHealthDru () {
            Wizard wiz = new Wizard();
            Druid dru = new Druid();
            game.attack(dru, wiz);
            wiz.health = 12;
            dru.health = 11;
            if (wiz.health > 0 && dru.health > 0) {
                //game.attack(dru, wiz);
                int dd = game.dealDamage(dru);
                int td = game.takeDamage(wiz, 8);
            }
            assertTrue(dru.health > 0);
        }

        @Test
        public void attackTestHealthWiz1 () {
            Wizard wiz = new Wizard();
            Druid dru = new Druid();
            game.attack(dru, wiz);
            wiz.health = 0;
            dru.health = 11;
            if (wiz.health > 0 && dru.health > 0) {
                int dd = game.dealDamage(dru);
                int td = game.takeDamage(wiz, 8);
                if (wiz.health > 0 && dru.health > 0) {
                    game.levelUp(wiz);
                    game.levelUp(dru);
                }
                assertEquals(wiz.health, 0);
            }
        }
}


