package no.altibox.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.LoginPage;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.ConfigurationReader;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url= ConfigurationReader.getValue("url");
        Driver.get();

//        Set<Cookie> allCookies;
//        try (FileInputStream fis = new FileInputStream("src/test/cookies");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            allCookies = (Set<Cookie>) ois.readObject();
//        } catch (FileNotFoundException | ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        for (Cookie loadedCookie : allCookies) {
//            driver.get().manage().addCookie(loadedCookie);
//        }

        Driver.get().get(url);
    }

    @When("the user enters the credentials")
    public void the_user_enters_the_credentials() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String userName=ConfigurationReader.getValue("username");
        String password=ConfigurationReader.getValue("password");

        LoginPage loginPage=new LoginPage();
        loginPage.login(userName,password);

        BrowserUtils.waitFor(2);

     /*   try {
            WebElement ChoseDevice = Driver.get().findElement(By.xpath("(//*[@class='styles_optionButton__x0pJ1'])[1]"));
            ChoseDevice.click();
        } catch (NoSuchElementException e) {

        }

        BrowserUtils.waitFor(2);

        try {
            WebElement ChoseDevice = Driver.get().findElement(By.xpath("(//*[@class='styles_optionButton__x0pJ1'])[1]"));
            ChoseDevice.click();
        } catch (NoSuchElementException e) {

        }*/

    }



    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@class='profileImage']")).click();
        String actual=Driver.get().findElement(By.xpath("//*[text()='Logged in with password']")).getText();
        Assert.assertEquals("Logged in with password",actual);




    }

}
