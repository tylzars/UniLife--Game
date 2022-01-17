package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.model.UniLifeGame;

class UniLifeGameTest {
	UniLifeGame test_UniLifeGame;

	@BeforeEach
	void setUp() throws Exception {
		test_UniLifeGame = new UniLifeGame();
	}

	@AfterEach
	void tearDown() throws Exception {
		test_UniLifeGame = null;
	}

	@Test
	void testGameOver() {
		// Start game and do actions
		test_UniLifeGame.startGame();
		test_UniLifeGame.update();
		test_UniLifeGame.getFallingObjects();
		test_UniLifeGame.restart();
		
		boolean test = test_UniLifeGame.isGameOver();
		
		// Game is not over, so this should be false
		assertFalse(test);
	}
	
	@Test
	void testGameStarted() {
		// Start game and do actions
		test_UniLifeGame.startGame();
		test_UniLifeGame.update();
		test_UniLifeGame.getFallingObjects();
		test_UniLifeGame.restart();
		
		boolean test = test_UniLifeGame.hasStarted();
		
		// Game has started, so this should be true
		assertTrue(test);
	}
	
	@Test
	void differentGames() {
		// Make another game
		UniLifeGame test_UniLifeGame2 = new UniLifeGame();
		test_UniLifeGame2.startGame();
		test_UniLifeGame2.update();

		// Setup BeforeEach Game
		test_UniLifeGame.startGame();
		test_UniLifeGame.update();
		
		// Make sure if you launch multiple games, they are different
		assertNotSame(test_UniLifeGame, test_UniLifeGame2);
	}
	
	

}
