import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DoyDateTest {

	DoyDate date, date2, date3, date4, date5, date6, date7;
	
	@Before
	public void setUp() throws Exception {
		date = new DoyDate(2013, 8, 17, 0);
		date2 = new DoyDate(2011, 8, 17, 0);
		date3 = new DoyDate(2013, 8, 18, 0);
		date4 = new DoyDate(2013, 2, 17, 0);
		date5 = new DoyDate(2013, 8, 1, 0);
		date6 = new DoyDate(2012, 1, 17, 0);
		date7 = new DoyDate(1970,1,1,0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAfter() {
		boolean testResult=false;
		
		testResult = date.after(date2) 
				& date3.after(date2) 
				& !date6.after(date5)
				& date4.after(date6);
		
		assertTrue(testResult);
	}

	@Test
	public final void testDiffWithYear() {
		boolean subTest1,subTest2, subTest3;
		subTest1 = date2.diffWithYear(date3)==2;
		subTest2 = date7.diffWithYear(date2)==41;
		subTest3 = date2.diffWithYear(date7)==41;		
		assertTrue(subTest1&subTest2&subTest3);
	}

}
