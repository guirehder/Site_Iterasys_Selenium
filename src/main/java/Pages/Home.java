package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Home extends PageObject {
    //Atributos
    //Caixa de Pesquisa
    @FindBy(id = "search")
    private WebElement busca;

    // Construtor
    public Home(WebDriver driver) {
        super (driver);
    }

    // Métodos e Funções
    public void buscarProdutoComEnter(String produto){
        busca.clear();
        busca.sendKeys(produto + Keys.ENTER);
    }

}
