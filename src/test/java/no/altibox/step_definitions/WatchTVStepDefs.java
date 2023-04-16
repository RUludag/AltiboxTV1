package no.altibox.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.WatchTVPage;

public class WatchTVStepDefs {

    @Then("Go to Watch TV")
    public void go_to_Watch_TV() {
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.GoToWatchTV();
    }

    @Then("Click a channel on the channels list")
    public void click_a_channel_on_the_channels_list() {
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.ClickAChannelOnTheChannelsList();
           }

    @Then("Verify that an indicator is present showing how far the current TV program has progressed")
    public void verify_that_an_indicator_is_present_showing_how_far_the_current_TV_program_has_progressed() {
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.VerifyThatAnIndicatorIsPresentShowingHowFarTheCurrentTVProgramHasProgressed();

    }
    @When("Move the indicator to the beginning of the timeline")
    public void Move_the_indicator_to_the_beginning_of_the_timeline(){

        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.MoveTheIndicatorToTheBeginningOfTheTimeline();
    }

    @Then ("Verify Stream is scrolled back to the start of the current program")
    public void  Verify_Stream_is_scrolled_back_to_the_start_of_the_current_program(){

        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.VerifyStreamIsScrolledBackToTheCurrentProgram();
    }

    @When("Go back to live tv")
    public void Go_back_to_live_tv(){
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.GoBackToLiveTV();


    }
    @Then("Verify that Live tv is broadcasting")
    public void Verify_that_Live_tv_is_broadcasting(){
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.VerifyThatLiveTVIsBroadcasting();

    }

    @When("Verify Pause and play are present and work")
    public void verify_Pause_and_play_are_present_and_work() {
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.VerifyPauseandPlayarePresentAndWork();

    }
    @Then("Click forward and backward button")
    public void Click_forward_and_backward_button(){
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.ClickforwardAndBackwardButton();


    }

    @When("Click volume and full-screen button")
    public void click_volume_and_full_screen_button() {

        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.ClickVolumeAndFullScreenButton();


    }

    @When("watching TV, click on the channel logo to expand the channel overview")
    public void watching_TV_Click_on_the_channel_logo_to_expand_the_channel_overview(){

        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.watchingTVClickOnTheLogoToExpandTheChannelOverview();
    }


    @Then("Channel overview is shown and current channel is marked")
    public void Channel_overview_is_shown_and_Current_channel_is_marked(){

        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.ChannelOverviewIsShownAndCurrentChannelIsMarked();

    }
    @When("Select a new channel")
    public void select_a_new_channel(){
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.SelectANewChannel();


    }
    @Then("New channel starts streaming, EPG data for that channel is shown correctly")
    public void new_channel_starts_streaming_Epg_data_for_the_channel_is_shown_correctly(){

        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.NewChannelStartsStreamingEPGDataForThatChannelIsShownCorrectly();

    }
    @Then("verify Player control and channel list are shown for a few seconds")
    public void verifyPlayerControlAndChannelListAreShownForAFewSeconds(){
        WatchTVPage watchTVPage =new WatchTVPage();
        watchTVPage.verifyPlayerControlAndChannelListAreShownForAFewSeconds();

    }
     @When("Hover over the player to show player controls and Verify EPG data time, title, and progressbar for current program is shown")
    public void HoverOverThePlayerToShowPlayerControlsAndVerifyEPGDataTimeTitleAndProgressbarForCurrentProgramIShown(){

         WatchTVPage watchTVPage =new WatchTVPage();
         watchTVPage.HoverOverThePlayerToShowPlayerControlsAndVerifyEPGDataTimeTitleAndProgressbarForCurrentProgramIShown();

     }














    }
