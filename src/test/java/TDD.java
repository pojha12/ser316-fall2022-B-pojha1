import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.lang.Math;
import static org.junit.Assert.*;

public class TDD {
	double diff;
  int diff1;
	GamePlay game1;
	GamePlay test1;
	GamePlay test2;
	GamePlay test3;
	GamePlay test4;
	GamePlay test5;
	
	@org.junit.Before
    public void setUp() throws Exception {
    }
//	
//	@Test
//	public void test1dealDamageNormal() 
//	{
//		Character wiz1 = new Wizard();
//		test1 = new GamePlay(wiz1);
//		int answer = test1.dealDamage(wiz1);
//		assertTrue(answer > 0);
//	}
//
//
	  @Test
	  public void test2dealDamageNormal() 
	  {
	      Character wiz1 = new Wizard();
	      test2 = new GamePlay(wiz1);
	      wiz1.health = 0;
	      int result = test2.dealDamage(wiz1);
	      assertEquals(wiz1.experience, 0);
	  }
//
	  @Test
	  public void takeDamageTestHealth() {
	      Character wiz1 = new Wizard();
	      test3 = new GamePlay(wiz1);
	      int result = test3.takeDamage(wiz1, 10);
	      assertTrue(wiz1.health > 0);
	  }
	  @Test
	  public void takeDamageTestHealth2() {
	      Character wiz1 = new Wizard();
	      test3 = new GamePlay(wiz1);
	      wiz1.protection = 11;
	      int result = test3.takeDamage(wiz1, 10);
	      assertEquals(wiz1.experience, 0);
	  }
	  @Test
	  public void takeDamageTestCheckCondition() {
	    Character wiz = new Wizard();
	      test3 = new GamePlay(wiz);
	      wiz.protection = 33;
	      wiz.health = -1 ;
	      int result = test3.takeDamage(wiz, 5);
	      assertTrue(wiz.health < 0);
	  }
  
//  @Test
//  public void takeDamageTestExp() {
//     Character wiz = new Wizard();
//     test3 = new GamePlay(wiz);
//     int result = test3.takeDamage(wiz, 10);
//      wiz.protection= 14;
//      assertFalse(wiz.health < 0);
//  }
//  @Test
//  public void takeDamageTest3() {
//	Character wiz = new Wizard();
//    test3 = new GamePlay(wiz);
//    test3.takeDamage(wiz, 10);
//     wiz.protection = 15;
//          diff = (wiz.protection - 10) / 2;
//      assertEquals( diff % 1 , 0.5);
//  }
//
  @Test
  public void takeDamageTestdiff() {
      Character wiz = new Wizard();
      test3 = new GamePlay(wiz);
      wiz.protection = 15;
      test3.takeDamage(wiz, 14);
      assertFalse( ((wiz.protection - 14)/2 %1) == 0.5);
  }
////
//
////
  @Test
  public void takeDamageTestLess() {
      Character wiz = new Wizard();
      test3 = new GamePlay(wiz);
      wiz.experience = 6;
      wiz.health = 9;
      test3.takeDamage(wiz, 2);
      assertTrue(wiz.experience < wiz.health);
  }
////
  @Test
  public void takeDamageTestSame() {
	  Character wiz = new Wizard();
      test3 = new GamePlay(wiz);
      test3.takeDamage(wiz, 8);
      wiz.experience = 6;
      wiz.health = 6;
      assertEquals(wiz.experience, wiz.health);
  }
////
  @Test
  public void attackTestWizDru() {
	  Character wiz = new Wizard();
      Character dru = new Druid();
      test1 = new GamePlay();
      wiz.health = 32;
      test1.attack(wiz, dru);
      //assertTrue(game.levelUp(wiz));//fail
      assertFalse(test1.levelUp(wiz));
      }
  
////
////
  @Test
  public void attackTestHealthWiz() {
	  Character wiz = new Wizard();
      Character dru = new Druid();
      test1 = new GamePlay();
      wiz.health = 1;
      dru.health = 12;
      test1.attack(dru, wiz);
          //assertTrue(wiz.health < 0);
          assertTrue(wiz.health> 0);
      }
  

      @Test
      public void attackTestHealthDru () {
    	  Character wiz = new Wizard();
    	  Character dru = new Druid();
    	  test3 = new GamePlay(dru,wiz);
    	  wiz.health = 10;
    	  dru.health = 1;
          test3.attack(dru, wiz);
          assertTrue(wiz.health > 0);
      }

      @Test
      public void attackTestHealthcheckLevelUp () {
          Character wiz = new Wizard();
          Character dru = new Druid();
          test1 = new GamePlay();
          wiz.health = 10;
          dru.health = -11;
          test1.attack(wiz, dru);
          assertEquals(test1.levelUp(wiz),false);
          }
     
      @Test
      public void attackTestHealthDru2() {
    	  Character wiz = new Wizard();
    	  Character dru = new Druid();
    	  test1 = new GamePlay();
    	  wiz.health = 0;
          dru.health = 0;
          test1.attack(wiz, dru);
          assertEquals(test1.levelUp(wiz),false);
      }
      
}