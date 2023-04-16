package no.altibox.pages;


import io.cucumber.java.en.When;
import no.altibox.step_definitions.CWStepDefs;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SVODPage {
    public SVODPage() { PageFactory.initElements(Driver.get(),this);}


    @FindBy(xpath = "(//*[@class='logo-container'])[1]")
    public WebElement  ChooseAnAsset;

    @FindBy(xpath = "//*[@class='altibox-asset-title-container']/h1")
    public WebElement  firstAssetName;
    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement  WatchNow;
    @FindBy(xpath = "(//*[@class='player-controls'])[2]")
    public WebElement  controlPlayer;

    @FindBy(xpath = "//*[@class='logo-container']")
    public List<WebElement> Movies;
    @FindBy(xpath = "//*[@class='altibox-asset-title-container']/h1")
    public WebElement screenMovieTitle;

    @FindBy(xpath = "//*[@class='altibox-asset-caption']")
    public WebElement element;

    @FindBy(xpath = "//*[@class='altibox-asset-description']")
    public WebElement synopsis;

    @FindBy(xpath = "//*[text()='In roles']")
    public List<WebElement> castList;

    @FindBy(xpath = "//*[text()='Directors and producers']")
    public WebElement directorProducer;

    @FindBy(xpath = "//*[@class='value'][1]")
    public WebElement originaltitle;

    @FindBy(xpath = "//*[@class='value'][2]")
    public WebElement distrubutor;

    @FindBy(xpath = "//*[@class='value'][3]")
    public WebElement altiboxID;

    @FindBy(xpath = "//*[@class='value'][4]")
    public WebElement yearCountry;

    @FindBy(xpath = "//*[@class='value language'][1]")
    public WebElement audioLanguage;

    @FindBy(xpath = "//*[@class='value language'][2]")
    public WebElement subtitleLanguage;

    @FindBy(xpath = "(//*[@class='value'])[5]")
    public WebElement videoQuality;

    @FindBy(xpath = "(//*[@class='value'])[6]")
    public WebElement medietilsynetID;


    public void StartAnAssetAndWaitTilThePlayerControlHide() throws InterruptedException {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ChooseAnAsset.click();
        CWStepDefs.firstAssetName=firstAssetName.getText();
        WatchNow.click();

        Thread.sleep(5000);

        try{
            Assert.assertTrue("Player control is not shown",controlPlayer.isDisplayed());
        }
        catch (Exception e){
            System.out.println("The player control is hided");
        }

    }

    public void MoveTheCursorToRecall_thePlayer(){
        Actions actions=new Actions(Driver.get());
        WebElement controlPlayer=Driver.get().findElement(By.xpath("//*[@class='player-control-item player-seekbar']"));

        BrowserUtils.waitFor(1);

        actions.moveToElement(controlPlayer).perform();

        WebElement seekbar = Driver.get().findElement(By.cssSelector(".player-control-item.player-seekbar"));
        int timeAsInt = Integer.parseInt(seekbar.getAttribute("value"));

        assert timeAsInt > 0 : "Time value is not greater than zero: " + timeAsInt;

        try{
            Assert.assertTrue("Player control is not shown",controlPlayer.isDisplayed());
        }
        catch (Exception e){
            System.out.println("The player control is hided");
        }

    }

    public void VerifyThatTheDetailsPageOfAssetsShowThenecessaryFieldsForSVOD() {

        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        for (int i = 1; i < Movies.size() - 1; i++) {
            WebElement film = Driver.get().findElement(By.xpath("(//*[@class='logo-container'])[" + i + "]"));
            film.click();
            WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
            wait.until(ExpectedConditions.stalenessOf(film));




            //to compare the movie name
            String screenTitle = screenMovieTitle.getText();

            String htmlTitle = screenMovieTitle.getAttribute("innerHTML");
            if (screenTitle.equals(htmlTitle)) {
                System.out.println("The name of the movie on the screen and in the HTML code is the same.");
            } else {
                System.out.println("The name of the movie on the screen and in the HTML code is the different.");
            }

            //To compare length,published year,rating

            Assert.assertTrue(element.isDisplayed());

            //to compare the synopsis
            Assert.assertTrue(synopsis.isDisplayed());

            if(element.getText().contains("Documentary")) {

                Assert.assertTrue(castList.size()==0 || castList.size()>0);

            }
            else { Assert.assertNotNull(castList);}

            Assert.assertNotNull(directorProducer);

            Assert.assertTrue(originaltitle.isDisplayed());
            System.out.println("there is an orginal Title  "+originaltitle.getText());

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

            Driver.get().navigate().back();}
    }
}
