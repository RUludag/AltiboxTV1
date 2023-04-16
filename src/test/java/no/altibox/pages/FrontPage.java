package no.altibox.pages;

import io.cucumber.java.zh_cn.假如;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FrontPage {

    public FrontPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[text()='Movies and series']")
    public WebElement MoviesAndSeries;

    @FindBy(xpath = "(//*[@class='altibox-asset-list'])[8]/div[2]/div[1]")
    public WebElement FirstAssetOnMyContent;

    @FindBy(xpath = "//*[@title='New']")
    public WebElement PopularMovies;

    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement WatchFromButton;

    @FindBy(xpath = "(//*[@class='badge purchasing '])[1]")
    public WebElement BuyButton;

    @FindBy(xpath = "//*[@class='styles_buttonClose__G705L']")
    public WebElement CloseButton;

    @FindBy(xpath = "(//*[@alt='To the front page'])[1]")
    public WebElement HomeButton;

    @FindBy(xpath = "(//*[@class='vod-asset-title'])[1]")
    public WebElement FirstAssetOnMyContent1;

    @FindBy(xpath = "//*[@title='Available for rental']")
    public WebElement AvailableForRental;

    @FindBy(xpath = "(//*[text()='Rent in'])[1]")
    public WebElement RentButton;


    @FindBy(xpath = "((//*[@class='continue-watching']/div)[2]/div)[1]/div/a/div")
    public WebElement FirstAssetOnCW;

    @FindBy(xpath = "//*[@class='buttons_withProgressContainer__3afgb altibox-asset-cta-with-progress']")
    public WebElement CWButton;

    @FindBy(xpath = "//*[@title='My bought and rented']")
    public WebElement MyBoughtAndRented;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[4]/div[3]/div/div[1]/div/h1")
    public WebElement title;

    @FindBy(xpath = "(//*[@class='expandableText_expandableText__1xcCJ  '])[1]")
    public WebElement synopsis;

    @FindBy(xpath = "//*[@class='altibox-asset-caption']")
    public WebElement genre;


    @FindBy(xpath = "//*[@class='altibox-asset-title-link']/h3")
    public List<WebElement> swimlanes;

    public void VerifyThatDPShowsTitleGenreSynopsisAndAiringTime() {

        Assert.assertTrue(title.isDisplayed());
        Assert.assertTrue(synopsis.isDisplayed());
        Assert.assertTrue(genre.isDisplayed());
    }

    public void verifyThatBoughtMoviesOnTheFront_Page() {


        List<String> lanes = new ArrayList<>();

        for (WebElement swimlane : swimlanes) {
            String lane = swimlane.getText();
            lanes.add(lane);

        }

        System.out.println("lanes = " + lanes);
        Assert.assertTrue(lanes.contains("Popular movies"));
        Assert.assertTrue(lanes.contains("Popular series"));
    }


    public void purchaseMovie() throws InterruptedException {
        MoviesAndSeries.click();
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

        BuyButton.click();


        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();",CloseButton);
        HomeButton.click();

        Thread.sleep(3000);

        MyBoughtAndRented.click();


        String ActualFirst= FirstAssetOnMyContent1.getText();

        Assert.assertEquals(purchasedMovie,ActualFirst);

    }

    public void rentMovie() throws InterruptedException {
        MoviesAndSeries.click();
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BrowserUtils.clickWithJS(AvailableForRental);
        List<WebElement> films=Driver.get().findElements(By.xpath("//*[@class='vod-asset']"));

        String rentedMovie="";

        for(int i=0;i<films.size();i++) {
            if (films.get(i).getText().contains("BOUGHT")  || films.get(i).getText().contains("LEFT")) {
                continue;
            } else {
                rentedMovie+=films.get(i).getAttribute("title");

                films.get(i).click();
                break;
            }
        }

        Thread.sleep(2000);

        BrowserUtils.clickWithJS(WatchFromButton);


        RentButton.click();

        BrowserUtils.waitFor(2);
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();",CloseButton);

        HomeButton.click();

        Thread.sleep(3000);

        MyBoughtAndRented.click();

        Thread.sleep(2000);

        String ActualFirst= FirstAssetOnMyContent1.getText();

        Assert.assertEquals(rentedMovie,ActualFirst);

    }

    public void openAssetCW(){
        FirstAssetOnCW.click();
    }

    public void ClickOnCW(){
        CWButton.click();
    }








}
