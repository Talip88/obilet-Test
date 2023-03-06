package StepDefinitions;

import Pages._01_HomePageContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;


public class _01_RegisterSteps {

    _01_HomePageContent hp=new _01_HomePageContent();

    @Given("Navigate to OBILET Homepage")
    public void navigateToOBILETHomepage() {

        GWD.getDriver().get("https://www.obilet.com/");
        GWD.getDriver().manage().window().maximize();

    }

    @Then("User should navigate Homepage successfully")
    public void userShouldNavigateHomepageSuccessfully(){

        hp.verifyURL("https://www.obilet.com/");




    }

    @And("Click to Member Login Button")
    public void clickToMemberLoginButton() {

        hp.findAndClick("login");

    }

    @When("Enter email and password and click Register button")
    public void enterEmailAndPasswordAndClickRegisterButton() throws InterruptedException {

     hp.findAndClick("register1");
     hp.verifyURL("https://www.obilet.com/?kayit");
     hp.findAndSend("email", hp.getRandomMail());
     hp.findAndSend("password", hp.getRandomPassword());
     Thread.sleep(3000);
     hp.moveTo("register2");
     hp.findAndClick("register2");



    }

    @Then("User should register successfully")
    public void userShouldRegisterSuccessfully() {

    hp.findAndContainsText("hesabim", "Hesabım");


    }
}
