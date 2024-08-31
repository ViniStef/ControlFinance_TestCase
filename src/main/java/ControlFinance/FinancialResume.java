package ControlFinance;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinancialResume {
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
    
    SupportMethods supportMethods = new SupportMethods();
    
    // Utilizado para gerar um número aleatório entre 1-1000 para ser testado no input.
	Random random = new Random();
	int randomNumber = random.nextInt(1000);
	
	
	// MÉTODOS PUBLICOS PARA TESTE DO WEBSITE.
	
	// Verifica se o form foi enviado corretamente
    public int formVerification() {
        try {
        	driver.get(BASE_URL);
        	supportMethods.insertValue(driver, "Entrada"); 
            
            return supportMethods.cardSize(driver);
        } finally {
        	supportMethods.captureScreenshot(driver, "C:\\Users\\Vinicius\\eclipse-workspace\\ControlFinanceTests\\src\\main\\java\\ControlFinance\\Images", ("formVerification"));
            driver.quit();
        }
    }
	
    // Verifica se o span presente no card está com o valor de "Entrada" ou "Saída" corretamente.
    public boolean spanTypeVerification(String expectedType) {
    	try {
    		supportMethods.insertValue(driver, expectedType);
			supportMethods.waitForElement(driver, By.className(TYPE_TRANSITION_CLASS));
            WebElement spanTypeTransaction = driver.findElement(By.className(TYPE_TRANSITION_CLASS));  
            return spanTypeTransaction.getText().equals(expectedType);
    	} finally {
    		supportMethods.captureScreenshot(driver,"C:\\Users\\Vinicius\\eclipse-workspace\\ControlFinanceTests\\src\\main\\java\\ControlFinance\\Images", ("spanTypeVerification"+expectedType));
            driver.quit();
    	}
    }
    
    // Verifica se o card é excluido corretamente após clicar no botão da lixeira.
    public int excludeButton() {
    	try {
    		supportMethods.insertValue(driver,"Entrada");
			supportMethods.waitForElement(driver, By.className("excValue"));
			WebElement btnExcValue = driver.findElement(By.className("excValue"));
			btnExcValue.click();
			return supportMethods.cardSize(driver);
    	} finally {
    		supportMethods.captureScreenshot(driver, "C:\\Users\\Vinicius\\eclipse-workspace\\ControlFinanceTests\\src\\main\\java\\ControlFinance\\Images", ("excludeButton"));
			driver.quit();
    	}
    }
    
    // Verifica se ao clicar no botão "Todos", todos os valores são exibidos.
    public int btnShowAllVerification() {
    	try {
    		// Insere valores de teste de tipo "Entrada" e "Saída".
    		supportMethods.insertValue(driver,"Entrada");
    		supportMethods.insertValue(driver, "Saída");
	       
    		// Encontra e clica no botão de mostrar todos os valores.
    		supportMethods.waitForElement(driver, By.className("button__all"));
            WebElement btnShowAll = driver.findElement(By.className("button__all"));
            btnShowAll.click();
            
            // Encontra a lista que contém os valores e verifica quantos estão
            // presente após serem inseridos e clicado no botão "Todos".
            return supportMethods.cardSize(driver);
    	} finally {
    		supportMethods.captureScreenshot(driver, "C:\\Users\\Vinicius\\eclipse-workspace\\ControlFinanceTests\\src\\main\\java\\ControlFinance\\Images", ("btnShowAllVerification"));
			driver.quit();
    	}
    }
    
    // Verifica se ao clicar no botão "Entrada", apenas os valores de entrada são exibidos.
    public int btnShowEntranceVerification() {
    	try {
    		// Insere valores de teste de tipo "Entrada" e "Saída".
    		supportMethods.insertValue(driver, "Entrada");
    		supportMethods.insertValue(driver, "Saída");
	       
         // Encontra e clica no botão de mostrar os valores de tipo "Entrada".
            WebElement btnShowEntrance = driver.findElement(By.className("button__entrance"));
            btnShowEntrance.click();
            
            // Encontra a lista que contém os valores e verifica quantos estão
            // presente após serem inseridos e clicado no botão "Entrada".
            return supportMethods.cardSize(driver);
    	} finally {
    		supportMethods.captureScreenshot(driver, "C:\\Users\\Vinicius\\eclipse-workspace\\ControlFinanceTests\\src\\main\\java\\ControlFinance\\Images", ("btnShowEntranceVerification"));
			driver.quit();
    	}
    	}
      
    // Verifica se ao clicar no botão "Saída", apenas os valores de saída são exibidos.
    public int btnShowExitVerification() {
    	try {
    		// Insere valores de teste de tipo "Entrada" e "Saída".
    		supportMethods.insertValue(driver, "Entrada");
    		supportMethods.insertValue(driver, "Saída");
	       
         // Encontra e clica no botão de mostrar os valores de tipo "Saída".
            WebElement btnShowExit = driver.findElement(By.className("button__exit"));
            btnShowExit.click();
            
            // Encontra a lista que contém os valores e verifica quantos estão
            // presente após serem inseridos e clicado no botão "Saída".
            return supportMethods.cardSize(driver);
    	} finally {
    		supportMethods.captureScreenshot(driver, "C:\\Users\\Vinicius\\eclipse-workspace\\ControlFinanceTests\\src\\main\\java\\ControlFinance\\Images", ("btnShowExitVerification"));
			driver.quit();
    	}
    }
    
    // Verifica se o indicador do valor total está correto.
    public boolean totalSumVerification() {
    	try {
    		supportMethods.openModal(driver);

            // Envia um valor de teste (400 - 140).
            WebElement inputModal = driver.findElement(By.className(INPUT_MODAL_CLASS));
            inputModal.sendKeys(String.valueOf(400));

            WebElement btnEntrance = driver.findElement(By.className(BTN_ENTRANCE_CLASS));
            btnEntrance.click();
            inputModal.submit();
            
            WebElement btnExit = driver.findElement(By.className(BTN_EXIT_CLASS));
            inputModal.sendKeys(String.valueOf(140));
            btnExit.click();
            
            supportMethods.submitAndCloseModal(driver);
	        
            // Captura todos os valores presentes no card.
            WebElement listOfValues = driver.findElement(By.className("transactions__card"));
            List<WebElement> valorList =  listOfValues.findElements(By.tagName("p"));
            
            // Remove o tipo de moeda e realiza a soma dos valores.
            int sum = valorList.stream()
                    .mapToInt(element -> Integer.parseInt(element.getText().replace("R$ ", "")))
                    .sum();
            
            WebElement sumValue = driver.findElement(By.className("sum__value"));
            // Verifica se o valor presente no indicador é igual ao obtido ao fazer a soma manualmente.
            return sumValue.getText().replace("R$ ", "").replace(",00", "").equals(String.valueOf(sum));
            
    	} finally {
    		supportMethods.captureScreenshot(driver, "C:\\Users\\Vinicius\\eclipse-workspace\\ControlFinanceTests\\src\\main\\java\\ControlFinance\\Images", ("totalSumVerification"));
			driver.quit();
    	}
    }
    
    
    
}

