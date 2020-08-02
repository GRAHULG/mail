package Composeemail;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Calendar.Eventcreation;

public class Emailcreation extends Eventcreation
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

		 
	    
	    //NewMessage
	    
	     wait.until(ExpectedConditions.elementToBeClickable(By.id("id__3"))).click();
	     
	     driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

	     
	     //To
	   driver.findElement(By.xpath("//*[@autocapitalize='off' and @autocomplete='off']")).sendKeys("grahulcse@gmail.com");
	     
	     
//Subject
	    WebElement Subject= driver.findElement(By.xpath("//*[@type='text']"));
	   Subject.sendKeys("test");

	  //body
	   
	   WebElement body= driver.findElement(By.xpath("//*[@role='textbox' and @aria-label='Message body']"));
	   body.sendKeys("mail");
	   
//send
	   
	   
	   driver.findElement(By.xpath("//*[@type='button' and @aria-label='Send']")).click();
		
    //Printing page title
    System.out.println(driver.getTitle());
    
    driver.close();

	}
}
