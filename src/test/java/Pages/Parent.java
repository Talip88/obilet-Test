package Pages;

import Utilities.GWD;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;
import java.time.Duration;

public class Parent {

    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    Actions action= new Actions(GWD.getDriver());


    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        scrollToelement(element);
        element.clear();
        element.sendKeys(value);

    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        scrollToelement(element);
        element.click();

    }

    public void waitUntilVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void scrollToelement(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }



    public void waitUntilClickable(WebElement element)

    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void verifyContainsTextFunction(WebElement element, String value)
    {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"The text you searched couldn't be find");
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }

    public void verifyURLFunction(String value)
    {
        wait.until(ExpectedConditions.urlToBe(value));

    }

    public void URLContainsAttribute(String value)
    {
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains(value));

    }


    public void verifyResult(String element)
    {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(element),0));
    }

    public boolean ecoGidis(){
        try {
            GWD.getDriver().findElement(By.xpath("//li[contains(@data-id,'TK')]")).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found.");;
        }
        return false;
    }
    public boolean ecoDonus(){
        try {
            GWD.getDriver().findElement(By.xpath("//div[@class='current'][contains(text(),'Dönüş')]/../../..//li[contains(@data-id,'TK')]")).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Element not found.");;
        }
        return false;
    }

    public void dropDownMenus(WebElement element,int value){
        Select select=new Select(element);
        select.selectByIndex(value);

    }

    public void moveMouse(WebElement element){
        waitUntilClickable(element);
        action.moveToElement(element).build().perform();
    }


}



