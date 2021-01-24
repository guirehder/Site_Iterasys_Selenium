package petz;

import Pages.Home;
import Pages.Lista;
import Pages.Produto;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CompraProduto {

    // 3.1 - Atributos
    String url; // endereço do site
    WebDriver driver; // objeto do selenium webdriver
    Home home; //objeto home herdado da classe home
    Lista lista;
    Produto produto;

    // 3.2 - Métodos ou Funções

    @Before // Antes do Teste
    public void iniciar() {
        url ="https://www.petz.com.br"; // endereço da petz
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/chromedriver_88.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // maximizar a janela do browser
        driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS); // espera implicita de 30 segundos
        lista = new Lista(driver); //instanciar a classe Lista
        home = new Home(driver); //instanciar a classe Home
        produto = new Produto(driver); //instanciar a classe Produto
    }


    @After //Depois do Teste
    public void finalizar() {
        driver.quit();
    }

    @Dado("^que acesso o site da Petz$")
    public void que_acesso_o_site_da_Petz()  {
        driver.get(url); //abre o site da Petz
        System.out.println("Passo 1");
    }

    @Quando("^busco por \"([^\"]*)\" e pressiono Enter$")
    public void busco_por_e_pressiono_Enter(String produto) {
        home.buscarProdutoComEnter(produto);
        System.out.println("Passo 2");
    }

    @Entao("^exibe uma lista de produtos relacionados com coleira$")
    public void exibe_uma_lista_de_produtos_relacionados_com_coleira()  {
        lista.confimarLista();
        System.out.println("Passo 3");
    }

    @Quando("^escolho \"([^\"]*)\"$")
    public void escolho(String arg1)  {
        produto.selecionarProduto();
        System.out.println("Passo 4");
    }

    @Entao("^exibe para o \"([^\"]*)\" o preço de \"([^\"]*)\"$")
    public void exibe_para_o_o_preço_de(String arg1, String arg2)  {
        produto.validaPreco();
        System.out.println("Passo 5");
    }
}
