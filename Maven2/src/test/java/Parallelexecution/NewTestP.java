package Parallelexecution;

import org.testng.annotations.Test;

public class NewTestP {
  @Test
  public void testing1()
  {
	  System.out.println("I am test 1"+ Thread.currentThread().getId());
  }
  @Test
  public void testing2() 
  {
	  System.out.println("I am test 2" + Thread.currentThread().getId());
  }
  
}
