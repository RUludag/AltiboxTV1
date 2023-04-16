package no.altibox.pages;

import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CatchUpPage {
    public CatchUpPage() {
        PageFactory.initElements(Driver.get(), this);}
    @FindBy(xpath = "//*[@href='/programarkiv']")
    public WebElement ProgramArchive;
    @FindBy(xpath ="//*[@title='Movies and series']" )
    public WebElement ChooseMoviesandSeries;
    @FindBy(xpath = "(//*[@class='logo-container'])[9]")
    public WebElement ChooseProgram;
    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement WatchTV;

    @FindBy(xpath = "//*[@class='player-control-item player-seekbar']")
    public WebElement Slider;
    @FindBy(xpath = "(//*[@class='player-control-icon undefined'])[3]")
    public WebElement RightForward;

    @FindBy(xpath = "(//*[@class='logo'])[3]")
    public WebElement AltiboxLogo;
    @FindBy(xpath = "//*[@class='outer-video-container']")
    public WebElement controlPlayer1;


    @FindBy(xpath = "(//*[@class='aib-icon'])[5]")
    public WebElement Pause;
    public void ChooseAProgramFromProgramArchive(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ProgramArchive.click();
        BrowserUtils.waitFor(1);
        ChooseMoviesandSeries.click();
        ChooseProgram.click();

    }

    public void VerifyTheDetailPanelDisplaysAllAvailableSeasonsAndEpisodesDifferentSeasonsCanBeSelectedToListEpisodesInTheSelectedSeason() {

        Actions action = new Actions(Driver.get());

        List<WebElement> SeasonNumber = Driver.get().findElements(By.xpath("//*[@class='season-list-selector']/ul/li/button"));

        for (int i = 1; i < SeasonNumber.size(); i++) {

            action.moveToElement(SeasonNumber.get(i)).click().perform();
            BrowserUtils.waitFor(1);
            List<WebElement> SubElements = Driver.get().findElements(By.xpath("//*[@class='episode-row ']"));

            for (WebElement altEleman : SubElements) {
                BrowserUtils.waitFor(1);
                action.moveToElement(altEleman).click().perform();

                WebElement Text = Driver.get().findElement(By.xpath("//*[@class='expandableText_expandableText__9lgoc  ']"));
                Assert.assertTrue(Text.isDisplayed());
            }}
    }
    public void StartAProgram(){
        WatchTV.click();
        BrowserUtils.waitFor(2);
    }

    public void PressPause(){
        Pause.click();
    }

    public void ClickForwardButtonAndVerifyThePlaybackResumesWithCorrectDecodingAndNoLag(){

        int currentValue = Integer.parseInt(Slider.getAttribute("value"));
        RightForward.click();
        BrowserUtils.waitFor(3);
        int futureValue = Integer.parseInt(Slider.getAttribute("value"));
        Assert.assertTrue(futureValue==currentValue+30);

    }

    public void ScrollUpAndDownInTheEpisodesListAndVerifyScrollingWorksNormallyAndTheSeasonsAndEpisodesCanEasilyBeNavigatedIn() {
      BrowserUtils.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,200)");
            BrowserUtils.waitFor(1);
        }

        Assert.assertTrue(AltiboxLogo.isDisplayed());
        for (int i = 0; i <10; i++) {
            js.executeScript("window.scrollBy(0,-200)");
            BrowserUtils.waitFor(1);

    }}


    public void SelectOneOfTheEpisodesToStartPlaying(){

        WatchTV.click();

    }

    public void TheEpisodePlaysNormally() {
        Actions action = new Actions(Driver.get());
        String firstSliderValue=Slider.getAttribute("value");

        BrowserUtils.waitFor(6);

        action.moveToElement(controlPlayer1).perform();

        String secondSliderValue=Slider.getAttribute("value");

        int firstValueAsInt=Integer.parseInt(firstSliderValue);

        int secondValueAsInt=Integer.parseInt(secondSliderValue);


        Assert.assertTrue(firstValueAsInt<secondValueAsInt);

}}
