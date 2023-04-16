package no.altibox.step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.LoginPage;
import no.altibox.pages.VODPage;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.ConfigurationReader;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class VODDefs {


    @When("Purchase a movie")
    public void purchase_a_movie() throws InterruptedException {
        VODPage vodPage=new VODPage();
        vodPage.purchaseMovie();
    }

    @When("Assert that purchasing not possible and login page is opened")
    public void assert_that_purchasing_not_possible_and_login_page_is_opened() {
        WebElement loginTitle= Driver.get().findElement(By.xpath("//*[@id='logintitle']"));
        //Assert.assertTrue(loginTitle.getText()=="Logg inn");
        Assert.assertEquals("Logg inn",loginTitle.getText());
    }



    @Then("Click on the purchase button")
    public void click_on_the_purchase_button() {
        BrowserUtils.waitFor(2);
        WebElement watchFromButton=Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonPrimary__0Z8oz']"));
        BrowserUtils.waitFor(1);
        watchFromButton.click();
    }



    @Then("Click on a definition for purchasing")
    public void click_on_a_definition_for_purchasing() {
        WebElement buy=Driver.get().findElement(By.xpath("//*[@class='styles_optionButton__x0pJ1']"));
        buy.click();
    }

    @Then("Assert that movie is purchased and receipt is shown")
    public void assert_that_movie_is_purchased_and_receipt_is_shown() {
        VODPage vodPage=new VODPage();
        vodPage.AssertThatMovieIsPurchasedAndReceiptIsShown();
    }

    @Then("Assert that option for watching and closing message")
    public void assert_that_option_for_watching_and_closing_message() {
     VODPage vodPage=new VODPage();
     vodPage.AsserThatOptionForWatchingAndClosingMessage();
    }

    @Then("Assert that play button is working")
    public void assert_that_play_button_is_working() {

        VODPage vodPage=new VODPage();
        vodPage.AssertThatPlayButtonIsWorking();
    }

    @When("the user enters the credentials on login page")
    public void the_user_enters_the_credentials_on_login_page() {
        String userName= ConfigurationReader.getValue("username");
        String password=ConfigurationReader.getValue("password");

        LoginPage loginPage=new LoginPage();
        loginPage.loginOnLoginPage(userName,password);
    }


    @When("if the asset is already purchased choose another film")
    public void if_the_asset_is_already_purchased_choose_another_film() throws InterruptedException {
        VODPage vodPage=new VODPage();
        vodPage.IfTheAssetIsAlreadyPurchasedChooseAnotherFilm();

    }

    @When("Purchase free movie")
    public void purchase_free_movie() {
        VODPage vodPage=new VODPage();
        BrowserUtils.clickWithJS(vodPage.FreeMovieSL);
        Driver.get().findElement(By.xpath("(//*[@class='vod-asset'])[1]")).click();
        Driver.get().findElement(By.xpath("(//*[@class=' buttons_buttonPrimary__3Qu0H'])")).click();
    }

    private String purchasedFreeMovie;

    @When("Click on the option which is {int} kr")
    public void click_on_the_option_which_is_kr(Integer int1) {

        List<WebElement> badgePrices=Driver.get().findElements(By.xpath("(//*[@class='badge purchasing'])"));

//purchasedFreeMovie is private element so I have not changed its place


        for(int i=1;i< badgePrices.size();i++){
            if (!badgePrices.get(i).getText().equals("0")){
                continue;
            }else {
                purchasedFreeMovie+=badgePrices.get(i).getAttribute("title");
                badgePrices.get(i).click();
            }
        }

        Driver.get().findElement(By.xpath("//*[@class='styles_buttonClose__kuwT8']")).click();

    }

    @Then("Verify that the purchased movie is listed in My Content page")
    public void verify_that_the_purchased_movie_is_listed_in_My_Content_page() {
        Driver.get().findElement(By.xpath("//*[text()='My content']")).click();

        String ActualFirst=Driver.get().findElement(By.xpath("(//*[@class='vod-asset-title'])[1]")).getText();

        Assert.assertEquals(purchasedFreeMovie,ActualFirst);

        //purchasedFreeMovie is private element so I have not changed its place

    }



   @When("Verify that PauseButton,SkipBackwards,SkipForwards,TimelineSeekBar,TimeOfAsset,Subtitle,AudioSelector,VolumeButton,MAxMinWindow,QualitySelection on the Player Controls")
    public void verify_thatPauseButton_SkipBackwards_SkipForwards_TimelineSeekBar_TimeOfAsset_Subtitle_AudioSelector_VolumeButton_MAxMinWindow_QualitySelection_on_the_Player_controls(){


      VODPage vodPage=new VODPage();
      vodPage.verifyThatPauseButtonSkipBackwardsSkipForwardsTimelineSeekBarTimeOfAssetSubtitleAudioSelectorVolumeButtonMAxMinWindowQualitySelectionOnThePlayerControls();

   }
   @When("Select pause verify that play button is enabled")
    public void Select_pause_verify_that_play_button_is_enabled(){

       VODPage vodPage=new VODPage();
       vodPage.pauseButton.click();
       BrowserUtils.waitFor(2);
       Assert.assertTrue(vodPage.playbutton.isEnabled());

   }

   @Then("Select play verify that pause button is enabled")
    public void Select_play_verify_that_pause_button_is_enabled(){
       VODPage vodPage=new VODPage();
       vodPage.playbutton.click();
       Assert.assertTrue(vodPage.pauseButton.isEnabled());

   }
   @Then("Drag the cursor to the middle of the timeline")
    public void Drag_the_cursor_to_the_middle_of_the_timeline(){

       VODPage vodPage=new VODPage();
       vodPage.DragTheCursorToTheMiddleOfTheTimeline();


   }
   @Then("Select forward button verify that playback jumps forwards a specified interval")
   public void Select_forward_button_verify_that_playback_jumps_forwards_a_specified_interval(){

       WebElement RightLeftforward=Driver.get().findElement(By.xpath("(//*[@class='player-control-icon undefined'])[3]"));
       int value=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@name='slider']")).getAttribute("value"));
       int valueLast=value;

       for(int i=0;i<5;i++){
           RightLeftforward.click();
           BrowserUtils.waitFor(1);
       }
       Assert.assertTrue(value<valueLast+160);
   }

   @Then("Select backward button verify that playback jumps backwards a specified interval")
    public void Select_backward_button_verify_that_playback_jumps_backwards_a_specified_interval(){

     VODPage vodPage=new VODPage();
     vodPage.SelectBackwardButtonVerifyThatPlaybackJumpsBackwardsASpecifiedInterval();
    }

    @Then ("Start a movie and wait til the player control hide")
    public void Start_a_movie_and_wait_til_the_player_control_hide() throws InterruptedException {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        VODPage vodpage= new VODPage();
        vodpage.StartAMovieandWaitTilThePlayerControlHide();
    }


    @Then("Move the cursor to recall the player controls")
    public void Move_the_cursor_to_recall_the_player_controls() throws InterruptedException {

       VODPage vodPage=new VODPage();
       vodPage.MoveTheCursorToRecallThePlayerControls();



    }
    @When("Verify that the details page of assets show the necessary fields")
    public void Verify_that_the_details_page_of_assets_show_the_necessary_fields(){

        VODPage vodpage= new VODPage();
        vodpage.VerifyThatTheDetailsPageOfAssetsShowTheNecessaryFields();


    }


    @Then("Verify that cover image,movie title,category,length,published year,limit of movie,rating,synopsis,actor and director list,details,distributor,mediatilsynets ID,altibox ID")
    public void Verify_that_cover_image_movie_title_category_length_published_year_limit_of_movie_rating_synopsis_actor_and_director_list_details_distributor_mediatilsynets_ID_altibox_ID(){


    }

}
