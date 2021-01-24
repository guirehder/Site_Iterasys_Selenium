package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lista extends PageObject {

    public Lista(WebDriver driver) {
        super(driver);

    }

    public void confimarLista (){
        Assert.assertEquals("coleira - Produtos pet em promoção | Petz", driver.getTitle());
    }
}
