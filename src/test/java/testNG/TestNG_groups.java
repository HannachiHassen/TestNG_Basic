package testNG;

import org.testng.annotations.Test;

public class TestNG_groups {
  @Test(groups = "it_department")
  public void java() {
	  System.out.println("I'm  a Java developer");
  }
  @Test(groups = "it_department")
  public void dot_net() {
	  System.out.println("I'm  a .Net developer");
  }
  @Test(groups="it_department")  
  public void tester()  
  {  
  System.out.println("I am a software tester");  
  }
  @Test(groups = "HR_department")
  public void hr() {
	  System.out.println("I'm HR");
  }
  @Test(dependsOnGroups = "HR_department")
  public void training() {
	  System.out.println("I depends on HR");
  }
}
