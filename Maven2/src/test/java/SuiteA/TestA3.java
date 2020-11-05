package SuiteA;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestA3 {
  @Test
  public void f() throws Exception {
	  System.out.println("Starting test A3");
	  Thread.sleep(3000);
	  System.out.println("Ending test A3");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
