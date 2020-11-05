package Parallelexecution;

import java.util.Arrays;

import org.testng.TestNG;

public class RunSuitParallel {
	
	public static void main(String[] args) 
	{
		
		TestNG obj= new TestNG();
		obj.setTestSuites(Arrays.asList(new String[] {System.getProperty("user.dir")+ "//MegasuitAB1.xml"}));
		obj.setSuiteThreadPoolSize(2);
		obj.run();
	}

}
