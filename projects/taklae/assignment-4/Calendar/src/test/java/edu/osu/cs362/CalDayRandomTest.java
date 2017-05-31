package edu.osu.cs362;


import org.junit.Test;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"addAppt"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	/**
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void radnomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed =10;//System.currentTimeMillis();
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);

			for (int i = 0; i < NUM_TESTS; i++) {

				String methodName = CalDayRandomTest.RandomSelectMethod(random);
				if (methodName.equals("addAppt")) {

					GregorianCalendar calendar = new GregorianCalendar();
					CalDay calDay = new CalDay(calendar);

					int numAppts = (int)ValuesGenerator.getRandomIntBetween(random,0,12);
					int validAppts = numAppts;
					for(int j = 0; j < numAppts; j++){

						int strtHour = (int)ValuesGenerator.getRandomIntBetween(random,-24,24);

						Appt appt = new Appt(strtHour,
								10,
								10,
								10,
								2018,
								"T",
								"D");

						calDay.addAppt(appt);
						if(!appt.getValid())
							validAppts -= 1;
					}

					Iterator<Appt> itr = (Iterator<Appt>)calDay.iterator();
					int apptCount = 0;

					while(itr.hasNext()) {
						Object element = itr.next();
						apptCount += 1;
					}

					String apptString = calDay.toString();

					assertEquals(validAppts,apptCount);
				}

			}

			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}


		System.out.println("Done testing...");
	}



}
