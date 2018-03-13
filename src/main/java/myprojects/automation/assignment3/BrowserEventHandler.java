package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BrowserEventHandler implements DefaultWebDriverEventListener {
    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Open the url: " + s);
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Search for the element: " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        if (webElement != null) {
            System.out.println("Found element " + webElement.getTagName());
        }
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Click on the element: " + webElement.getTagName() + " " + webElement.getAttribute("name"));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        String value = Arrays.stream(charSequences).map(CharSequence::toString).collect(Collectors.joining());
        System.out.printf("Change value of %s: %s\n", webElement.getTagName(), value);
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Changed element " + webElement.getTagName());
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        System.out.printf("The script: %s has been started\n", s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        System.out.printf("The script: %s has been executed\n", s);
    }
}
