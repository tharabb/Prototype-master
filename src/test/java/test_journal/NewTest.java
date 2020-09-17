package test_journal;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
  public void f1() {
	  System.out.println("This is test method 1");
  }
  @Test
  public void f2() {
	  System.out.println("This is test method 2");
  }
  @Test
  public void f3() {
	  System.out.println("This is test method 3");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
	  
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }

}
