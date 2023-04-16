package no.altibox.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.GlobalSearchPage;

public class GlobalSearchingStepDefs {

    @When("Click VOD from bottom menu")
    public void Click_VOD_From_Bottom_menu(){
        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.ClickVODFromBottomMenu();

    }
    @Then("verify Search box is located on the top right corner in navigation bar")
    public void Verify_Search_box_is_located_on_the_top_right_corner_in_navigation_bar(){
        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.verifySearchBoxIsLocatedOnTheTopRightCornerInNavigationBar();

    }
    @When("Click on the search box")
    public void click_on_the_search_box(){
        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.ClickOntheSearchBox();

    }

    @Then("Verify that Search field and Info text inside the box")
    public void Verify_that_search_field_and_info_text_inside_the_box(){

        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.verifyThatSearchFieldandInfoTextInsideThebox();

    }

    @When("Search a string")
    public void Search_a_string(){
        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.SearchAString();

    }

    @Then("Verify that search results are grouped and listed")
    public void Verify_that_search_results_are_grouped_and_listed(){

        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.VerifyThatsearchResultsAreGroupedAndListed();

    }
    @When("Enter a search that do not lead to a results")
    public void Enter_A_Search_That_Do_Not_Lead_To_A_Results(){
        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.EnterASearchThatDoNotLeadToAResults();

    }

    @Then("Info text indicating that search gave no results")
    public void Info_Text_Indicating_That_Search_Gave_No_Results(){

        GlobalSearchPage globalSearchPage=new GlobalSearchPage();
        globalSearchPage.InfoTextIndicatingThatSearchGaveNoResults();
    }


}
