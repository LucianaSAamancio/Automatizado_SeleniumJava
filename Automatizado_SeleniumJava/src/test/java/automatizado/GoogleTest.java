package automatizado;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
     //Responsável por iniciar o navegador 
    private WebDriver driver;
    //Variável com a URL base do Google
    private final String URL_BASE = "https://www.google.com/";
    //Variável com o caminho do chromedriver
    private final String CAMINHO_DRIVER = "C:\\Automatizado_SeleniumJava\\Automatizado_SeleniumJava\\src\\resource\\chromedriver.exe";

    private void iniciar(){
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }
    @Test
    public  void devePesquisarNoGoogle(){
        
        iniciar();

        WebElement inputPesquisa = driver.findElement(By.name("q"));
        inputPesquisa.sendKeys("Batata frita" + Keys.ENTER);

        String resultado = driver.findElement(By.xpath("/html/body/div[3]/div/div[9]/div/div[1]/div[2]/div/div/g-scrolling-carousel/div[1]/div/div[1]")).getText();

        assertTrue(resultado, resultado.contains("Ver resultados"));

        driver.quit();
    }

}
