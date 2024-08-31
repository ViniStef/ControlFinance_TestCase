package ControlFinance;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Random;

public class ModalVerification {
	Random random = new Random();
	WebDriver driver = new ChromeDriver();
	
	public boolean openModal() {
		driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
        
        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
        btnOpenModal.click();
        
        WebElement modalSelector = driver.findElement(By.id("modalContainer"));
        return modalSelector.isDisplayed();

	}
	
	public boolean invalidInput() {
		driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
				
        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
        btnOpenModal.click();
        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
        inputModal.sendKeys(String.valueOf("um"));
        return inputModal.getAttribute("value") == "";
	}
	
	public boolean validInput() {
		
		int randomNumber = random.nextInt(1000);
		driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
		
        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
        btnOpenModal.click();
        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
        inputModal.sendKeys(String.valueOf(randomNumber));
        return inputModal.getAttribute("value").equals(String.valueOf(randomNumber));
	}
	
	public boolean submitVerification() {
		int randomNumber = random.nextInt(1000);
		driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
        btnOpenModal.click();
        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
        inputModal.sendKeys(String.valueOf(randomNumber));
        WebElement btnSubmit = driver.findElement(By.id("inputValue"));
        
        return btnSubmit.isEnabled();
	}
}
