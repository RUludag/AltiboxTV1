package no.altibox.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.CWPage;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CWStepDefs {

    public static WebElement firstAsset;
    public static String firstAssetName;


    @When("Go to Movies and Series")
    public void go_to_Movies_and_Series() {
        CWPage cwPage=new CWPage();
        cwPage.NavigateToMoviesPage();
    }
    @When("Start a movie")
    public void start_a_movie() throws InterruptedException {
        CWPage cwPage=new CWPage();
        cwPage.StartMovie();
    }
    @When("Make a bookmark and Verify that bookmark is set successfully")
    public void make_a_bookmark_and_Verify_that_bookmark_is_set_successfully() throws InterruptedException {
       CWPage cwPage=new CWPage();
       cwPage.MakeBookmark();



    }

    @When("Make a new bookmark and Verify that bookmark is set successfully")
    public void make_a_new_bookmark_and_Verify_that_bookmark_is_set_successfully() throws InterruptedException {
        CWPage cwPage=new CWPage();
        cwPage.MakeBookmark();
    }

    @When("Make a bookmark and Verify that bookmark is set successfully\\(Series)")
    public void make_a_bookmark_and_Verify_that_bookmark_is_set_successfully_Series() throws InterruptedException {
        CWPage cwPage=new CWPage();
        cwPage.MakeBookmarkSVODSeries();
    }

    @When("Make a new bookmark and Verify that bookmark is set successfully\\(Series)")
    public void make_a_new_bookmark_and_Verify_that_bookmark_is_set_successfully_Series() throws InterruptedException {
        CWPage cwPage=new CWPage();
        cwPage.MakeBookmarkSVODSeries();
    }
    @Then("Start the movie again and fast forward to the end of the movie")
    public void start_the_movie_again_and_fast_forward_to_the_end_of_the_movie() throws InterruptedException {
        CWPage cwPage=new CWPage();
        cwPage.FFToEnd();
    }

    @Then("Verify that the movie is no longer showing in CW swimlane")
    public void verify_that_the_movie_is_no_longer_showing_in_CW_swimlane() {

        BrowserUtils.waitFor(2);
        String firstAssetOnCW=Driver.get().findElement(By.xpath("(//*[@class='HorizontalAsset_title__ULWHh']/span)[1]")).getText();
        BrowserUtils.waitFor(2);
        Assert.assertNotEquals(firstAssetName,firstAssetOnCW);
        System.out.println("firstAssetOnCW = " + firstAssetOnCW);
        System.out.println("firstAssetName = " + firstAssetName);
    }


    @When("Go to Program Archive")
    public void go_to_Program_Archive() {
        Driver.get().findElement(By.xpath("//*[@href='/programarkiv']")).click();
    }

    @When("Go to Streaming services")
    public void go_to_Streaming_services(){
        Driver.get().findElement(By.xpath("//*[@href='/streaming']")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//*[@class='aib-hover-glow'])[2]")).click();}

    @When("Go to Streaming services And Choose Kanal")
    public void go_to_Streaming_services_And_Choose_Kanal(){
        Driver.get().findElement(By.xpath("(//*[@href='/streaming'])[1]")).click();
        BrowserUtils.waitFor(2);
      }

    @When("Start a program from SVOD Movie")
    public void Start_a_program_from_SVOD_Movie(){
        CWPage cwPage=new CWPage();
        cwPage.StartAProgramFromStreamingServices();
      //  firstAssetName=Driver.get().findElement(By.xpath("//*[@class='PlayerAssetCard_assetTitle__k+0JS']")).getText();
        System.out.println("firstAssetName = " + firstAssetName);
    }
    @When("Start a program from SVOD Series")
    public void Start_a_program_from_SVOD_Series(){

        CWPage cwPage=new CWPage();
        cwPage.StartAProgramFromStreamingSeries();
        System.out.println("firstAssetName = " + firstAssetName);
    }

    @When("Start a program from Program Archive")
    public void start_a_program_from_Program_Archive() {
        CWPage cwPage=new CWPage();
        cwPage.StartAProgramFromProgramArchive();
        firstAsset=Driver.get().findElement(By.xpath("(//*[@class='header-center'])[2]"));
    }

    @When("Navigate to home page and verify that the asset appears 1st place in CW swimlane")
    public void navigate_to_home_page_and_verify_that_the_asset_appears_1st_place_in_CW_swimlane() {

        BrowserUtils.waitFor(3);
        CWPage cwPage=new CWPage();
        cwPage.HomePage.click();
        BrowserUtils.waitFor(5);
        String firstAssetText=firstAssetName;
        String actualResult=Driver.get().findElement(By.xpath("(//*[@class='HorizontalAsset_title__ULWHh'])[1]/span")).getText();
        BrowserUtils.waitFor(3);
        Assert.assertEquals(firstAssetText, actualResult);
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("(//*[@class='HorizontalAsset_image__RW9td'])[1]")).click();

    }

    @Then("Verify that the asset has picture, title, genre and airing time")
    public void verify_that_the_asset_has_picture_title_genre_and_airing_time() {
        CWPage cwPage=new CWPage();
        cwPage.VerifyThatTheAssetHasPictureTitleGenreAndAiringTime();
    }


}
