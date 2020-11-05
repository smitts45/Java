package SuiteA;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestA2 {
  @Test
  public void f() throws Exception {
	  System.out.println("Starting test A2");
	  Thread.sleep(3000);
	  System.out.println("Ending test A2");
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
