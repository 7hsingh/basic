package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 

public class LoginPage {
	 WebDriver driver;

	/*  WebElement email = driver.findElement(By.name("usernameInput"));
	 WebElement password = driver.findElement(By.name("password"));
	 WebElement signInButton = driver.findElement(By.id("signIn"));
	 WebElement emailErr = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	 WebElement passwordErr = driver.findElement(By.id("PasswordTextField__errors-password"));
	 WebElement globalErr = driver.findElement(By.id("globalError")); */
	 
	 //Page factory
	 @FindBy(name ="usernameInput")
	  public WebElement email;
	 
	 @FindBy(name ="password" )
	 public WebElement password ;
	
	 @FindBy(id ="signIn" )
	 public WebElement signInButton ;
	 
	 @FindBy(id ="UsernameTextField__errors-usernameInput" )
	 public WebElement emailErr ;
	 
	 @FindBy(id ="PasswordTextField__errors-password" )
	 public WebElement passwordErr ;
	 
	 @FindBy(id ="globalError" )
	 public WebElement globalErr ;
	
	 // we add file input stream here so we can read the browser values from the properties file 
	 public void openBrowser() throws IOException {
	FileInputStream fi = new FileInputStream("/Users/pardeeptank/Desktop/QA/selenium_workplace/BasicFramwork/prop.properties");
	Properties prop = new Properties();
	prop.load(fi);
     
	
	
	String browser = prop.getProperty("browser");
	
	if(browser.equalsIgnoreCase("Firefox")) {
     driver = new FirefoxDriver();
	}else if(browser.equalsIgnoreCase("Chrome")){
	driver = new ChromeDriver();
	}else{
	 driver = new SafariDriver();
	}
	
	PageFactory.initElements(driver, this);
	 }
	public void openLoginPage() {
		 driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=_W4qzdM7jow&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5nb29nbGUuY29tXC8iLCJvYXV0aF9rZXkiOiJfVzRxemRNN2pvdyIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNzEwMDIxNjkzLCJpYXQiOjE3MTAwMjA0OTMsImp0aSI6IjUyNTlkNTU3LWUyNDQtNDRkYS04YjI5LTM4NTMzMTc0ODYzNSIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.HlYrBdvdwG5QTBAytMSEHmTJJ700ujaJiU5EE93G3LHqPvFOF6C2utPPY4koQc7zPV8XIsEQ8tnjSj-p4n6faHy1ZB7sHudNKPx4iLw_b1wong177URibmOq0QMB1TkQt84Ulg-5wz8H9LgzPnIL1NWcWV5bmVd-6I6qsDvnA8lLhs0sm6cCU3dwaZUEXwcPtC0DOSTA3ckc9MY59Oix5y-yjSQ4p4qZJ8kEqMXmkasuDcy0KShvAr_fRXrSCgCgix6m8uegt0U23PPXZTWhQk-U3o6qYq28t0H8mZvMotZ2xnfl2yNj_8lKurBpVjTp4V3sGa5c--CafzLnZnZH1w&preferred_environment=");
	     driver.manage().window().maximize(); 
	  }
	public void closeBrowser() {
		driver.quit();
	}
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		//enter password
		password.sendKeys(b);
		//click login button
		signInButton.click();
		Thread.sleep(2000);
	
		}
    public String readEmailErr() {
		 String actualErr = emailErr.getText();
		 System.out.println(actualErr);
		return actualErr;
	}
	public String readPasswordErr() {
		 String actualErr = passwordErr.getText();
		 System.out.println(actualErr);
		return actualErr;
	}
   public String readGlobalErr() {
	   String actualErr = globalErr.getText();
	   System.out.println(actualErr);
	return actualErr;
	   
   }
}
