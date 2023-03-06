package Pages;

import Utilities.GWD;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class _01_HomePageContent extends Parent {

    String homepageURL = "https://www.obilet.com/";

    public _01_HomePageContent() {
        PageFactory.initElements(GWD.getDriver(), this);

    }

    @FindBy(xpath = "//a[text()='Üye Girişi']")
    private WebElement login;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(css = "[name='password']")
    private WebElement password;

    @FindBy(xpath = "//a[text()='Üye Ol']")
    private WebElement register1;

    @FindBy(css = "button[class*='register-button']")
    private WebElement register2;

    @FindBy(xpath = "//a[text()='Hesabım']")
    private WebElement hesabim;

    @FindBy(xpath = "//a[@data-event-action='Flight']")
    private WebElement ucakButton;

    @FindBy(css = "#destination-input")
    private WebElement nereye;

    @FindBy(css = "#origin-input")
    private WebElement nereden;

    @FindBy(css = "li[data-value*='350']")
    private WebElement gidisHavalimani;

    @FindBy(css = "#destination [data-value='223_5'] > .location")
    private WebElement donusHavalimani;

    @FindBy(css = "button[id='return-input-placeholder']")
    private WebElement donusTarihi;

    @FindBy(css = "#return > div [data-date='2023-03-29']")
    private WebElement donusTarihiSec;

    @FindBy(xpath = "//button[@id='search-button']")
    private WebElement ucakBiletiBul;

    @FindBy(css = "ob-datepicker[id='departure']")
    private WebElement gidisTarihi;

    @FindBy(css = "[data-date='2023-03-15']")
    private WebElement gidisTarihiSec;

    @FindBy(xpath = "(//span[contains(text(),'Promosyonlu')])[1]")
    private WebElement ecofly;

    @FindBy(xpath = "//span[normalize-space()='Ecofly (EF)']")
    private WebElement ecoflyClick;

    @FindBy(xpath = "(//div[@class='current'][contains(text(),'Dönüş')]/../../..//span[contains(text(),'Promosyonlu')])[1]")
    private WebElement ecoflyReturn;

    @FindBy(xpath = "(//div[@class='current'][contains(text(),'Dönüş')]/../../..//span[normalize-space()='Ecofly (EF)'])[1]")
    private WebElement ecoflyReturnClick;

    @FindBy(xpath = "(//div[@class='journey row'])[1]")
    private WebElement normalFly;

    @FindBy(xpath = "(//div[@class='current'][contains(text(),'Dönüş')]/../../..//div[@class='journey row'])[1]")
    private WebElement normalFlyReturn;

    @FindBy(css = "fieldset#payment > .payment-label")
    private WebElement odemeBilgileri;




    WebElement myElement;
    String checkClass;


    public void findAndSend(String strlement, String value) {

        switch (strlement) {
            case "email":
                myElement = email;
                break;
            case "password":
                myElement = password;
                break;

        }

        sendKeysFunction(myElement, value);
    }


    public void findAndClick(String strlement) {

        switch (strlement) {
            case "login":
                myElement = login;
                break;
            case "register1":
                myElement = register1;
                break;
            case "register2":
                myElement = register2;
                break;
            case "ucakButton":
                myElement = ucakButton;
                break;
            case "nereden":
                myElement = nereden;
                break;
            case "nereye":
                myElement = nereye;
                break;
            case "gidisTarihi":
                myElement = gidisTarihi;
                break;
            case "donusTarihi":
                myElement = donusTarihi;
                break;
            case "ucakBiletiBul":
                myElement = ucakBiletiBul;
                break;
            case "ecofly":
                myElement = ecofly;
                break;
            case "ecoflyClick":
                myElement = ecoflyClick;
                break;
            case "normalFly":
                myElement = normalFly;
                break;
            case "normalFlyReturn":
                myElement = normalFlyReturn;
                break;
            case "ecoflyReturn":
                myElement = ecoflyReturn;
                break;
            case "ecoflyReturnClick":
                myElement = ecoflyReturnClick;
                break;
            case "gidisTarihiSec":
                myElement = gidisTarihiSec;
                break;
            case "donusTarihiSec":
                myElement = donusTarihiSec;
                break;
            case "gidisHavalimani":
                myElement = gidisHavalimani;
                break;
            case "donusHavalimani":
                myElement = donusHavalimani;
                break;

        }

        clickFunction(myElement);


    }

    public void findAndContainsText(String strlement, String text) {

        switch (strlement) {
            case "hesabim":
                myElement = hesabim;
                break;
            case "odemeBilgileri":
                myElement = odemeBilgileri;
                break;

        }

        verifyContainsTextFunction(myElement, text);
    }

    public void moveTo(String strlement) {
        switch (strlement) {

            case "register2":
                myElement = register2;
                break;
        }
        moveMouse(myElement);

    }

    public void verifyURL(String text) {

        verifyURLFunction(text);

    }

    public void verifyResults(String text) {
        switch (text) {

            case "visible":
                checkClass = "ob-select[class='visible']";
                break;
            case "containerClass":
                checkClass = "[class='list container visible active']";
                break;
            case "closeDepartureCalendar":
                checkClass = "div[class='departure date group']";
                break;
            case "closeReturnCalendar":
                checkClass = "div[class='return date group']";
                break;
        }
        verifyResult(checkClass);

    }


    public String getRandomPassword() {
        return "Obilet" + RandomStringUtils.randomNumeric(8) + ".";

    }

    public String getRandomMail() {
        return RandomStringUtils.randomAlphabetic(8).toLowerCase() + "@gmail.com";

    }


}




