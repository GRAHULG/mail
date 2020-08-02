package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class contactcreation 
{
	public static void main(String[] args) throws IOException
	 
	 {
		 
		


				 
				 
		 System.setProperty("webdriver.chrome.driver","F:\\Selenium Java\\older1\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();

		 driver.navigate().to("https://outlook.live.com/owa/");
       driver.manage().window().maximize();
		 
		 
       Properties prop = new Properties();
		 FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\bin\\config.properties");
      prop.load(fis);

      String mailname=prop.getProperty("Username");
      String mailpass=prop.getProperty("Password");
       // Login
       
		 WebElement element = driver.findElement(By.xpath("//*[text() = 'Sign in']"));
		 element.click();
				 
		 
		 WebDriverWait wait=new WebDriverWait(driver, 40);
		 
		 
		 //username
		 
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("i0116")));
		 WebElement Username= driver.findElement(By.id("i0116"));
	     Username.sendKeys(mailname);
	     wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9"))).click();



		
		//password
	     
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='passwd']")));
        WebElement Password= driver.findElement(By.xpath("//input[@name='passwd']"));
		Password.sendKeys(mailpass);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9"))).click();
	    		
	    
	    
	    //People
	    
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@title='People']"))).click();


//addnewcontact

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='Create new contact']"))).click();

		


wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='GivenName']")));



WebElement Contact=driver.findElement(By.xpath("//*[@id='GivenName']"));

Contact.sendKeys("abc");
		
//save

wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-log-name='ContactEditorSave']"))).click();

//*[@data-log-name='ContactEditorSave']

driver.close();
}


}





	


