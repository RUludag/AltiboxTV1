package no.altibox.step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.CWPage;
import no.altibox.pages.SVODPage;
import no.altibox.pages.VODPage;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SVODStepsDefs {

    @When("Verify that the details page of assets show the necessary fields for SVOD")
    public void Verify_that_the_details_page_of_assets_show_the_necessary_fields_for_SVOD() {

        SVODPage svodPage=new SVODPage();
        svodPage.VerifyThatTheDetailsPageOfAssetsShowThenecessaryFieldsForSVOD();

    }

    @When("Start an asset and wait til the player control hide")
    public void Start_an_asset_and_wait_til_the_player_control_hide() throws InterruptedException {
        SVODPage svodPage=new SVODPage();
        svodPage.StartAnAssetAndWaitTilThePlayerControlHide();

    }


  @Then ("Wait for the progress indicator to disappear")
    public void Wait_for_the_progress_indicator_to_disappear(){

        BrowserUtils.waitFor(5);
     SVODPage svodPage=new SVODPage();

      try{
          Assert.assertTrue("Player control is not shown",svodPage.controlPlayer.isDisplayed());
      }
      catch (Exception e){
          System.out.println("The player control is hided");
      }

  }


    @Then("Move the cursor to recall the player controls for observation of progress bar")
    public void moveTheCursorToRecallThePlayerControlsForObservationOfProgressBar() {

        SVODPage svodPage=new SVODPage();
        svodPage.MoveTheCursorToRecall_thePlayer();

    }
}
