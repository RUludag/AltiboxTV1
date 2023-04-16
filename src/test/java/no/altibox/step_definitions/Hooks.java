package no.altibox.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.ConfigurationReader;
import no.altibox.utilities.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUp(){
        WebDriver driver = Driver.get();
        driver.get(ConfigurationReader.getValue("url"));
        Driver.get().manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshot");
        }
        String currentUrl = Driver.get().getCurrentUrl();
        String loginErrorUrl = "http://zero.webappsecurity.com/login.html?login_error=true";

        BrowserUtils.waitFor(2);
        /*LoginPage loginPage=new LoginPage();
        loginPage.Logout();*/
        //Driver.closeDriver();
    }
}
