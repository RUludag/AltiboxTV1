package no.altibox.step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.FrontPage;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class frontPage {



    @When("Purchase a movie and Verify that the purchased movie is listed as first with bought marked")
    public void purchase_a_movie_and_Verify_that_the_purchased_movie_is_listed_as_first_with_bought_marked() throws InterruptedException {
        Thread.sleep(2000);
        FrontPage frontPage= new FrontPage();
        frontPage.purchaseMovie();
    }

    @When("Rent a movie and Verify that the rented movie is listed as first with remaining rental time")
    public void rent_a_movie_and_Verify_that_the_rented_movie_is_listed_as_first_with_remaining_rental_time() throws InterruptedException {
        Thread.sleep(2000);
        FrontPage frontPage= new FrontPage();
        frontPage.rentMovie();
    }

    @Then("Verify that there is continue watching section on the home page")
    public void verify_that_there_is_continue_watching_section_on_the_home_page() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement CW_swimlane= Driver.get().findElement(By.xpath("//*[text()='Continue watching']"));
        Assert.assertTrue(CW_swimlane.isDisplayed());

    }

    @Then("Verify that there is progression bar on the images of the assets")
    public void verify_that_there_is_progression_bar_on_the_images_of_the_assets() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        int progressBarAmount=Driver.get().findElements(By.xpath("//*[@class='altibox-asset with-progress']")).size();
        int cwAssetsAmount=Driver.get().findElements(By.xpath("(//*[@class='continue-watching']/div)[2]/div")).size();
        Assert.assertEquals(progressBarAmount,cwAssetsAmount);

    }

    @Then("Open an asset from this section")
    public void open_an_asset_from_this_section() {
        FrontPage frontPage=new FrontPage();
        frontPage.openAssetCW();



    }

    @Then("Verify that DP opens")
    public void verify_that_DP_opens() {
        WebElement DP=Driver.get().findElement(By.xpath("//*[@class='altibox-detail-wrapper ']"));
        Assert.assertTrue(DP.isDisplayed());
    }

    @Then("Verify that DP shows title, genre, synopsis and airing time")
    public void verify_that_DP_shows_title_genre_synopsis_and_airing_time() {

        FrontPage frontPage=new FrontPage();
        frontPage.VerifyThatDPShowsTitleGenreSynopsisAndAiringTime();
    }

    @Then("Watch the asset")
    public void watch_the_asset() {
        FrontPage frontPage=new FrontPage();
        frontPage.ClickOnCW();
    }

    @Then("Verify that playback starts successfully")
    public void verify_that_playback_starts_successfully() {
        WebElement video=Driver.get().findElement(By.xpath("//*[@class='outer-video-container']"));
        Assert.assertTrue(video.isDisplayed());
    }


    @Then("verify that Bought movies on the front page")
    public void verifyThatBoughtMoviesOnTheFrontPage() {

}}
