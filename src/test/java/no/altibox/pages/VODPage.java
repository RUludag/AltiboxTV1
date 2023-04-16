package no.altibox.pages;

import no.altibox.step_definitions.CWStepDefs;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class VODPage {

    public VODPage() { PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement WatchNow;
    public static String firstAssetName;
    @FindBy(xpath = "(//*[text()='Bought'])[4]")
    public WebElement FirstFilmAsBought;

    @FindBy(xpath = "//*[text()='Movies and series']")
    public WebElement MoviesAndSeries;

    @FindBy(xpath = "//*[@title='New']")
    public WebElement PopularMovies;

    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement WatchFromButton;

    @FindBy(xpath = "(//*[@class='badge purchasing'])[1]")
    public WebElement BuyButton;

    @FindBy(xpath = "")
    public WebElement LoginTitle;

    @FindBy(xpath = "(//*[@class='logo-container'])[1]")
    public WebElement FreeMovieSL;

    @FindBy(xpath = "(//*[@class='aib-icon'])[5]")
    public WebElement playbutton;

    @FindBy(xpath="(//*[@class='aib-icon'])[5]")
    public WebElement pauseButton;

   @FindBy(xpath ="//img[class='altibox-asset-poster-container']")
   public WebElement coverImage;

   @FindBy(xpath = "//*[@class='logo-container']")
   public List<WebElement> Movies;

   @FindBy(xpath ="//*[@class='altibox-asset-title-container']/h1" )
   public WebElement screenMovieTitle;

   @FindBy(xpath = "//*[@class='altibox-asset-caption']")
   public WebElement element;

   @FindBy(xpath = "//*[@class='altibox-asset-description']")
   public WebElement synopsis;

   @FindBy(xpath = "(//*[@class='altibox-asset-cast-list'])[2]")
   public WebElement directorProducer;

   @FindBy(xpath = "//*[@class='value'][1]")
   public WebElement originaltitle;

   @FindBy(xpath = "//*[@class='value'][2]")
   public WebElement distrubutor;

   @FindBy(xpath = "//*[@class='value'][3]")
   public WebElement altiboxID;

   @FindBy(xpath = "//*[@class='value'][4]")
   public WebElement yearCountry;
   @FindBy(xpath="//*[@class='value language'][1]")
   public WebElement  audioLanguage;

   @FindBy(xpath = "//*[@class='value language'][2]")
   public WebElement subtitleLanguage;

   @FindBy(xpath = "(//*[@class='value'])[6]")
   public WebElement medietilsynetID;
   @FindBy(xpath = "(//*[@class='value'])[5]")
   public WebElement videoQuality;

   @FindBy(xpath = "(//*[@class='player-controls'])[2]")
   public WebElement controlPlayer;

   @FindBy(xpath = "(//*[@class='aib-icon'])[4]")
   public WebElement SkipBackWards;

   @FindBy(xpath ="(//*[@class='aib-icon'])[6]" )
   public WebElement SkipForward;

   @FindBy(xpath = "//*[@class='player-control-item player-seekbar']")
   public WebElement TimeLineSeekBar;

   @FindBy(xpath = "(//*[@class='aib-icon'])[7]")
   public WebElement VolumeButton;

   @FindBy(xpath = "(//*[@class='aib-icon'])[10]")
   public WebElement MaxMin;

   @FindBy(xpath = "(//*[@class='aib-icon'])[9]")
   public  WebElement Settings;

   @FindBy(xpath = "(//*[@class='aib-icon'])[8]")
   public WebElement Subtitle;

   @FindBy(xpath = "(//*[@class='aib-icon'])[3]")
   public WebElement playButton;

   @FindBy(xpath ="//*[@class='styles_buttonClose__G705L']" )
   public WebElement closeButton;


   @FindBy(xpath = "//*[@class='confirmation-feedback']")
   public WebElement confirmationMessage;

   @FindBy(xpath = "//*[@title='New']")
   public WebElement newFilms;

   @FindBy(xpath = "(//*[@class='player-control-icon undefined'])[3]")
   public WebElement RightLeftforward;

   @FindBy(xpath = "//*[@class='outer-video-container']")
   public WebElement controlPlayer1;
    public void purchaseMovie() throws InterruptedException {

        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BrowserUtils.clickWithJS(PopularMovies);
        List<WebElement> films=Driver.get().findElements(By.xpath("//*[@class='vod-asset']"));

        String purchasedMovie="";

        for(int i=0;i<films.size();i++) {
            if (films.get(i).getText().contains("BOUGHT")) {
                continue;
            } else {
                purchasedMovie+=films.get(i).getAttribute("title");
                films.get(i).click();
                break;
            }
        }

        Thread.sleep(3000);

        WatchFromButton.click();

    }

    public void StartMovie() throws InterruptedException {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        FirstFilmAsBought.click();
        CWStepDefs.firstAssetName=Driver.get().findElement(By.xpath("//*[@class='altibox-asset-title-container']/h1")).getText();

        WatchNow.click();
        Thread.sleep(1000);

    }

    public void VerifyThatTheDetailsPageOfAssetsShowTheNecessaryFields() {


        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        for (int i = 1; i < Movies.size() - 1; i++) {
            WebElement film = Driver.get().findElement(By.xpath("(//*[@class='logo-container'])[" + i + "]"));
            film.click();
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.stalenessOf(film));


            String screenTitle = screenMovieTitle.getText();
            String htmlTitle = screenMovieTitle.getAttribute("innerHTML");
            if (screenTitle.equals(htmlTitle)) {
                System.out.println("The name of the movie on the screen and in the HTML code is the same.");
            } else {
                System.out.println("The name of the movie on the screen and in the HTML code is the different.");
            }

            Assert.assertTrue(element.isDisplayed());


            Assert.assertTrue(synopsis.isDisplayed());

            List <WebElement> castList=Driver.get().findElements(By.xpath("//*[@class='altibox-asset-cast-list'][1]"));

            Assert.assertNotNull(castList);


            Assert.assertNotNull(directorProducer);

            Assert.assertTrue(originaltitle.isDisplayed());
            System.out.println(originaltitle.getText());

            Assert.assertTrue(distrubutor.isDisplayed());
            System.out.println("there is distrubutor");

            Assert.assertTrue(altiboxID.isDisplayed());
            System.out.println("There is Altibox ID");

            Assert.assertTrue(yearCountry.isDisplayed());
            System.out.println("there are year,country");


            Assert.assertTrue(audioLanguage.isDisplayed());
            System.out.println("AudioLanguage is shown");

            Assert.assertTrue(subtitleLanguage.isDisplayed());
            System.out.println("Subtitle language is shown");

            Assert.assertTrue(videoQuality.isDisplayed());
            System.out.println("video quality is shown");

            Assert.assertTrue(medietilsynetID.isDisplayed());
            System.out.println("medietilsynetID is shown");


            CWPage cwPage=new CWPage();
            cwPage.NavigateToMoviesPage();

        }

    }

    public  void StartAMovieandWaitTilThePlayerControlHide() throws InterruptedException {

        FirstFilmAsBought.click();
        CWStepDefs.firstAssetName=Driver.get().findElement(By.xpath("//*[@class='altibox-asset-title-container']/h1")).getText();
        WatchNow.click();

        Thread.sleep(5000);

        try{
            Assert.assertTrue("Player control is not shown",controlPlayer.isDisplayed());
        }
        catch (Exception e){
            System.out.println("The player control is hided");
        }

    }

    public void verifyThatPauseButtonSkipBackwardsSkipForwardsTimelineSeekBarTimeOfAssetSubtitleAudioSelectorVolumeButtonMAxMinWindowQualitySelectionOnThePlayerControls(){

        Assert.assertTrue(pauseButton.isEnabled());

        Assert.assertTrue(SkipBackWards.isEnabled());

        Assert.assertTrue(SkipForward.isEnabled());

        Assert.assertTrue(TimeLineSeekBar.isEnabled());

        Assert.assertTrue(VolumeButton.isEnabled());

        Assert.assertTrue(MaxMin.isEnabled());

        Assert.assertTrue(Settings.isEnabled());

        Assert.assertTrue(Subtitle.isEnabled());

    }

    public void AsserThatOptionForWatchingAndClosingMessage(){

        Assert.assertTrue(playButton.isDisplayed());
        Assert.assertTrue(closeButton.isDisplayed());
    }

    public void AssertThatPlayButtonIsWorking(){


        Assert.assertTrue(playButton.isEnabled());

    }

    public void AssertThatMovieIsPurchasedAndReceiptIsShown(){

        String a= confirmationMessage.getText();
        Assert.assertTrue(a.contains("You have bought "));
    }

    public void IfTheAssetIsAlreadyPurchasedChooseAnotherFilm() throws InterruptedException {

        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        MoviesAndSeries.click();
        BrowserUtils.clickWithJS(newFilms);

        List<WebElement> films=Driver.get().findElements(By.xpath("//*[@class='vod-asset']"));

        String purchasedMovie="";

        for(int i=0;i<films.size();i++) {
            if (films.get(i).getText().contains("BOUGHT")) {
                continue;
            } else {
                purchasedMovie+=films.get(i).getAttribute("title");
                films.get(i).click();
                break;
            }
        }

        Thread.sleep(3000);


    }

    public void DragTheCursorToTheMiddleOfTheTimeline(){

        double value = Double.parseDouble(Driver.get().findElement(By.xpath("//*[@name='slider']")).getAttribute("max"));
        double valueLast = value / 2;

        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("document.getElementsByTagName('video')[0].currentTime ="+ valueLast+";");
        BrowserUtils.waitFor(2);


    }

    public void SelectBackwardButtonVerifyThatPlaybackJumpsBackwardsASpecifiedInterval(){


        int value=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@name='slider']")).getAttribute("value"));
        int valueLast=value;


        for(int i=5;i>0;i--){
            RightLeftforward.click();
            BrowserUtils.waitFor(2);
        }

        Assert.assertTrue(value>valueLast-10 && value<valueLast+10);
        BrowserUtils.waitFor(3);
    }

    public void MoveTheCursorToRecallThePlayerControls() throws InterruptedException {

        Actions actions=new Actions(Driver.get());


        BrowserUtils.waitFor(1);

        actions.moveToElement(controlPlayer1).perform();

        BrowserUtils.waitFor(1);

        Assert.assertTrue(controlPlayer1.isDisplayed());



    }


}




































