package GroupingConcept;

import org.testng.annotations.Test;

public class prioritize {
  @Test(groups= {"smoke","sanity"})
  public void signUp() {
	  System.out.println("sign up");
  }
  @Test(groups= {"sanity","functional"})
  public void logIn() {
	  System.out.println("Login");
  }
  @Test(groups= {"regression"})
  public void Search() {
	  System.out.println(" search for --");
  } 
  @Test(groups= {"sanity","regression"})
  public void Bookit() {
	  System.out.println("Book the tickets");
  }
  @Test(groups= {"smoke","functional"})
  public void saveTheTickets() {
	  System.out.println("Save the tickets");
  }
  @Test
  public void logOut() {
	  System.out.println("Log out");
  }
}
