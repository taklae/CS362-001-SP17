package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

    @Test
    public void test01() throws Throwable {

        TimeTable timeTable = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();

        appts.add(new Appt(10,
                10,
                2,
                1,
                2017,
                "T",
                "D"));

        appts.add(new Appt(10,
                10,
                5,
                1,
                2017,
                "T",
                "D"));

        appts.add(new Appt(10,
                10,
                5,
                1,
                2018,
                "T",
                "D"));

        GregorianCalendar day1 = new GregorianCalendar();
        day1.set(2017, 1, 1);

        GregorianCalendar day2 = new GregorianCalendar();
        day2.set(2017, 1, 10);

        //Should throw an error
        LinkedList<CalDay> calDays = timeTable.getApptRange(appts, day1, day2);

        assertEquals(9, calDays.size());
        assertEquals(1, calDays.get(1).getSizeAppts());
        assertEquals(1, calDays.get(4).getSizeAppts());
    }

    @Test
    public void test02() throws Throwable {

        TimeTable timeTable = new TimeTable();
        LinkedList<Appt> appts = new LinkedList<Appt>();

        appts.add(new Appt(10,
                10,
                2,
                1,
                2017,
                "T",
                "D"));

        appts.add(new Appt(10,
                10,
                5,
                1,
                2017,
                "T",
                "D"));

        timeTable.deleteAppt(appts, appts.get(1));

        assertEquals(1, appts.size());
    }

    @Test
    public void test03() throws Throwable {

        TimeTable timeTable = new TimeTable();
        timeTable.deleteAppt(null, null);

    }
}