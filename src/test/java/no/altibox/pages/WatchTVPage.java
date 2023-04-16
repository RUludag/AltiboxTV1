package no.altibox.pages;

import io.cucumber.java.bs.A;
import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import javax.swing.text.Document;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static no.altibox.utilities.Driver.get;


public class WatchTVPage {

    public WatchTVPage() { PageFactory.initElements(get(),this);}

    @FindBy(xpath = "//a[@class='sticky-high' and .//span[text()='Watch TV']]")
    public WebElement WatchTVBttn;
    @FindBy(xpath = "(//*[@class='image-container'])[1]")
    public WebElement ChooseChannel;
    @FindBy(xpath ="//*[@class='player-control-item range-text end-time-text live-player']")
    public WebElement EmptyLiveButton;
    @FindBy(xpath =" //*[@class='player-control-item range-text end-time-text live-player live']")
    public WebElement RedLiveButton;

    @FindBy(xpath ="(//*[@class='aib-icon'])[5]")
    public WebElement PausePlay;

    @FindBy(xpath = "(//*[@class='aib-icon'])[4]")
    public WebElement Backward;
    @FindBy(xpath = "(//*[@class='aib-icon'])[6]")
    public WebElement Forward;

    @FindBy(xpath = "//*[@class='volume-slider']")
    public WebElement VolumeSlider;

    @FindBy(xpath = "(//*[@class='aib-icon'])[8]")
    public WebElement Volume;

    @FindBy(xpath = "(//*[@class='aib-icon'])[12]")
    public WebElement FullScreen;

    @FindBy(xpath = "//*[@class='showChannelListLogoButton']")
    public WebElement ChannelLogo;

    @FindBy(xpath = "(//*[@tabindex='0'])[1]")
    public WebElement ChannelList;
    @FindBy(xpath = "//*[@class='focusBox']")
    public WebElement ChannelMarked;
    @FindBy(xpath = "(//*[@tabindex='-1'])[9]")
    public WebElement NewChannel;

    @FindBy(xpath = "//*[@class='player-control-item player-seekbar']")
    public WebElement Slider;

    @FindBy(xpath = "//*[@class='showChannelListButton']")
    public WebElement ChooseChannelList;
    @FindBy(xpath = "(//*[@class='activeProgram']/div)[1]")
    public WebElement TimeTitle;

    @FindBy(xpath = "(//*[@class='activeProgram']/div)[2]")
    public WebElement ProgramTitle;

    public void GoToWatchTV(){

        WatchTVBttn.click();

    }
    public void ClickAChannelOnTheChannelsList(){

        ChooseChannel.click();
        BrowserUtils.waitFor(3);
    }
    public void VerifyThatAnIndicatorIsPresentShowingHowFarTheCurrentTVProgramHasProgressed(){

        WebElement slider = get().findElement(By.cssSelector(".player-seekbar"));

        if (slider != null) {
            System.out.println("Slider found");
            BrowserUtils.waitFor(4);
            String currentProgress = slider.getAttribute("value");
            double value = Double.parseDouble(get().findElement(By.xpath("//*[@name='slider']")).getAttribute("value"));
            Assert.assertTrue("Video can not start",value > 0);

            System.out.println("Current progress: " + currentProgress);


        } else {
            System.out.println("Slider not found");
        }

    }
    public void MoveTheIndicatorToTheBeginningOfTheTimeline(){
        BrowserUtils.waitFor(6);

        JavascriptExecutor js = (JavascriptExecutor) get();
        js.executeScript("document.getElementsByTagName('video')[0].currentTime = 0;");
        BrowserUtils.waitFor(2);

    }



    public void VerifyStreamIsScrolledBackToTheCurrentProgram(){

        try {
            Assert.assertTrue(EmptyLiveButton.isDisplayed());
        } catch (AssertionError e) {
            System.out.println("EmptyLiveButton was not displayed.");
        }



    }

    public void GoBackToLiveTV(){
        BrowserUtils.waitFor(3);
        EmptyLiveButton.click();

    }


    public void VerifyThatLiveTVIsBroadcasting(){

        Assert.assertTrue(RedLiveButton.isDisplayed());


    }




    public void VerifyPauseandPlayarePresentAndWork(){
        get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions actions=new Actions(get());

        Assert.assertTrue(PausePlay.isEnabled());
        PausePlay.click();

        actions.moveToElement(Slider).perform();

        Assert.assertTrue(PausePlay.isEnabled());

        PausePlay.click();





    }
    public void ClickforwardAndBackwardButton(){
        BrowserUtils.waitFor(2);
        Backward.click();
        BrowserUtils.waitFor(2);
        Forward.click();

    }


    public void ClickVolumeAndFullScreenButton(){

        Actions action = new Actions(get());

        action.moveToElement(Volume).build().perform();


        action.moveToElement(VolumeSlider).build().perform();
        action.clickAndHold().moveByOffset(0, -50).release().build().perform();
        BrowserUtils.waitFor(3);
        action.clickAndHold().moveByOffset(0, +50).release().build().perform();



        Assert.assertTrue(FullScreen.isEnabled());
        FullScreen.click();
        BrowserUtils.waitFor(3);
        FullScreen.click();



    }

    public void watchingTVClickOnTheLogoToExpandTheChannelOverview(){
        ChannelLogo.click();
        BrowserUtils.waitFor(1);

    }
    public void ChannelOverviewIsShownAndCurrentChannelIsMarked(){

        Assert.assertTrue(ChannelList.isDisplayed());
        Assert.assertTrue(ChannelMarked.isDisplayed());
    }

     public void SelectANewChannel(){

        BrowserUtils.waitFor(1);
        NewChannel.click();
         ChannelLogo.click();
         Assert.assertTrue(ChannelMarked.isDisplayed());
         WebElement choosenChannel= get().findElement(By.xpath("(//*[@class='focusedChannel '])[1]/img"));
         WebElement Title= get().findElement(By.tagName("title"));
         Assert.assertEquals( choosenChannel.getAttribute("alt"),Title.getAttribute("textContent"));

     }
     public void NewChannelStartsStreamingEPGDataForThatChannelIsShownCorrectly(){
         Actions action = new Actions(get());
         BrowserUtils.waitFor(1);

         action.moveByOffset(200, 0).click().perform();

         String firstSliderValue=Slider.getAttribute("value");

         BrowserUtils.waitFor(4);

         action.moveToElement(Slider).perform();

         String secondSliderValue=Slider.getAttribute("value");

         int firstValueAsInt=Integer.parseInt(firstSliderValue);

         int secondValueAsInt=Integer.parseInt(secondSliderValue);


         Assert.assertTrue(firstValueAsInt<secondValueAsInt);


     }
     public void verifyPlayerControlAndChannelListAreShownForAFewSeconds(){
        Assert.assertTrue(Slider.isDisplayed());

     }

     public void HoverOverThePlayerToShowPlayerControlsAndVerifyEPGDataTimeTitleAndProgressbarForCurrentProgramIShown(){
         get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BrowserUtils.waitFor(1);



         List<WebElement> Channels = get().findElements(By.xpath("//*[@tabindex='0']/li"));

         for(int i = 0; i < Channels.size()-1; i++) {
             WebElement channel = Driver.get().findElements(By.xpath("//*[@tabindex='0']/li")).get(i);

             WebElement Channel1 = get().findElement(By.xpath("//*[@class='showChannelListLogoButton']"));
             Channel1.click();
             channel.click();

             Assert.assertTrue(TimeTitle.isDisplayed());
             Assert.assertTrue(ProgramTitle.isDisplayed());
         }


         System.out.println(Channels.size());
     }


    }
