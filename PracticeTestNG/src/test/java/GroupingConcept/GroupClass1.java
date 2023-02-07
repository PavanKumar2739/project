package GroupingConcept;

import org.testng.annotations.Test;
@Test(groups="all")
public class GroupClass1 {
  @Test(groups= {"smoke"})
  public void Test1() {
	  System.out.println("Test1");
  }
  @Test(groups= {"regression","smoke"})
  public void Test2() {
	  System.out.println("Test2");
  }
  @Test(groups= {"functional","regression"})
  public void Test3() {
	  System.out.println("Test3");
  }
  @Test(groups= {"functional","smoke"})
  public void Test4() {
	  System.out.println("Test4");
  }
  @Test(groups= {"smoke"})
  public void Test5() {
	  System.out.println("Test5");
  }
  @Test(groups= {"regression","regression"})
  public void Test6() {
	  System.out.println("Test6");
  }
}
