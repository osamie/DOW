import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DoyDateTest {

	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAfter() {
		boolean testResult=false;
		
		DoyDate date = new DoyDate(2013, 8, 17, 0);
		DoyDate date2 = new DoyDate(2011, 8, 17, 0);
		DoyDate date3 = new DoyDate(2013, 8, 18, 0);
		DoyDate date4 = new DoyDate(2013, 2, 17, 0);
		DoyDate date5 = new DoyDate(2013, 8, 1, 0);
		DoyDate date6 = new DoyDate(2012, 1, 17, 0);
		
		testResult = date.after(date2) 
				& date3.after(date2) 
				& !date6.after(date5)
				& date4.after(date6);
		
		assertTrue(testResult);
	}

	@Test
	public final void testDiffWithYear() {
		fail("Not yet implemented"); // TODO
	}

}
