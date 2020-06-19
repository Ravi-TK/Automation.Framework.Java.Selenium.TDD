package qa.Tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestInitaliser {
	
	@BeforeTest
	public void setup()
	{
		System.out.println("*******Before Test********");
	}
	
	
	@AfterTest
	public void after(ITestContext context)
	{
		//System.out.println(context.);
		System.out.println("**********after Test******  ");
	}
	

}
