package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {

		 	GregorianCalendar calendar = new GregorianCalendar();

	 		CalDay calDay = new CalDay(calendar);

	 		assertTrue(calDay.isValid());
	 		assertEquals(calendar.get(Calendar.MONTH),calDay.getMonth());
            assertEquals(calendar.get(Calendar.DAY_OF_MONTH),calDay.getDay());
            assertEquals(calendar.get(Calendar.YEAR),calDay.getYear());


     }

	@Test
	public void test02()  throws Throwable {

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.YEAR, 2017);

        Appt appt = new Appt(10,
                10,
                10,
                10,
                2018,
                "T",
                "D");

        Appt appt2 = new Appt(4,
                10,
                10,
                10,
                2018,
                "T",
                "D");

        CalDay calDay = new CalDay(calendar);
        calDay.addAppt(appt);
        calDay.addAppt(appt2);

        String calDayString = calDay.toString();
        String expectedCalDayString = "\t --- 1/1/2017 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t10/10/2018 at 4:10am ,T, D\n" +
                " \t10/10/2018 at 10:10am ,T, D\n" +
                " \n";

        assertEquals(2, calDay.getSizeAppts());
        assertEquals(expectedCalDayString, calDayString);


    }

    @Test
    public void test03()  throws Throwable {

        int apptCount = 0;

        GregorianCalendar calendar = new GregorianCalendar();
        CalDay calDay = new CalDay(calendar);

        Appt appt = new Appt(10,
                10,
                10,
                10,
                2018,
                "T",
                "D");

        calDay.addAppt(appt);
        calDay.addAppt(appt);

        Iterator<Appt> itr = (Iterator<Appt>)calDay.iterator();

        while(itr.hasNext()) {
            Object element = itr.next();
            apptCount += 1;
        }

        assertEquals(2,apptCount);
    }

    @Test
    public void test04()  throws Throwable {

        CalDay calDay = new CalDay();

        Iterator<Appt> itr = (Iterator<Appt>)calDay.iterator();

        assertEquals("",calDay.toString());
        assertEquals(null,itr);
    }
}
