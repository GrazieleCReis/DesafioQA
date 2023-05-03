package br.com.qadecolar.desafio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static br.com.qadecolar.desafio.core.DriverFactory.getDriver;

public class GooglePage {

    public void buscarTexto(String nomeBusca){
        WebElement buscador = getDriver().findElement(By.id("APjFqb"));
        buscador.sendKeys(nomeBusca + Keys.RETURN);
    }
    public String obterTextoBuscador(){
        return getDriver().findElement(By.cssSelector(".a4bIc")).getText();
    }

    public String obterPrimeiroResultado(){
        WebElement firstResult = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".v5yQqb")));
        return firstResult.getText();
    }
}
