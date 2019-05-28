import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

class MyTests {
	


	@Test
	void Test1() {
		Background backgroundTest = new Background("ProjectPics/Stick.png");
		assertEquals("ProjectPics/Stick.png", backgroundTest.picFile, "The postion should be 0" );
	}
	
	@Test
	void Test2() {
		Controller controllerTest = new Controller();
		assertEquals(GameState.STARTMENU, controllerTest.getGS(), "The postion should be 0" );
	}
	
	@Test
	void Test3() {	
		Controller controllerTest = new Controller();
		controllerTest.setGS(GameState.FOODGAME);
		assertEquals(GameState.FOODGAME, controllerTest.getGS(), "The postion should be 0" );
	}
	//Stick class also tested here
	@Test
	void Test4() {
		DropBird dropBirdTest = new DropBird("ProjectPics/ClapperRail.png", "dropBird", 1080);
		dropBirdTest.dropStick();
		assertEquals(1,dropBirdTest.droppedSticks , "The number of dropped sticks should be 1" );
	}
	
	@Test
	void Test5() {
		DropBird dropBirdTest = new DropBird("ProjectPics/ClapperRail.png", "dropBird", 1080);
		dropBirdTest.dropStick();
		assertTrue(0 < dropBirdTest.stickList.size() , "Sticklist size should be 1" );
		System.out.println(dropBirdTest.stickList.size() );
	}
	
	@Test
	void Test6() {
		DropBird dropBirdTest = new DropBird("ProjectPics/ClapperRail.png", "dropBird", 1080);
		dropBirdTest.dropStick();
		assertEquals(dropBirdTest.xPos ,dropBirdTest.stickList.getLast().xPos , "xPos should be equal" );
	}
	
	@Test
	void Test7() {
		DropBird dropBirdTest = new DropBird("ProjectPics/ClapperRail.png", "dropBird", 1080);
		dropBirdTest.dropStick();
		int oldXPos = dropBirdTest.xPos;
		dropBirdTest.move(520, 1080, 9);
		assertEquals(9 ,dropBirdTest.sticksAvalible, "sticksAvalible should be 9" );
	}
	
	@Test
	void Test8() {
		DropBird dropBirdTest = new DropBird("ProjectPics/ClapperRail.png", "dropBird", 1080);
		dropBirdTest.dropStick();
		int oldXPos = dropBirdTest.xPos;
		dropBirdTest.move(520, 1080, 9);
		assertFalse(dropBirdTest.xPos == oldXPos  , "the dropBird should have incremented" );
	}
	
	@Test
	void Test9() {
		Stick testStick = new Stick(10, 10, 1080);
		testStick.release(10,  200 , 500, 0);
		assertEquals( testStick.isFalling, true, "The stick should be falling" );
	}
	
	@Test
	void Test10() {
		Stick testStick = new Stick(10, 10, 1080);
		testStick.release(10,  200 , 500, 0);
		testStick.setIsFalling(false);
		int oldYPos = testStick.yPos;
		LinkedList<Stick> stickList = new LinkedList<Stick>();
		testStick.move(stickList);
		assertEquals(testStick.yPos , oldYPos, "The stick should not be falling" );
	}
	
	@Test
	void Test11() {
		ModelFoodGame foodTest = new ModelFoodGame(500, 1000, GameState.FOODGAME);
		assertEquals(ModelFoodGame.getScore() , 0, "Score should be set to zero");
	}
	
	@Test
	void Test12() {
		ModelFoodGame foodTest = new ModelFoodGame(500, 1000, GameState.FOODGAME);
		ArrayList<GameObject> testList = foodTest.getObjects();
		assertTrue(testList.size() > 0, "The list should contain objects");
	}
	
	@Test
	void Test13() {
		ModelFoodGame foodTest = new ModelFoodGame(500, 1000, GameState.FOODGAME);
		ArrayList<GameObject> testList = foodTest.getObjects();
		int testTime = foodTest.getTime();
		foodTest.update(GameState.FOODGAME );
		assertTrue(testTime > foodTest.getTime());
	}
	
	@Test
	void Test14() {
		PlayableBird mainBird = new PlayableBird("ProjectPics/ClapperRail.png", "Clappy");
		mainBird.spacePressed = true;
		int oldYPosMainBird = mainBird.yPos;
		mainBird.move(1080);
		assertFalse( mainBird.yPos == oldYPosMainBird );
	}
	
	@Test 
	void Test15() {
		ModelNestGame nestTest = new ModelNestGame(800, 1080, GameState.NESTGAME);
		int oldXPos = nestTest.getDropBird().xPos;
		nestTest.update(GameState.NESTGAME);
		assertFalse(oldXPos == nestTest.getDropBird().xPos);
	}
	
	@Test
	void Test16() {
		ModelNestGame nestTest = new ModelNestGame(800, 1080, GameState.NESTGAME);
		ArrayList<GameObject> birdList = nestTest.getObjects();
		DropBird dropBird = null;
		for(GameObject o : birdList) {
    		dropBird = (DropBird) o;
    	}
		assertEquals(dropBird , nestTest.getDropBird());
	}
}

