package no.altibox.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.TV_Guide;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TVGuideStepDefs {

    private WebElement favoritedChannel;

    private static String chosenChannelName;


    @When("Click the heart symbol above {int} channels to favorite them")
    public void click_the_heart_symbol_above_channels_to_favorite_them(Integer int1) {

        BrowserUtils.waitFor(3);
        chosenChannelName=Driver.get().findElement(By.xpath("(//*[@class='channel-name'])[5]")).getText();

        BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("(//*[@class='aib-icon non-favorite'])[5]")));
        //BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("(//*[@class='aib-icon non-favorite'])[6]")));
    }

    @When("Refresh the page")
    public void refresh_the_page() {
        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(3);
    }

    @Then("Verify that the favorited channels shows first in the TV-Guide")
    public void verify_that_the_favorited_channels_shows_first_in_the_TV_Guide() {
        String firstChannel=Driver.get().findElement(By.xpath("(//*[@class='channel-name'])[1]")).getText();
        //String secondChannel=Driver.get().findElement(By.xpath("(//*[@class='channel-name'])[2]")).getText();

        Assert.assertEquals(chosenChannelName,firstChannel);
        //Assert.assertEquals("MAX",secondChannel);

    }

    @Then("Navigate to the front page")
    public void navigate_to_the_front_page() {
        Driver.get().findElement(By.xpath("(//*[@alt='To the front page'])[1]")).click();
        BrowserUtils.waitFor(3);
    }

    @When("Click on Watch TV")
    public void click_on_Watch_TV() {
        Driver.get().findElement(By.xpath("//*[@class='watch-tv-header']")).click();
    }

    @Then("Open the mini-epg")
    public void open_the_mini_epg() {
        Driver.get().findElement(By.xpath("(//*[@class='channel'])[1]")).click();
        Driver.get().findElement(By.xpath("//*[@class='showChannelListLogoButton']")).click();
    }

    @Then("Verify that not effected the channel order")
    public void verify_that_not_effected_the_channel_order() {
        WebElement focusedChannel=Driver.get().findElement(By.xpath("(//*[@class='focusedChannel '])[1]"));
        WebElement expectedChannel=Driver.get().findElement(By.xpath("(//*[@href='/tv/471'])[1]"));

        Assert.assertEquals(expectedChannel,focusedChannel);

        Driver.get().navigate().refresh();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[text()='TV Guide']")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@class='aib-icon favorite']")).click();


    }

    @When("Make a single recording")
    public void make_a_single_recording() {
        Driver.get().findElement(By.xpath("(//*[@class='tvGuideplaybillProgram future'])[1]/button")).click();
        WebElement recordButton=Driver.get().findElement(By.xpath("//*[@class=' buttons_iconButton__h-okA '][1]"));
        recordButton.click();
        BrowserUtils.waitFor(3);
        WebElement recordProgramButton=Driver.get().findElement(By.xpath("//*[text()='Record program']"));
        recordProgramButton.click();
        BrowserUtils.waitFor(3);
    }

    @When("Tap on edit recording button")
    public void tap_on_edit_recording_button() {
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("//*[text()='Change']")).click();
    }


    @When("Remove the planned recording")
    public void remove_the_planned_recording() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().findElement(By.xpath("//*[text()='Stop this recording']")).click();


        BrowserUtils.waitFor(4);
       String recordIconText=Driver.get().findElement(By.xpath("(//*[@class=' buttons_iconButton__h-okA '])[1]")).getText();
       Assert.assertEquals("Record",recordIconText);

        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__Rcwqt']")).click();

    }

    @Then("Remove the planned recording for this")
    public void remove_the_planned_recording_for_this() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[text()='Stop this recording']")).click();
    }

    @Then("Verify that the All Channels option is selected and TV-Guide display all available channels")
    public void verify_that_the_All_Channels_option_is_selected_and_TV_Guide_display_all_available_channels() {
        Driver.get().findElement(By.xpath("//*[@class='Dropdown-root channellist']")).click();
        WebElement allChannelsTick=Driver.get().findElement(By.xpath("//*[text()='All channels']"));
        Assert.assertTrue(allChannelsTick.isDisplayed());

        int allChannelsSize=Driver.get().findElements(By.xpath("//*[@class='channel-name']")).size();
        Assert.assertEquals(156,allChannelsSize);

    }



    @When("Select the My Channels option")
    public void select_the_My_Channels_option() {
        //Driver.get().findElement(By.xpath("//*[@class='Dropdown-root channellist']")).click();
        Driver.get().findElement(By.xpath("(//*[text()='Channels in my package'])[1]")).click();
    }

    @Then("Verify that My Channels are displayed")
    public void verify_that_My_Channels_are_displayed() {
        int myChannelsSize=Driver.get().findElements(By.xpath("//*[@class='channel-name']")).size();
        Assert.assertEquals(156,myChannelsSize);
    }

    @Then("Click on yesterday button")
    public void click_on_yesterday_button() {
        Driver.get().findElement(By.xpath("//button[@class=' date-change']")).click();
        BrowserUtils.waitFor(2);
       // Driver.get().findElement(By.xpath("//*[starts-with(text(),'Yesterday')]")).click();
    }

    @Then("Verify that TV Guide displays the program for yesterday")
    public void verify_that_TV_Guide_displays_the_program_for_yesterday() {

        BrowserUtils.waitFor(2);
        //String dateOnDropdown=Driver.get().findElement(By.xpath("(//*[@class='Dropdown-placeholder'])[1]")).getAttribute("Yesterday");
        Driver.get().findElement(By.xpath("(//*[@class='program-info'])[1]")).click();
        String dateOnDP=Driver.get().findElement(By.xpath("(//*[@class='additional-information'])[1]")).getText();
        Assert.assertTrue(dateOnDP.contains("yesterday"));

    }

    @Then("Click on today button")
    public void click_on_today_button() {
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__Rcwqt']")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//*[@class=' date-change'])[2]")).click();
    }

    @Then("Verify that TV Guide displays the program for today")
    public void verify_that_TV_Guide_displays_the_program_for_today() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//*[@class='program-info'])[1]")).click();
        BrowserUtils.waitFor(2);
        String dateOnDP=Driver.get().findElement(By.xpath("(//*[@class='additional-information'])[1]")).getText().substring(6,11);
        Assert.assertEquals("today",dateOnDP);
    }

    @Then("Click on tomorrow button")
    public void click_on_tomorrow_button() {
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__Rcwqt']")).click();
        Driver.get().findElement(By.xpath("(//*[@class=' date-change'])[2]")).click();
    }

    @Then("Verify that TV Guide displays the program for tomorrow")
    public void verify_that_TV_Guide_displays_the_program_for_tomorrow() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//*[@class='program-info'])[1]")).click();
        BrowserUtils.waitFor(2);
        String dateOnDP=Driver.get().findElement(By.xpath("(//*[@class='additional-information'])[1]")).getText().substring(5,13);
        Assert.assertEquals("tomorrow",dateOnDP);
    }

    @Then("Click on a future day")
    public void click_on_a_future_day() {
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__Rcwqt']")).click();
        Driver.get().findElement(By.xpath("(//*[@class=' date-change'])[2]")).click();
    }

    @Then("Verify that TV Guide displays the program for this date")
    public void verify_that_TV_Guide_displays_the_program_for_this_date() {
        String dateOnDropdown=Driver.get().findElement(By.xpath("(//*[@class='Dropdown-placeholder is-selected'])[1]")).getText();
        Driver.get().findElement(By.xpath("(//*[@class='program-info'])[1]")).click();
        BrowserUtils.waitFor(2);
        String dateOnDP=Driver.get().findElement(By.xpath("(//*[@class='additional-information'])[1]")).getText();
        String dateOnDPACt=dateOnDP.substring(5,dateOnDP.length()-9);
        Assert.assertEquals(dateOnDropdown,dateOnDPACt);
    }

    @Then("Navigate to homepage and navigate back to TV Guide")
    public void navigate_to_homepage_and_navigate_back_to_TV_Guide() {
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__Rcwqt']")).click();
        Driver.get().findElement(By.xpath("(//*[@class='logo-link'])[1]")).click();
        Driver.get().findElement(By.xpath("//*[text()='TV Guide']")).click();
        String dateOnDropdown=Driver.get().findElement(By.xpath("(//*[@class='Dropdown-placeholder'])[1]")).getText().substring(0,5);

        Assert.assertEquals("Today",dateOnDropdown);
    }

    @When("Make a single recording and verify that the program is marked with a single circle in the TV Guide")
    public void make_a_single_recording_and_verify_that_the_program_is_marked_with_a_single_circle_in_the_TV_Guide() {
        Driver.get().findElement(By.xpath("(//*[@class='tvGuideplaybillProgram future'])[1]/button")).click();
        WebElement recordButton=Driver.get().findElement(By.xpath("//*[text()='Record']"));
        recordButton.click();
        BrowserUtils.waitFor(2);
        WebElement recordProgramButton=Driver.get().findElement(By.xpath("//*[text()='Record program']"));
        recordProgramButton.click();
        Driver.get().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        Driver.get().findElement(By.xpath("//*[@class=' buttons_iconButton__h-okA buttons_active__TEn-y']")).click();
        WebElement pvrIcon=Driver.get().findElement(By.xpath("(//*[@class='tvGuideplaybillProgram future'])[1]/button/div/ul/li"));
        Assert.assertTrue(pvrIcon.isDisplayed());

    }

    @When("Make a series recording Verify that all of the episodes are marked with circle icon")
    public void make_a_series_recording_Verify_that_all_of_the_episodes_are_marked_with_circle_icon() {
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().findElement(By.xpath("(//button[@class='program-info'])[6]")).click();
        WebElement recordButton=Driver.get().findElement(By.xpath("//*[text()='Record']"));
        recordButton.click();
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement recordSeriesButton=Driver.get().findElement(By.xpath("//*[text()='Record series']"));
        recordSeriesButton.click();
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__2riiL']")).click();
        WebElement pvrIcon=Driver.get().findElement(By.xpath("(//*[@class='tvGuideplaybillProgram future'])[2]/button/div/ul/li"));
        Assert.assertTrue(pvrIcon.isDisplayed());

    }

    @Then("Make a series recording")
    public void make_a_series_recording() {

        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Driver.get().findElement(By.xpath("(//*[@class='tvGuideplaybillProgram future'])[2]/button")).click();
        WebElement recordButton=Driver.get().findElement(By.xpath("//*[text()='Record']"));
        recordButton.click();
        BrowserUtils.waitFor(2);
        WebElement recordSeriesButton=Driver.get().findElement(By.xpath("//*[text()='Record program']"));
        recordSeriesButton.click();


    }

    @Then("Verify that the button text changes to {string}")
    public void verify_that_the_button_text_changes_to(String string) {
        String actualResult=Driver.get().findElement(By.xpath("//*[text()='Record']")).getText();
        Assert.assertEquals("Record", actualResult);
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__Rcwqt']")).click();


    }

    @Then("Select any live program")
    public void select_any_live_program() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().findElement(By.xpath("(//*[@class='program-info live'])[1]")).click();


    }

    @Then("Click on Watch from start and verify that program is streaming from start")
    public void click_on_Watch_from_start_and_verify_that_program_is_streaming_from_start() throws InterruptedException {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        TV_Guide tvGuide= new TV_Guide();
        tvGuide.ClickOnWatchFromStart();
        tvGuide.VerifyAtStart();
    }

    @Then("Close player")
    public void close_player() throws InterruptedException {
        TV_Guide tvGuide=new TV_Guide();
        tvGuide.ClosePlayer();
        Thread.sleep(3000);


    }

    @Then("Open DP")
    public void open_DP() throws InterruptedException {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().findElement(By.xpath("(//*[@class='program-info live'])[1]")).click();
        Thread.sleep(2000);
    }

    @Then("Select Go to channel and verify that streaming is live")
    public void select_Go_to_channel_and_verify_that_streaming_is_live() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        TV_Guide tvGuide=new TV_Guide();
        tvGuide.WatchChannel();
    }

    @Then("Remove the planned recording for series")
    public void remove_the_planned_recording_for_series() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[text()='Stop this recording']")).click();
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonClose__Rcwqt']")).click();

    }

    @Then("Select a finished program")
    public void select_a_finished_program() {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Driver.get().findElement(By.xpath("(//*[@class='playbill-item-container'])[5]/ul/li")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@class=' buttons_buttonPrimary__0Z8oz']")).click();
        BrowserUtils.waitFor(2);

    }

    @Then("Verify that the program starts streaming from program archive service.")
    public void verify_that_the_program_starts_streaming_from_program_archive_service() {
        //String expectedResult=Driver.get().findElement(By.xpath("//*[text()='Program archive']")).getText();
        WebElement actualResult=Driver.get().findElement(By.xpath("//*[@href='/programarkiv']"));
        Assert.assertTrue(actualResult.getAttribute("class").contains("current"));
    }

    @When("Navigate to TV-Guide")
    public void navigate_to_TV_Guide() {
        WebElement TVGuide=Driver.get().findElement(By.xpath("//*[text()='TV Guide']"));
        TVGuide.click();
    }



    @Then("Verify All channels is selected and display all available channels")
    public void verify_All_channels_is_selected(){

        TV_Guide tvGuide=new TV_Guide();
        tvGuide.VerifyAllChannelsIsSelectedAndDisplayAllAvailableChannels();

    }

    @When("Select the option My channel and verify My channels are displayed with channel logo")
    public void Select_the_option_My_channel(){
        TV_Guide tvGuide=new TV_Guide();
        tvGuide.SelectTheOptionMyChannelAndVerifyMyChannelAreDisplayedWithChannelLogo();

    }

}
