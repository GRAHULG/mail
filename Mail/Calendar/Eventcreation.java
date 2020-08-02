package Calendar;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Eventcreation 
{
	public static void main(String[] args ) throws IOException
	 
	 {
		 
		 System.setProperty("webdriver.chrome.driver","F:\\Selenium Java\\older1\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();

		 driver.navigate().to("https://outlook.live.com/owa/");
	     driver.manage().window().maximize();
		 

        Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\config.properties");

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
	    
	    
	    //Calender
	    
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@title='Calendar']"))).click();


Actions action = new Actions(driver);

driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

//Click Calender

List<WebElement> allDates=driver.findElements(By.xpath("//div[starts-with(@data-tabid,'surfaceMonthHeader')]"));


for(WebElement today:allDates)
	
{
	
String date=today.getText();

	
System.out.println(date);


if(date.contains("Jun 28"))
{
	
action.doubleClick(today).perform();

	
}
	
	
	

//EventCreation


//driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[ @type='text' and @placeholder='Add a title']"))).click();


//save

System.out.print("one");
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[ @name='Save']"))).click();



driver.close();
}



}
}




	


