package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;


import com.company.model.FallingObject;
import com.company.model.FallingObjectType;

class FallingObjectTest {
	 FallingObject test_FallingObject;
	 public static final int WIDTH = 800;
	 public static final int HEIGHT = 600;
	 public static final int BORDER = 25; //TODO

	
	@BeforeEach
	void setUp() throws Exception {
	    Random rand = new Random();
	    
	    int random1 = rand.nextInt(4);

		int rand_xpos = rand.nextInt(WIDTH - 2*BORDER) + BORDER;

        test_FallingObject = new FallingObject(FallingObjectType.values()[random1], rand_xpos);
	}

	@AfterEach
	void tearDown() throws Exception {
		test_FallingObject = null;
	}

	/* 
	 * Test Collecting Falling Objects
	 */
	@Test
	void testCollection() {
		// Collect object and make check if its collected
		test_FallingObject.setCollected();
		boolean actual = test_FallingObject.isCollected();
		
		// If we collected object, isCollected should be true
		assertTrue(actual);
		
		
	}
	
	/* 
	 * Test If An Object Falls
	 */
	@Test
	void testFall() {
		// Make object fall and get position
		test_FallingObject.fall();	
		int y = test_FallingObject.getY();
		
		// Test Y only as height doesn't change (object spawns at 0)
		assertTrue(y > 0);
	}
	
	/* 
	 * Test If An Object Is Null
	 */
	@Test
	void testNullCreation() {
		// Make object with null 'item' to fall
        test_FallingObject = new FallingObject(null, 2);
        FallingObjectType x = test_FallingObject.getType();
        
		// The type should still be null
		assertNull(x);
	}

}

// Excess Code
//System.out.print(test_FallingObject.getType());
