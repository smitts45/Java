package SuiteB;

import org.testng.annotations.Test;

public class TestB1 {
  @Test
  public void f() throws Exception {
	  System.out.println("Starting test B1");
	  Thread.sleep(3000);
	  System.out.println("Ending test B1");
  }
}
