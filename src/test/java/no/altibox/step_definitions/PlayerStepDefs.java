package no.altibox.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import no.altibox.pages.PlayerPage;
import no.altibox.utilities.BrowserUtils;

public class PlayerStepDefs {
    @Then("Click the open full screen symbol")
    public void click_the_open_full_screen_symbol() {

        PlayerPage playerPage=new PlayerPage();
        playerPage.ClickTheOpenFullScreenSymbol();
        BrowserUtils.waitFor(3);
    }



    @When("Click the restore from full screen button to go back to embedded mode")
    public void click_the_restore_from_full_screen_button_to_go_back_to_embedded_mode() {
        PlayerPage playerPage=new PlayerPage();
        playerPage.ClickTheRestoreFromFullScreenButtonToGoBackToEmbeddedMode();

    }

    @Then("Click ESC and go back to embedded mode")
    public void click_ESC_and_go_back_to_embedded_mode() {

        PlayerPage playerPage=new PlayerPage();
        playerPage.ClickESCAndGoBackToEmbeddedMode();
    }

    @When ("Move the mouse cursor over the volume control button")
    public void Move_the_mouse_cursor_over_the_control_button(){

        PlayerPage playerPage=new PlayerPage();
        playerPage.MoveTheMouseOverTheVolumeControl();
    }


    @Then("Verify Volume slider appears")
    public void Verify_Volume_slider_appears(){
        PlayerPage playerPage=new PlayerPage();
        playerPage.VerifyVolumeSliderAppears();
    }

    @When("Move the mouse pointer away from the volume slider controls")
    public void Move_the_mouse_pointer_away_from_the_volume_slider_controls() {

        PlayerPage playerPage=new PlayerPage();
        playerPage.MoveTheMousePointerAwayFromTheVolumeSlider();
    }

    @Then("Verify the volume slider should disappear after a second")
    public void Verify_The_volume_Slider_should_disappear_after_a_second(){
        PlayerPage playerPage=new PlayerPage();
        playerPage.VerifyTheVolumeSliderShouldDisappearAfterASecond();
    }
}
