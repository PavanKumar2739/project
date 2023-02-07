package part2;

import org.testng.annotations.Test;

public class dependencies {
	 @Test(priority =2)
	  public void signUp() {
		 int i=1/0;
		  System.out.println("sign up");
	  }
	  @Test(priority =1,dependsOnMethods = "signUp",alwaysRun =true)
	  public void logIn() {
		  System.out.println("Login");
	  }
	  @Test(dependsOnMethods = {"logIn","signUp"})
	  public void Search() {
		  System.out.println(" search for --");
	  } 
	  @Test(dependsOnMethods = "Search")
	  public void Bookit() {
		  System.out.println("Book the tickets");
	  }
	  @Test(dependsOnMethods = "Bookit")
	  public void saveTheTickets() {
		  System.out.println("Save the tickets");
	  }
	  @Test(dependsOnMethods = "saveTheTickets")
	  public void logOut() {
		  System.out.println("Log out");
	  }

}
