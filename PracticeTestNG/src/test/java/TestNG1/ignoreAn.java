package TestNG1;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ignoreAn {
  @Ignore
  @Test
  public void signUp() {
	  System.out.println("sign up");
  }
  @Ignore
  @Test
  public void logIn() {
	  System.out.println("Login");
  }
  @Test(priority=3)
  public void Search() {
	  System.out.println(" search for --");
  } 
  @Test(priority=4)
  public void Bookit() {
	  System.out.println("Book the tickets");
  }
  @Ignore
  @Test(priority=5)
  public void saveTheTickets() {
	  System.out.println("Save the tickets");
  }
  @Test(priority=6)
  public void logOut() {
	  System.out.println("Log out");
  }
}
