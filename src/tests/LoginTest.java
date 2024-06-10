package tests;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;


public class LoginTest {
 
	LoginPage lp = new LoginPage();
    DataFile df = new DataFile();
    
  @BeforeMethod
  public void beforeMethod() throws InterruptedException, IOException {
	// open firefox
  //open scotiabank loginpage
	 lp.openBrowser();
	 lp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
    lp.closeBrowser();
	// close browser
	  
  }
@Test(priority = 1)
public void loginWithSpecialCharUserNameTest() throws InterruptedException {
      lp.login(df.emailwithspecialchar,df.wrongpass);
	  Assert.assertEquals(lp.readEmailErr(), df.specialcharErr);
}
@Test(priority = 2)
public void loginWithEmptyUserNameTest() throws InterruptedException {
	lp.login("",df.wrongpass);
	Assert.assertEquals(lp.readEmailErr(), df.emptyEmailErr);
}
@Test(priority = 3)
public void loginWithEmptyPasswordTest() throws InterruptedException {
      lp.login(df.wrongemail,"");
	//verify error messsage
      Assert.assertEquals(lp.readPasswordErr(), df.emptyPasswordErr);
}
@Test(priority = 4)
public void loginWithWrongEmailPassword() throws InterruptedException {
      lp.login(df.wrongemail,df.wrongpass);
	//verify error messsage
	Assert.assertEquals(lp.readGlobalErr(), df.globalErr);
}
}