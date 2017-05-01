package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }

	@Test
	public void test02()  throws Throwable {

		Appt appt = new Appt(0,
				0 ,
				0 ,
				0,
				0 ,
				"",
				"");

		appt.setStartHour(-1);
		appt.setStartMinute(-1);
		appt.setStartDay(0);
		appt.setStartMonth(0);
		appt.setStartYear(2017);
		appt.setTitle("Birthday Party");
		appt.setDescription("This is my birthday party.");

		// assertions
		assertFalse(appt.getValid());
		assertEquals(-1, appt.getStartHour());
		assertEquals(-1, appt.getStartMinute());
		assertEquals(0, appt.getStartDay());
		assertEquals(0, appt.getStartMonth());
		assertEquals(2017, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());

	}

    @Test
    public void test03()  throws Throwable {

        Appt appt = new Appt(0,
                0 ,
                0 ,
                0,
                0 ,
                "",
                "");

        appt.setStartHour(0);
        appt.setStartMinute(0);
        appt.setStartDay(1);
        appt.setStartMonth(1);
        appt.setStartYear(2017);
        appt.setTitle("Birthday Party");
        appt.setDescription("This is my birthday party.");

        String fun = appt.toString();

        assertEquals("\t1/1/2017 at 12:0am ,Birthday Party, This is my birthday party.\n",appt.toString());
    }

    @Test
    public void test04()  throws Throwable {

        Appt appt = new Appt(-1,
                1,
                1,
                1,
                0 ,
                null,
                null);

        // assertions
        assertFalse(appt.getValid());

    }

    @Test
    public void test05()  throws Throwable {

        Appt appt = new Appt(200,
                1,
                1,
                1,
                0 ,
                null,
                null);

        // assertions
        assertFalse(appt.getValid());

    }

    @Test
    public void test06()  throws Throwable {

        Appt appt = new Appt(1,
                -1,
                1,
                1,
                0 ,
                null,
                null);

        // assertions
        assertFalse(appt.getValid());

    }

    @Test
    public void test07()  throws Throwable {

        Appt appt = new Appt(1,
                200,
                1,
                1,
                0 ,
                null,
                null);

        // assertions
        assertFalse(appt.getValid());

    }

    @Test
    public void test08()  throws Throwable {

        Appt appt = new Appt(1,
                1,
                -1,
                1,
                0 ,
                null,
                null);

        // assertions
        assertFalse(appt.getValid());

    }

    @Test
    public void test09()  throws Throwable {

        Appt appt = new Appt(1,
                1,
                200,
                1,
                0 ,
                null,
                null);

        // assertions
        assertFalse(appt.getValid());

    }
}
