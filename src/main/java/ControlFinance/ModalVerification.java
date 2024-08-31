package ControlFinance;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ModalVerification {
	// URL do Website que será testado.
    private static final String BASE_URL = "https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/";
    // Elementos comuns da página que serão utilizados.
    private static final String SHOW_MODAL_ID = "showModal";
    private static final String INPUT_MODAL_CLASS = "inputModalValue";
    private static final String BTN_ENTRANCE_CLASS = "btnEntrance";
    private static final String BTN_EXIT_CLASS = "btnExit";
    private static final String CLOSE_MODAL_CLASS = "closeModal";
    private static final String TYPE_TRANSITION_CLASS = "typeTransition";
    
    // Instancia um ChromeDriver que será o navegador utilizado para os testes.
    WebDriver driver = new ChromeDriver();
    
    // Utilizado para gerar um número aleatório entre 1-1000 para ser testado no input.
	Random random = new Random();
	int randomNumber = random.nextInt(1000);
	
	public boolean openModalVerification() {
		try {
			driver.get(BASE_URL);
	        
	        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
	        btnOpenModal.click();
	        
	        WebElement modalSelector = driver.findElement(By.id("modalContainer"));
	        return modalSelector.isDisplayed();
        } finally {

			driver.quit();
        }

	}
	
	public boolean invalidInput() {
		try {
			driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
					
	        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
	        btnOpenModal.click();
	        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
	        inputModal.sendKeys(String.valueOf("um"));
	        return inputModal.getAttribute("value") == "";
        } finally {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			driver.quit();
        }
	}
	
	public boolean validInput() {
		try {
			driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
			
	        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
	        btnOpenModal.click();
	        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
	        inputModal.sendKeys(String.valueOf(randomNumber));
	        return inputModal.getAttribute("value").equals(String.valueOf(randomNumber));
		} finally {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			driver.quit();
		}

	}
	
	public boolean submitVerification() {
		try {
			driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
	        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
	        btnOpenModal.click();
	        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
	        inputModal.sendKeys(String.valueOf(randomNumber));
	        WebElement btnSubmit = driver.findElement(By.id("inputValue"));
	        
	        return btnSubmit.isEnabled();
		}finally {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			driver.quit();
		}

	}
	
    public boolean btnEntranceVerification() {
    	try {
	        driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
	        WebElement botaoAbrirModal = driver.findElement(By.id("showModal"));
	        botaoAbrirModal.click();
	
	        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
	        inputModal.sendKeys(String.valueOf(randomNumber));
	
	        WebElement btnEntrance = driver.findElement(By.className("btnEntrance"));
	        btnEntrance.click();
	        
	        WebElement btnSubmit = driver.findElement(By.id("inputValue"));
	        return btnSubmit.isEnabled();
        } finally {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			driver.quit();
        }

    }
    
    public boolean btnExitVerification() {
    	try {
	        driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
	        WebElement botaoAbrirModal = driver.findElement(By.id("showModal"));
	        botaoAbrirModal.click();
	
	        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
	        inputModal.sendKeys(String.valueOf(randomNumber));
	
	        WebElement btnEntrance = driver.findElement(By.className("btnExit"));
	        btnEntrance.click();
	        
	        WebElement btnSubmit = driver.findElement(By.id("inputValue"));
	        return btnSubmit.isEnabled();
        } finally {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			driver.quit();
        }

    }
    
    public boolean cancelModalVerification() {
    	try {
			driver.get("https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/");
	        
	        WebElement btnOpenModal = driver.findElement(By.id("showModal"));
	        btnOpenModal.click();
	        
	        WebElement modalSelector = driver.findElement(By.id("modalContainer"));
	        
	        WebElement inputModal = driver.findElement(By.className("inputModalValue"));
	        inputModal.sendKeys(String.valueOf(randomNumber));
	        
	        WebElement cancelBtn = driver.findElement(By.className("cancel"));
	        cancelBtn.click();
	        
	        return modalSelector.isDisplayed();
        } finally {
	        try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			driver.quit();
        }
    	}
    

    
    
    
    }
		
     
    
