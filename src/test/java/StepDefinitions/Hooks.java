package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    @Before
    public void before() {
        System.out.println("Senaryo başladı");
    }

    @After
    public void after(Scenario senaryo) {
        System.out.println("Senaryo bitti");

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("dd_MM_YYHHmmss");

        if (senaryo.isFailed())
        {

            final byte[] byteHali = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            senaryo.attach(byteHali, "image/png", "screenshot name");


        }
        GWD.quitDriver();
    }


}
