package ControlFinance;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SupportMethods {

	// URL do Website que será testado.
	public static final String BASE_URL = "https://mvsgurtz.github.io/Kenzie-Academy-Brasil-Developers-control-finance-mvsgurtz/";
    
    // Elementos comuns da página que serão utilizados.
    private static final String SHOW_MODAL_ID = "showModal";
    private static final String INPUT_MODAL_CLASS = "inputModalValue";
    private static final String BTN_ENTRANCE_CLASS = "btnEntrance";
    private static final String BTN_EXIT_CLASS = "btnExit";
    private static final String CLOSE_MODAL_CLASS = "closeModal";
    private static final String TYPE_TRANSITION_CLASS = "typeTransition";
    
    // Utilizado para gerar um número aleatório entre 1-1000 para ser testado no input.
	Random random = new Random();
	int randomNumber = random.nextInt(1000);
	

	// MÉTODOS AUXILIARES UTILIZADOS NAS FUNÇÕES DE TESTE.
	
		// Abre o modal.
		public void openModal(WebDriver driver) {
			driver.get(BASE_URL);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		    WebElement btnOpenModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SHOW_MODAL_ID)));
	        btnOpenModal.click();
		}
		
		// Emite um comando de submit ao form e fecha o modal.
		public void submitAndCloseModal(WebDriver driver) {
	        WebElement inputModal = driver.findElement(By.className(INPUT_MODAL_CLASS));
	        inputModal.submit();
	        WebElement btnClose = driver.findElement(By.className(CLOSE_MODAL_CLASS));
	        btnClose.click();
		}
		
		// Insere e envia um valor de Entrada ou Saída, logo após fecha o modal.
		public void insertValue(WebDriver driver, String typeOfValue) {
		    openModal(driver);
		    
		    WebElement inputModal = driver.findElement(By.className(INPUT_MODAL_CLASS));
		    inputModal.sendKeys(String.valueOf(randomNumber));

		    if ("Saída".equals(typeOfValue)) {
		        WebElement btnExit = driver.findElement(By.className(BTN_EXIT_CLASS));
		        btnExit.click();
		    } else if ("Entrada".equals(typeOfValue)) {
		        WebElement btnEntrance = driver.findElement(By.className(BTN_ENTRANCE_CLASS));
		        btnEntrance.click();
		    } else {
		    	driver.quit();
		    }

		    submitAndCloseModal(driver);
		}
		
		// Encontra o elemento na página, caso ainda não exista,
		// aguarda para evitar problemas em elementos ainda não renderizados.
		
		public void waitForElement(WebDriver driver, By by) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(d -> ExpectedConditions.visibilityOfElementLocated(by).apply(d));
		}
		
		// Executa uma captura de tela antes de fechar o driver. 
		public void captureScreenshot(WebDriver driver, String filePath, String fileName) {
		    File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    String fullPath = filePath + File.separator + generateUniqueFileName(fileName);
		    
		    try {
		        Files.copy(screenshotFile.toPath(), new File(fullPath).toPath());
		        System.out.println("Screenshot captured: " + fullPath);
		    } catch (IOException e) {
		        System.err.println("Failed to capture screenshot: " + e.getMessage());
		    }
		}
	    
		// Cria um caminho único para o arquivo que armazenará a captura de tela.
		public String generateUniqueFileName(String baseName) {
	        // Incorpora um timestamp para tornar o nome do arquivo único
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
	        String timestamp = dateFormat.format(new Date());

	        // Adiciona o timestamp ao nome base
	        return baseName + "_" + timestamp + ".png";
	    }
	    
	    // Tamanho do card de valores atual.
		public int cardSize(WebDriver driver) {
	        // Encontra a lista que contém os valores e verifica quantos estão
	        // presente.
	        waitForElement(driver, By.className("transactions__card"));
	        List<WebElement> liElements = driver.findElement(By.className("transactions__card")).findElements(By.tagName("li"));
	        return liElements.size();
		}
		
			
}
