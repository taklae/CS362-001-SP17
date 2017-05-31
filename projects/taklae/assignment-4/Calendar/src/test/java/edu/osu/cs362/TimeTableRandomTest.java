package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"deleteAppt"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	/**
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void radnomtest()  throws Throwable {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed = 10;//System.currentTimeMillis();
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);

			for (int i = 0; i < NUM_TESTS; i++) {

				String methodName = TimeTableRandomTest.RandomSelectMethod(random);
				if (methodName.equals("deleteAppt")) {

					TimeTable timeTable = new TimeTable();
					LinkedList<Appt> appts = new LinkedList<Appt>();

					int numAppts = (int) ValuesGenerator.getRandomIntBetween(random, 0, 6);

					for (int j = 0; j < numAppts; j++) {

						int strtHour = (int) ValuesGenerator.getRandomIntBetween(random, -24, 24);

						appts.add(new Appt(strtHour,
								10,
								2,
								1,
								2017,
								"T",
								"D"));


					}

					int expectedSize = appts.size() - 1;
					if (expectedSize < 0)
						expectedSize = 0;

					int appt2Delete = (int) ValuesGenerator.getRandomIntBetween(random, 0, numAppts - 1);

					Appt deletedAppt;
					if (appts.size() != 0)
						deletedAppt = appts.get(appt2Delete);
					else
						deletedAppt = new Appt(1,
								1,
								1,
								1,
								2017,
								"T",
								"D");

					timeTable.deleteAppt(appts, deletedAppt);
					timeTable.deleteAppt(null, null);

					if (deletedAppt != null && deletedAppt.getValid())
						assertEquals(appts.size(), expectedSize);

				}
			}
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if ((iteration % 10000) == 0 && iteration != 0)
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			}


			System.out.println("Done testing...");
	}

}
