// 1 - Pacote
package Site;

// 2 - Biblioteca


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

// 3 - Classe
public class BuscaSeleniumPuro {
    // 3.1 - Atributos
    String url = "https://www.iterasys.com.br";
    WebDriver driver;

    // 3.2 - Funções e Métodos
    @Before
    public void iniciar(){
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver_88.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);

    }

    @After
    public void finalizar(){
        driver.quit();

    }

    @Test
    public void buscaCurso(){
        driver.get(url);
        driver.findElement(By.id("searchtext")).sendKeys("Mantis" + Keys.ENTER);
        driver.findElement(By.cssSelector("span.comprar")).click();
        Assert.assertEquals("Mantis",driver.findElement(By.cssSelector("span.item-title")).getText());
        Assert.assertEquals("R$ 49,99", driver.findElement(By.cssSelector("span.new-price")).getText());

    }


}
