package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DateTimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testToString() {
		
		DateTime datetime = new DateTime(2018, 10, 3, 0, 0);
		assertEquals("2018-10-03 00:00", datetime.toString());
	}

	@Test
	public void testDateTimeString() {
		
		DateTime datetime = new DateTime("2018-10-03 00:00");
		assertEquals("2018-10-03 00:00", datetime.toString());
		
	}

}
