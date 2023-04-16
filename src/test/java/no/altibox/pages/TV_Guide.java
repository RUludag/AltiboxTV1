package no.altibox.pages;

import io.cucumber.java.bs.A;
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
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TV_Guide {

    public TV_Guide() { PageFactory.initElements(Driver.get(),this);}


    @FindBy(xpath = "//*[text()='TV Guide']")
    public WebElement TV_GuideModule;

    @FindBy(xpath = "//*[@class='toggle-channel-playbill-button']")
    public WebElement showWholeDayButton;

    @FindBy(xpath = "//*[text()='Watch from start']")
    public WebElement WatchFromStartButton;

    @FindBy(xpath = "//*[@class='player-control-item player-seekbar']")
    public WebElement Slider;

    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement WatchChannelButton;

    @FindBy(xpath = "//*[text()='LIVE']")
    public WebElement LIVE;

    @FindBy(xpath = "(//*[@class='Dropdown-control'])[2]")
    public WebElement ChannelList;

    @FindBy(xpath = "(//*[@role='option'])[1]")
    public WebElement AllChannel;

    @FindBy(xpath = "//*[text()='Channels in my package']")
    public  WebElement MyPackage;

    public int getTotalNumberOfProgramsPerChannel(){
        return Driver.get().findElements(By.xpath("//*[@class='program-info']")).size();
    }

    public void ClickOnWatchFromStart() {
        WatchFromStartButton.click();
    }

    public void VerifyAtStart() throws InterruptedException {
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        /*Actions action=new Actions(Driver.get());
        action.moveToElement(Slider).perform();*/
        Thread.sleep(3000);
        String expectedResult=Slider.getAttribute("value");
        String actualResult=Slider.getAttribute("min");
        Assert.assertEquals(expectedResult,actualResult);

    }

    public void ClosePlayer() throws InterruptedException {
        Actions actions=new Actions(Driver.get());
        actions.moveToElement(TV_GuideModule).perform();
        Thread.sleep(1000);
        TV_GuideModule.click();

    }

    public void WatchChannel(){

        WatchChannelButton.click();
    }

    public void VerifyAtLive() throws InterruptedException {
        Actions action=new Actions(Driver.get());
        action.moveToElement(Slider).perform();
        Thread.sleep(2000);
        Assert.assertTrue(LIVE.isEnabled());


    }

    public void VerifyAllChannelsIsSelectedAndDisplayAllAvailableChannels(){

        ChannelList.click();
        BrowserUtils.waitFor(2);

        String ariaSelected = AllChannel.getAttribute("aria-selected");
        Assert.assertEquals("false", ariaSelected);


        List<WebElement> keyIcon = Driver.get().findElements(By.xpath("//*[@class='aib-icon lock-icon noselect']"));

        Assert.assertTrue(keyIcon.size()>0);

    }
    public void SelectTheOptionMyChannelAndVerifyMyChannelAreDisplayedWithChannelLogo(){

      MyPackage.click();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.get();
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        BrowserUtils.waitFor(3);

        List<WebElement> channels = Driver.get().findElements(By.xpath("//*[@class='logo-container']/a"));

        System.out.println("The number of elements in the list is: " + channels.size());

        for (WebElement channel : channels) {
            String classValue = channel.getAttribute("class");
            Assert.assertFalse(classValue.contains("lock-icon") && classValue.contains("noselect"));
            System.out.println("Channel logo container does not contain lock-icon and noselect classes: " + channel.getText());

        }
        System.out.println(channels.size());

    }}


