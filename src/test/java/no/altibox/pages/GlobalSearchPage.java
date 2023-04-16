package no.altibox.pages;

import io.cucumber.java.en.When;
import no.altibox.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;
import java.util.List;

public class GlobalSearchPage {
    public GlobalSearchPage(){
        PageFactory.initElements(Driver.get(),this);

    }
    @FindBy(xpath = "(//*[@class='sticky-low priority']/span)[1]")
    public WebElement MoviesAndSeries;
    @FindBy(xpath ="//*[@class='searchField']")
    public WebElement SearchBox;
    @FindBy(xpath = "//*[@class='searchInput']")
    public WebElement SearchInput;
    @FindBy(xpath = "//*[@class='searchIcon']")
    public WebElement SearchIcon;
    @FindBy(xpath = "//*[@class='searchInput']")
    public WebElement TitleInsideSearch;

    @FindBy(xpath = "(//*[@class='searchResults']/h3)[1]")
    public WebElement ResultInMOviesTitle;
    @FindBy(xpath = "(//*[@class='searchResults']/h3)[2]")
    public WebElement OtherSearchtitle;

    @FindBy(xpath = "(//*[@class='searchResults']/h3)[3]")
    public WebElement ResultActorTitle;
    @FindBy(xpath = "(//*[@class='searchResults']/h3)[4]")
    public WebElement ResultDirectorTitle;
    @FindBy(xpath = "(//*[@class='searchIcon'])[2]")
    public WebElement MidtSearchSign;

    @FindBy(xpath = "//*[@class='no-results']")
    public WebElement NoResult;


    public void ClickVODFromBottomMenu(){
        MoviesAndSeries.click();
    }

    public void verifySearchBoxIsLocatedOnTheTopRightCornerInNavigationBar(){
        SearchBox.isDisplayed();

    }
    public void ClickOntheSearchBox(){
        SearchInput.click();
    }

    public void verifyThatSearchFieldandInfoTextInsideThebox(){

      SearchInput.isDisplayed();
      SearchIcon.isDisplayed();


        String placeholderText = TitleInsideSearch.getAttribute("placeholder");
        System.out.println(placeholderText);

    }

    public void SearchAString(){
        SearchInput.sendKeys("a");

    }
    public void VerifyThatsearchResultsAreGroupedAndListed(){
        Assert.assertTrue(ResultInMOviesTitle.getText().contains("Results in Movies and series"));
        System.out.println(ResultInMOviesTitle.getText());
        List<WebElement> ResultInMovies = Driver.get().findElements(By.xpath("(//*[@class='items-container items-container-grid'])[1]/div"));
        Assert.assertTrue(ResultInMovies.size()>0);
        System.out.println(ResultInMovies.size());


        Assert.assertTrue(OtherSearchtitle.getText().contains("Other relevant results"));
        System.out.println(OtherSearchtitle.getText());
        List<WebElement> OtherResult=Driver.get().findElements(By.xpath("(//*[@class='items-container items-container-grid'])[2]/div"));
        Assert.assertTrue(OtherResult.size()>0);
        System.out.println(OtherResult.size());


        Assert.assertTrue(ResultActorTitle.getText().contains("Actors"));
        System.out.println(ResultActorTitle.getText());
        List <WebElement> ResultActor=Driver.get().findElements(By.xpath("(//*[@class='cast-flex'])[1]/a/div"));
        Assert.assertTrue(ResultActor.size()>0);
        System.out.println(ResultActor.size());

        Assert.assertTrue(ResultDirectorTitle.getText().contains("Directors and producers"));
        System.out.println(ResultDirectorTitle.getText());
        List<WebElement> ResultDirector=Driver.get().findElements(By.xpath("(//*[@class='cast-flex'])[2]/a/div"));
        Assert.assertTrue(ResultDirector.size()>0);
        System.out.println(ResultDirector.size());
    }
    public void EnterASearchThatDoNotLeadToAResults(){
        SearchInput.sendKeys("abcdefghx");
    }
    public void InfoTextIndicatingThatSearchGaveNoResults(){
        Assert.assertTrue(MidtSearchSign.isDisplayed());

        Assert.assertTrue(NoResult.getText().contains("We can not find any results for"));

    }

}













