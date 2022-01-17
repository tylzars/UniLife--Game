package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.model.LifeBar;

class LifeBarTest {
	LifeBar test_LifeBar;
	
	/* 
	 * Setup & Teardown For Each Test
	 */
	@BeforeEach
	void setUp() throws Exception {
		test_LifeBar = new LifeBar();
	}

	@AfterEach
	void tearDown() throws Exception {
		test_LifeBar = null;
	}

	@Test
	void testDropLevel() {
		// Move the level down
		test_LifeBar.dropLevel();
		
		// Get level and set expected
		int actual = test_LifeBar.getLevel();		
		int expected = 79; 
		
		// Level drops by one starting at 80, check that they are equal
		assertEquals(actual, expected);
	}
	
	@Test
	void testAddLevel() {
		// Increase level over max
		test_LifeBar.increaseLevel();

		// Get level and set expected
		int actual = test_LifeBar.getLevel();
		int expected = 80; 
		
		// Value should not go over 80, therefore 80 should equal 80
		assertEquals(actual, expected);
	}
	
	@Test
	void testAddAfterDropLevel() {
		// Drop 20
		for(int i = 0; i < 20; i++) {
			test_LifeBar.dropLevel();
		}
		
		// Add 16 (2 per increase)
		for(int i = 0; i < 2; i++) {
			test_LifeBar.increaseLevel();
		}
		
		// Get level
		int actual = test_LifeBar.getLevel();
		
		// Expected
		int expected = 76; 
		
		assertEquals(actual, expected);
	}
	
	

}
