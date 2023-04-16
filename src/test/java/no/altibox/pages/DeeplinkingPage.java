package no.altibox.pages;

import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeeplinkingPage {
    public DeeplinkingPage() { PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "(//*[@class='sticky-high'])[2]")
    public WebElement ProgramArchive;

    @FindBy(xpath = "(//*[@class='styles_channelContainer__t2mIj'])[1]")
    public WebElement NRK;
    @FindBy(xpath = "(//*[@class='logo-container'])[1]")
    public WebElement NRKChannel;

    @FindBy(xpath = "//*[@class=' buttons_buttonPrimary__0Z8oz']")
    public WebElement NRKWatch;

    public void NavigatetoProgramarchiveandselectaprogramfromNRK(){

        ProgramArchive.click();
        NRK.click();
        NRKChannel.click();


    }

    public void VerifyTheplaybuttonismarkedwithPlayinNRKTVorsimilar(){

        String WatchButton = Driver.get().findElement(By.xpath("//*[@class='altibox-asset-cta-button']")).getText();
        System.out.println(WatchButton+"title on the watch button");
        Assert.assertTrue(WatchButton.contains("NRK"));
    }

    public void ClickPlayinNRKapp(){

        WebElement Nyhetmorgen=Driver.get().findElement(By.xpath("//h1"));
        String NyhetmorgenText = Nyhetmorgen.getText();
        System.out.println(NyhetmorgenText+"Main title on the detail panel");

        NRKWatch.click();

    }



    public void VerifyTheprogramisopenedonawebpage(){


        WebElement NRKTitle =Driver.get().findElement(By.xpath("//h1[contains(@class,'tv-series-hero__title')]"));

        String actualText = NRKTitle.getText();
        String expectedText = "Nyhetsmorgen";

        Assert.assertTrue("Element includes 'Nyhetsmorgen' ", actualText.contains(expectedText));

    }

}
