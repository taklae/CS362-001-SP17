/*
 * This file was automatically generated by EvoSuite
 * Tue Apr 18 04:54:08 GMT 2017
 */


import org.junit.Test;
import static org.junit.Assert.*;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class project1_ESTest extends project1_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      String[] stringArray0 = new String[4];
      project1.main(stringArray0);
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      project1 project1_0 = new project1();
  }
}
