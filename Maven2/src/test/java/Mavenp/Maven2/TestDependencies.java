package Mavenp.Maven2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestDependencies {
 
	 @Test (priority=2,dependsOnMethods="blue")
	  public void red() {
		 System.out.println("Red");
		// Assert.fail("Red test failed");
	  }
	 @Test (priority=3,dependsOnMethods="red")
	  public void white() {
		 System.out.println("White");
		 throw new SkipException("white is skipped");
	  }
	 @Test (priority=1)
	  public void blue() {
		 System.out.println("Blue");
	  }
	 @Test (priority=4,dependsOnMethods="white")
	  public void stars() {
		 System.out.println("Stars");
		
	 }
	 
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
