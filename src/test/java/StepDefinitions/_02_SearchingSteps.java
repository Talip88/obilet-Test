package StepDefinitions;

import Pages._01_HomePageContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class _02_SearchingSteps {

    _01_HomePageContent hp = new _01_HomePageContent();

    String departureFly;
    String returnFly;

    @Given("Click flight button")
    public void clickFlightButton() {

        hp.findAndClick("ucakButton");
    }

    @When("Select a departure and arrival place and date of flight")
    public void selectADepartureAndArrivalPlaceAndDateOfFlight() {

        hp.findAndClick("nereden");
        hp.verifyResults("visible");
        hp.findAndClick("gidisHavalimani");

        hp.findAndClick("nereye");
        hp.verifyResults("visible");
        hp.findAndClick("donusHavalimani");

        hp.findAndClick("gidisTarihi");
        hp.findAndClick("gidisTarihiSec");
        hp.verifyResults("closeDepartureCalendar");

        hp.findAndClick("donusTarihi");
        hp.findAndClick("donusTarihiSec");
        hp.verifyResults("closeReturnCalendar");

    }


    @And("Click search flight button")
    public void clickSearchFlightButton() {
        hp.findAndClick("ucakBiletiBul");
    }

    @Then("Choose one of flights and Control Ecofly, Click if it is exist")
    public void chooseOneOfFlightsAndControlEcoflyClickIfItIsExist() {
        hp.verifyResults("containerClass");
    }

    @And("Select an Arrival and Date of flight")
    public void selectAnArrivalAndDateOfFlight() {
        hp.findAndClick("nereye");
        hp.findAndClick("donusTarihi");
    }

    @And("Select a departure flight")
    public void selectADepartureFlight() {
        if (hp.ecoGidis()) {
            hp.findAndClick("ecofly");
            hp.findAndClick("ecoflyClick");
        } else {
            hp.findAndClick("normalFly");
        }
        departureFly = GWD.getDriver().findElement(By.xpath("(//div[@class='journey row'])[1]/..")).getAttribute("data-id");


    }

    @And("Select a return flight")
    public void selectAReturnFlight() {
        if (hp.ecoDonus()) {
            returnFly = GWD.getDriver().findElement(By.xpath("(//div[@class='current'][contains(text(),'Dönüş')]/../../..//span[contains(text(),'Promosyonlu')])[1]/../../../../..")).getAttribute("data-id");
            hp.findAndClick("ecoflyReturn");
            hp.findAndClick("ecoflyReturnClick");
        } else {
            returnFly = GWD.getDriver().findElement(By.xpath("(//div[@class='current'][contains(text(),'Dönüş')]/../../..//div[@class='journey row'])[1]/..")).getAttribute("data-id");
            hp.findAndClick("normalFlyReturn");
        }

    }

    @Then("User should see payment page and check flights whether true or not")
    public void userShouldSeePaymentPageAndCheckFlightsWhetherTrueOrNot() {
        hp.findAndContainsText("odemeBilgileri", "ÖDEME BİLGİLERİ");

        hp.URLContainsAttribute(departureFly);
        hp.URLContainsAttribute(returnFly);

    }
}
