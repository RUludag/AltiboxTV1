package no.altibox.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.CatchUpPage;

public class CatchUpStepDefs {

    @Then("Choose a program from Program Archive")
    public void choose_a_program_from_Program_Archive() {

        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.ChooseAProgramFromProgramArchive();
    }


    @Then("Verify the detail panel displays all available seasons and episodes.Different seasons can be selected to list episodes in the selected season")
    public void verify_the_detail_panel_displays_all_available_seasons_and_episodes_Different_seasons_can_be_selected_to_list_episodes_in_the_selected_season() {

        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.VerifyTheDetailPanelDisplaysAllAvailableSeasonsAndEpisodesDifferentSeasonsCanBeSelectedToListEpisodesInTheSelectedSeason();

    }
    @When("Play an asset and return episodes list")
    public void play_an_asset_and_return_episodes_list() {

    }

    @Then("Verify The partly viewed episode displays with a progress bar")
    public void verify_The_partly_viewed_episode_displays_with_a_progress_bar() {

    }
    @When("Start a program")
    public void start_a_program(){
        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.StartAProgram();

    }

    @When ("Press pause")
    public void press_pause(){

        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.PressPause();

    }

    @Then("Click forward button")
    public void click_forward_button(){

        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.ClickForwardButtonAndVerifyThePlaybackResumesWithCorrectDecodingAndNoLag();

    }



    @When("Scroll up and down in the episodes list and verify Scrolling works normally and the seasons and episodes can easily be navigated in")
    public void Scroll_up_and_down_in_the_episodes_list_and_verify_Scrolling_works_normally_and_the_seasons_and_episodes_can_easily_be_navigated_in(){

        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.ScrollUpAndDownInTheEpisodesListAndVerifyScrollingWorksNormallyAndTheSeasonsAndEpisodesCanEasilyBeNavigatedIn();

    }

    @When("Select one of the episodes to start playing")
    public void Select_one_of_the_episodes_to_start_playing(){


        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.SelectOneOfTheEpisodesToStartPlaying();

    }


    @Then("The episode plays normally")
    public void The_episode_plays_normally(){
        CatchUpPage catchUpPage=new CatchUpPage();
        catchUpPage.TheEpisodePlaysNormally();
    }



}
