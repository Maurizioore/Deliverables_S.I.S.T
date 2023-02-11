package com.example.seleniumtest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestPuntiCharles {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        //uso il driver firefox, driver firefox fornito insieme ai 2 test
        System.setProperty("webdriver.gecko.driver","/Users/mauriziore/Desktop/driverFirefox/geckodriver");
        webDriver= new FirefoxDriver();
    }
    @Test
    public void testPuntiLeclerc() throws InterruptedException {
        webDriver.get("https://www.formula1.com");
        //clicco su accetta nella pagina iniziale
        webDriver.findElement(By.xpath("//*[@id=\"truste-consent-button\"]")).click();
        //attesa 3 secondi per far aggiornare tutto nella pagina
        Thread.sleep(3000);
        //prendo l'elemento che mi interessa(in questo caso i punti totali che leclerc ha totalizzato nella scorsa stagione)
        WebElement box= webDriver.findElement(By.xpath("/html/body/div[2]/main/div[7]/div/div[2]/div[1]/div/div/ul/li[2]/a/span[5]/span"));
        //verifico che i punti presi come quelli che mi aspetto di avere
        Assert.assertEquals(box.getText(), "308 PTS");
    }
    @AfterMethod
    public void cleanUp(){
        //chiudo il driver
        webDriver.close();
    }
}
