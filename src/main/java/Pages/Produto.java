package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Produto extends PageObject {

    public Produto(WebDriver driver) {
        super(driver);
    }


    public void validaPreco(){
        Assert.assertEquals("R$ 29,99", driver.findElement(By.cssSelector(".price-current")).getText());
    }

}
