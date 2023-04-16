package no.altibox.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.DeeplinkingPage;

public class DeepLinkingStepDefs {
    @When("Navigate to Program archive and select a program from NRK")
    public void Navigate_toProgram_archive_and_select_a_program_from_NRK(){

        DeeplinkingPage deeplinking=new DeeplinkingPage();
        deeplinking.NavigatetoProgramarchiveandselectaprogramfromNRK();

    }

    @Then("Verify The play button is marked with Play in NRK TV or similar")
    public void Verify_the_play_button_is_marked_with_play_in_NRK_Tv_or_similar(){
        DeeplinkingPage deeplinking=new DeeplinkingPage();
        deeplinking.VerifyTheplaybuttonismarkedwithPlayinNRKTVorsimilar();

    }

    @When ("Click Play in NRK app")
    public void Click_Play_in_NRK_app(){
        DeeplinkingPage deeplinking=new DeeplinkingPage();
        deeplinking.ClickPlayinNRKapp();

    }
    @Then("Verify The program is opened on a web page")
    public void Verify_The_program_is_opened_on_a_web_page(){

        DeeplinkingPage deeplinking=new DeeplinkingPage();
        deeplinking.VerifyTheprogramisopenedonawebpage();

    }

}
