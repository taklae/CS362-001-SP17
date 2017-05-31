package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=500;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription", "isValid"};// The list of the of methods to be tested in the Appt class

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

					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);

						   if(newTitle!=null)
						       assertEquals(appt.getTitle(),newTitle);

						}
						else if(methodName.equals("setDescription")){
					   		String newDesc=(String) ValuesGenerator.getString(random);
					   		appt.setDescription(newDesc);

					   		if(newDesc!=null)
					   		    assertEquals(appt.getDescription(),newDesc);
						}
						else if(methodName.equals("isValid")){

						    int strtDay = (int)ValuesGenerator.getRandomIntBetween(random,-62,62);
                            int strtHour = (int)ValuesGenerator.getRandomIntBetween(random,-26,26);
                            int strtMonth = (int)ValuesGenerator.getRandomIntBetween(random,-24,24);
                            int strtYear = (int)ValuesGenerator.getRandomIntBetween(random,-120,120);

							appt.setStartHour(strtHour);
						    appt.setStartMinute(strtYear);
						    appt.setStartDay(strtDay);
						    appt.setStartMonth(strtMonth);

						    if(appt.getValid()) {
                                assertEquals(appt.getStartDay(), strtDay);
                                assertEquals(appt.getStartHour(), strtHour);
                                assertEquals(appt.getStartMonth(), strtMonth);
                                assertEquals(appt.getStartYear(), strtYear);
                            }

					   }
				}
				
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 
			}
	 
	 
		 System.out.println("Done testing...");
	 }


	
}
