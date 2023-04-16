package no.altibox.pages;


import io.cucumber.java.en.When;
import no.altibox.step_definitions.CWStepDefs;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CWPage {

    public CWPage() { PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "//*[text()='Movies and series']")
    public WebElement MoviesAndSeriesFP;

    @FindBy(xpath = "(//*[text()='Bought'])[4]")
    public WebElement FirstFilmAsBought;

    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement WatchNow;

    @FindBy(xpath = "(//*[@class='player-control-icon undefined'])[3]")
    public WebElement RightForward;

    @FindBy(xpath = "(//*[@alt='To the front page'])[1]")
    public WebElement HomePage;

    @FindBy(xpath = "//*[@class='player-control-item player-seekbar']")
    public WebElement Slider;

    @FindBy(xpath = "(//*[@class='HorizontalAsset_imageContainer__6OFzM'])[1]")
    public WebElement FirstAssetOnCW;

    @FindBy(xpath = "//*[@href='/programarkiv']")
    public WebElement ProgramArchive;

    @FindBy(xpath = "(//*[contains(@href, 'enkelt')])[1]/div")
    public WebElement FilmKanal4;

    @FindBy(xpath = "(//*[@class='logo-container'])[8]")
    public WebElement ChooseProgram;

    @FindBy(xpath ="(//*[@class='altibox-asset-title-link GALINK'])[5]" )
    public WebElement ChooseMoviesandSeries;

    @FindBy(xpath = "(//*[@class='aib-icon'])[5]")
    public WebElement Pause;

    @FindBy(xpath = "(//*[@class='aib-icon'])[7]")
    public WebElement PauseSeries;

    @FindBy(xpath ="(//*[@class='altibox-asset-title-link GALINK'])[3]")
    public WebElement PopularVideoStreaming;

    @FindBy(xpath = "(//*[@class='asset-image-wrapper'])[3]")
    public WebElement ChooseStreamingVideo;

    @FindBy(xpath="//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement WatchStreamingVideo;
    @FindBy(xpath ="(//*[@class='aib-hover-glow'])[9]")
    public WebElement ChooseStreamSeriesKanal;

    @FindBy(xpath = "(//*[@class='logo-container'])[1]")
    public WebElement ChooseStreamSeriesDokumentar;
    @FindBy(xpath = "(//*[@class='asset-image-container aib-hover-glow'])[1]")
    public WebElement picture;

    @FindBy(xpath = "(//*[@class='title-name'])[1]")
    public WebElement title;
    @FindBy(xpath = "(//*[@class='asset-image-container aib-hover-glow'])[1]")
    public WebElement genreAndAiringTime;
    @FindBy(xpath = "//*[@class='altibox-asset-cta-button']")
    public WebElement WatchStreamingSeries;

    @FindBy(xpath = "//*[class='PlayerAssetCard_assetTitle__k+0JS'")
    public WebElement FilmName;

    public void NavigateToMoviesPage(){
        MoviesAndSeriesFP.click();
    }

    public void StartMovie() throws InterruptedException {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        FirstFilmAsBought.click();
        CWStepDefs.firstAssetName=Driver.get().findElement(By.xpath("//*[@class='altibox-asset-title-container']/h1")).getText();

        WatchNow.click();
        Thread.sleep(1000);

    }
    public void MakeBookmark() throws InterruptedException {
        Thread.sleep(3000);
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(Driver.get(), 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("video-container")));

        ((JavascriptExecutor) Driver.get()).executeScript("document.getElementsByClassName('height-adjust player-video').currentTime = 600;");

        for(int i=0;i<10;i++){
            RightForward.click();
            BrowserUtils.waitFor(1);
        }
      Pause.click();
        String firstSliderValue=Slider.getAttribute("value");
        HomePage.click();
        BrowserUtils.waitFor(2);

        BrowserUtils.clickWithJS(FirstAssetOnCW);
        Thread.sleep(1000);

        String bookmarkValue=Slider.getAttribute("value");

        int bookmarkValueAsInt=Integer.parseInt(bookmarkValue);

        int sliderValueAsInt=Integer.parseInt(firstSliderValue);

        Assert.assertTrue(bookmarkValueAsInt<=sliderValueAsInt+3 ||bookmarkValueAsInt>=sliderValueAsInt-3);


    }
    public void MakeBookmarkSVODSeries() throws InterruptedException {
        Thread.sleep(3000);
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(Driver.get(), 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("video-container")));


        ((JavascriptExecutor) Driver.get()).executeScript("document.getElementsByClassName('height-adjust player-video').currentTime = 600;");

        for(int i=0;i<10;i++){
            RightForward.click();
            BrowserUtils.waitFor(1);
        }
        PauseSeries.click();

        String firstSliderValue=Slider.getAttribute("value");

        HomePage.click();
        BrowserUtils.waitFor(2);


        BrowserUtils.clickWithJS(FirstAssetOnCW);
        Thread.sleep(1000);

        String bookmarkValue=Slider.getAttribute("value");

        int bookmarkValueAsInt=Integer.parseInt(bookmarkValue);

        int sliderValueAsInt=Integer.parseInt(firstSliderValue);

        Assert.assertTrue(bookmarkValueAsInt<=sliderValueAsInt+3 ||bookmarkValueAsInt>=sliderValueAsInt-3);

    }


    public void FFToEnd()  {


        BrowserUtils.waitFor(5);

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("document.getElementsByTagName('video')[0].currentTime = 10000;");
        BrowserUtils.waitFor(2);
        HomePage.click();
          Driver.get().navigate().refresh();

    }

    public void StartAProgramFromProgramArchive(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ProgramArchive.click();
        ChooseMoviesandSeries.click();
        ChooseProgram.click();
        CWStepDefs.firstAssetName=Driver.get().findElement(By.xpath("//*[@class='altibox-asset-title-container']/h1")).getText();
        WatchNow.click();


    }

    public void StartAProgramFromStreamingServices(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        PopularVideoStreaming.click();
        ChooseStreamingVideo.click();
        BrowserUtils.waitFor(2);
        CWStepDefs.firstAssetName=Driver.get().findElement(By.xpath("//*[@class='altibox-asset-title-container']/h1")).getText();
        WatchStreamingVideo.click();


    }
    public void StartAProgramFromStreamingSeries(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ChooseStreamSeriesKanal.click();
        ChooseStreamSeriesDokumentar.click();
        BrowserUtils.waitFor(2);
        CWStepDefs.firstAssetName=Driver.get().findElement(By.xpath("//*[@class='altibox-asset-title-container']/h1")).getText();
        WatchStreamingSeries.click();
    }

    public void VerifyFirstCW(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        HomePage.click();

    }

    public void VerifyThatTheAssetHasPictureTitleGenreAndAiringTime() {
        BrowserUtils.waitFor(2);

        CWPage cwPage=new CWPage();
        cwPage.VerifyFirstCW();
        Assert.assertTrue(picture.isDisplayed());
        Assert.assertTrue(title.isDisplayed());
        Assert.assertTrue(genreAndAiringTime.isDisplayed());

    }


}
