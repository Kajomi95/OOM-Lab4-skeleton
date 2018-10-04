package se.ju.csi.oom.lab4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class TimeZoneTranslatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testShiftTimeZone() {
		
		DateTime LectureStart = new DateTime(2018, 8, 27, 8, 0);

		LectureStart = TimeZoneTranslator.shiftTimeZone(LectureStart, TimeZone.ALASKA.getOffset(), TimeZone.US_PACIFIC.getOffset());
		
		assertEquals("2018-08-27 09:00", LectureStart.toString());
	}

	@Test
	public void testShiftEventTimeZone() {
		
		DateTime SchoolStart = new DateTime(2018, 8, 27, 8, 0);
		DateTime SchoolEnds = new DateTime(2018, 8, 27, 16, 45);
		Person jonathan = new Person("Jonathan Karlsson");
		Place jth = new Place("JTH", 57.7785672,14.1614833,20.0);
		Event school = new Event("One day at JU", SchoolStart, SchoolEnds, new HashSet<>(Arrays.asList(jonathan)), jth);
		
		school = TimeZoneTranslator.shiftEventTimeZone(school, TimeZone.ALASKA, TimeZone.US_PACIFIC);
		
		assertEquals("2018-08-27 09:00", school.getStartDate().toString());
		assertEquals("2018-08-27 17:45", school.getEndDate().toString());
	}
	
	@Test
	public void testShiftTimeZone2()
	{
		DateTime date = new DateTime(2016,1,1,6,0);
		DateTime date2 = TimeZoneTranslator.shiftTimeZone(date, TimeZone.CENTRAL_EUROPEAN_TIME.getOffset(), TimeZone.US_PACIFIC.getOffset());
		System.out.print(date2.toString());
		assertEquals("2015-12-31 21:00",date2.toString());
	}

}
