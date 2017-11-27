package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Register {

	public static void main(String[] args) {
		WebDriver driver = new SafariDriver();
		driver.get("http://localhost:1337/signup");
		driver.findElement(By.id("textName")).sendKeys("samhita");
	}

}
