package no.altibox.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class BrowserUtils {

    /**
     * Performs a pause
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static WebElement getShadowRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor)Driver.get())
                .executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }

    public static WebElement shadowDom;
    public static void findByShadowRoot() {
        shadowDom = getShadowRootElement(
                Driver.get().findElement(By.id("whatEverTheShadowDomIdIs")));
    }





}
