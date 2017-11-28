package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:1337/");
		
		signUp(driver);
		negSignUp(driver);
		
		
		driver.findElement(By.id("emailInput")).sendKeys("samhita@gmail.com");
		driver.findElement(By.id("passowrdInput")).sendKeys("123");
	    WebElement 	element  = driver.findElement(By.linkText("SIGN IN"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", element);
		
		Thread.sleep(5000);
		addChannel(driver);
		Thread.sleep(5000);
		channelName(driver);
		Thread.sleep(5000);
		sendTexts(driver);
			

	}
	
	public static void signUp(WebDriver driver) throws InterruptedException
	{
        WebElement 	ele  = driver.findElement(By.linkText("SIGN UP"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", ele);
		Thread.sleep(5000);
	   
		driver.findElement(By.xpath("//INPUT[@id='textName']")).sendKeys("samhita12"); 
		driver.findElement(By.id("textEmail")).sendKeys("samhita12@gmail.com");
		driver.findElement(By.id("textPassword")).sendKeys("sam123");
		driver.findElement(By.id("textConfirmPassword")).sendKeys("sam123");
		
		WebElement 	elem  = driver.findElement(By.linkText("SIGN UP"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", elem);
	   
	}
	
	public static void negSignUp(WebDriver driver) throws InterruptedException
	{
		WebElement 	ele  = driver.findElement(By.linkText("SIGN UP"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", ele);
		Thread.sleep(5000);
		
		WebElement 	name = driver.findElement(By.xpath("//INPUT[@id='textName']")); 
		name.sendKeys("sam");
		String vename = name.getAttribute("value");
		System.out.println(vename);
		WebElement 	email = driver.findElement(By.id("textEmail"));
		email.sendKeys("sam@in");
		String veemail = email.getAttribute("value");
		System.out.println(veemail);
		WebElement 	pswd = driver.findElement(By.id("textPassword"));
		pswd.sendKeys("rrr");
		String vepswd = pswd.getAttribute("value");
		System.out.println(vepswd);
		WebElement 	confpswd = driver.findElement(By.id("textConfirmPassword"));
		confpswd.sendKeys("sss");
		String veconfpswd = confpswd.getAttribute("value");
		System.out.println(veconfpswd);
		WebElement 	elem  = driver.findElement(By.linkText("SIGN UP"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", elem);
		
		 WebDriverWait wait = new WebDriverWait(driver,20);
		    WebElement 	error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'match')]")));
		   if(error.isDisplayed())
		    {
			   System.out.println("Test fail" + error.getText());
		    }
		
		
	}
	
	public static void addChannel(WebDriver driver)
	{
        WebElement 	ele  = driver.findElement(By.xpath("//SPAN[text()='Add Channel']"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", ele);
		
	}
	
	public static void channelName(WebDriver driver)
	{
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler).findElement(By.xpath("//INPUT[starts-with(@id,'undefined-Channelname')]")).sendKeys("hi");
		driver.findElement(By.xpath("//SPAN[contains(text(), 'Create')]")).click();
	
		driver.switchTo().defaultContent();
	}
	
	public static void sendTexts(WebDriver driver) throws InterruptedException
	{
		//WebElement 	channel  = driver.findElement(By.linkText("hi"));
		//channel.click();
        WebElement 	text  = driver.findElement(By.xpath("//TEXTAREA[starts-with(@id,'undefined-Yourthoughts')]"));
        text.sendKeys("from samhita@gmail.com");
        Thread.sleep(3000);
        text.sendKeys(Keys.RETURN);
	    
		
	}
	

}
