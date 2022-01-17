package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.company.model.Student;

class StudentTest {
	// Global test student declaration
	private Student test_student;
	
	@BeforeEach
    public void setUp() {
		// Create a new student before every test
	    test_student = new Student();
    }
	
	/* 
	 * Test Left and Right Movement (Test to Pass)
	 */
	@Test
	public void testRight() {	    
	    int student_start_pos = test_student.getX();
	    
	    // Have student move right
	    test_student.moveRight();
	    int student_end_pos = test_student.getX();

	    // Movements are in increments of 10
	    assertEquals(student_start_pos+10, student_end_pos);
	}
	
	@Test
	public void testLeft() {
	    int student_start_pos = test_student.getX();
	    
	    // Have student move left
	    test_student.moveLeft();
	    int student_end_pos = test_student.getX();

	    // Movements are in increments of 10
	    assertEquals(student_start_pos-10, student_end_pos);
	}
	
	/* 
	 * Test Many Left and Right Movements (Test to Pass)
	 */
	@Test
	public void testManyRight() {
	    int student_start_pos = test_student.getX();
	    
	    // Have student move right 10 times
	    for(int i = 0; i < 10; i ++) {
	    	 test_student.moveRight();
	    }
	    
	    int student_end_pos = test_student.getX();

	    // Movements are in increments of 10
	    assertEquals(student_start_pos+100, student_end_pos);
	}
	
	@Test
	public void testManyLeft() {
	    int student_start_pos = test_student.getX();
	    
	    System.out.print(student_start_pos);

	    // Have student move left 10 times
	    for(int i = 0; i < 10; i ++) {
	    	 test_student.moveLeft();
	    }
	    
	    int student_end_pos = test_student.getX();
	    System.out.print(student_end_pos);

	    // Movements are in increments of 10
	    assertEquals(student_start_pos-100, student_end_pos);
	}
	
	/* 
	 * Test Extraneous Left and Right Movements (Test to Pass)
	 */
	@Test
	public void testExtraneousRight() {
	    int student_start_pos = test_student.getX();
	    
	    // Have student move right 10 times
	    for(int i = 0; i < 100; i ++) {
	    	 test_student.moveRight();
	    }
	    
	    int student_end_pos = test_student.getX();

	    // Since the student goes positive, the end position should be greater
	    assertTrue(student_start_pos<student_end_pos);
	}
	
	@Test
	public void testExtraneousLeft() {
	    int student_start_pos = test_student.getX();
	    
	    System.out.print(student_start_pos);

	    // Have student move left 10 times
	    for(int i = 0; i < 100; i ++) {
	    	 test_student.moveLeft();
	    }
	    
	    int student_end_pos = test_student.getX();
	    System.out.print(student_end_pos);

	    // Since the student goes negative, the end position should be smaller
	    assertTrue(student_start_pos>student_end_pos);
	}
	
	
	/*
	 * Testing Drunk Status
	 */
	@Test
	public void testIsDrunk() {
	    int student_start_pos = test_student.getX();
	    
	    test_student.changeDrunkStatus(true);
	    
	    // Have student move left 10 times
	    test_student.moveLeft();
	    
	    int student_end_pos = test_student.getX();
	    
	    // Since student is drunk, they should not move
	    assertTrue(student_start_pos == student_end_pos);
	}
	
	/* 
	 * Test coffee movement / status
	 */
	@Test
	public void testCoffeeMovement() {
	    int student_start_pos = test_student.getX();
	    
	    test_student.drinkCoffee();
	    
	    // Have student move right
	    test_student.moveRight();
	    
	    int student_end_pos = test_student.getX();

	    // Use assertNotEquals with same value as 1st test to show that coffee taken effect
	    assertNotEquals(student_start_pos+10, student_end_pos);
	}
	
	@Test
	public void testManyCoffeeMovements() {  
	    int student_start_pos = test_student.getX();
	    for(int i = 0; i < 50; i++) {
	    	// Have student drink coffee and move right (20)
	    	test_student.drinkCoffee();
		    test_student.moveRight();
		    
		    // Have student finish coffee and move left (10)
		    test_student.finishCoffee();
		    test_student.moveLeft();
	    }
	    
	    
	    int student_end_pos = test_student.getX();

	    // Use assertNotEquals with same value as 1st test to show that coffee taken effect
	    assertNotEquals(student_start_pos+500, student_end_pos);
	}

	/* 
	 * Test student creation not null
	 */
	@Test
	public void testCreation() {
	    // Check that students aren't created as null
		assertNotNull(test_student);
	}
	
	@AfterEach
    public void tearDown() {
        // Reset Test Student
		test_student = null;
    }
	
}
