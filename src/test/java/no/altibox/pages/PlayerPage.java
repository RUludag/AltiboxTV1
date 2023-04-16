package no.altibox.pages;

import no.altibox.utilities.BrowserUtils;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PlayerPage {
    public PlayerPage() { PageFactory.initElements(Driver.get(),this);}


    @FindBy(xpath = "//*[@class='volume-slider']")
    public WebElement VolumeSlider;

    @FindBy(xpath = "(//*[@class='aib-icon'])[8]")
    public WebElement Volume;
    @FindBy(xpath = "(//*[@class='aib-icon'])[12]")
    public WebElement FullScreen;

    @FindBy(xpath = "(//*[@class='logo-link'])[1]")
    public WebElement AltiboxLogo;

    public void ClickTheOpenFullScreenSymbol(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(FullScreen.isEnabled());
        FullScreen.click();


    }

    public void ClickTheRestoreFromFullScreenButtonToGoBackToEmbeddedMode(){
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertTrue(FullScreen.isEnabled());
        FullScreen.click();
    }


    public void ClickESCAndGoBackToEmbeddedMode(){

        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions actions = new Actions(Driver.get());

        WebElement videoElement=Driver.get().findElement(By.xpath("//*[@class='outer-video-container']"));
        actions.moveToElement(videoElement)
                .click()
                .build()
                .perform();
        actions.sendKeys(Keys.ESCAPE)
                .build()
                .perform();
        Assert.assertTrue(AltiboxLogo.isDisplayed());

    }

    public void MoveTheMouseOverTheVolumeControl(){
        Actions action = new Actions(Driver.get());

        action.moveToElement(Volume).build().perform();
        action.moveToElement(VolumeSlider).build().perform();

        Actions actions = new Actions(Driver.get());



        actions.click(VolumeSlider).build().perform();
        actions.dragAndDropBy(VolumeSlider, 0, -100).build().perform();
        BrowserUtils.waitFor(2);

        actions.moveToElement(Volume).build().perform();
        actions.moveToElement(VolumeSlider).build().perform();
        actions.dragAndDropBy(VolumeSlider, 0, 100).build().perform();
    }

    public void VerifyVolumeSliderAppears(){

        Assert.assertTrue(Volume.isDisplayed());

    }



    public void MoveTheMousePointerAwayFromTheVolumeSlider()  {

        BrowserUtils.waitFor(1);
        Actions actions = new Actions(Driver.get());
        actions.clickAndHold(VolumeSlider)
                .moveByOffset(-100, 0) // move 100 pixels to the left
                .release()
                .build()
                .perform();

    }


    public void VerifyTheVolumeSliderShouldDisappearAfterASecond(){
        BrowserUtils.waitFor(2);
        try {
            assert !VolumeSlider.isEnabled() : "Volume slider is not disabled";
        } catch (AssertionError error) {
            System.out.println(error.getMessage());
        }
    }


}
