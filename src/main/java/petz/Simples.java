// 1 - Nome do Pacote
package petz;

// 2 - Bibliotecas Importadas


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

// 3 - Classe
public class Simples {
    // 3.1 - Atributos
    String url; // endereço do site
    WebDriver driver; // objeto do selenium webdriver

    // 3.2 - Métodos ou Funções

    @Before // Antes do Teste
    public void iniciar() {
        url ="https://www.petz.com.br"; // endereço da petz
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver_88.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizar a janela do browser
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); // espera implicita de 30 segundos
    }


    @After //Depois do Teste
    public void finalizar() {
        driver.quit();
    }

    @Test // O Teste
    public void abrirPagina() {
        driver.get(url); //abrir a pagina inicial do site petz
        Assert.assertEquals("Pet Shop: Petz o maior pet shop do Brasil.", driver.getTitle()); // validou o texto guia da pagina
    }

}
