package myprojects.automation.assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * Use this interface as a stub implementation, if you want to implement a {@link WebDriverEventListener} and are
 * only interested in some events. The interface provides default implementations for all methods.
 */
public interface DefaultWebDriverEventListener extends WebDriverEventListener {

  default void beforeNavigateTo(String url, WebDriver driver) {
    // Do nothing.
  }

  default void afterNavigateTo(String url, WebDriver driver) {
    // Do nothing.
  }

  default void beforeNavigateBack(WebDriver driver) {
    // Do nothing.
  }

  default void afterNavigateBack(WebDriver driver) {
    // Do nothing.
  }

  default void beforeNavigateForward(WebDriver driver) {
    // Do nothing.
  }

  default void afterNavigateForward(WebDriver driver) {
    // Do nothing.
  }

  default void beforeNavigateRefresh(WebDriver driver) {
    // Do nothing.
  }

  default void afterNavigateRefresh(WebDriver driver) {
    // Do nothing.
  }

  default void beforeFindBy(By by, WebElement element, WebDriver driver) {
    // Do nothing.
  }

  default void afterFindBy(By by, WebElement element, WebDriver driver) {
    // Do nothing.
  }

  default void beforeClickOn(WebElement element, WebDriver driver) {
    // Do nothing.
  }

  default void afterClickOn(WebElement element, WebDriver driver) {
    // Do nothing.
  }

  default void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    // Do nothing.
  }

  default void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
    // Do nothing.
  }

  default void beforeScript(String script, WebDriver driver) {
    // Do nothing
  }

  default void afterScript(String script, WebDriver driver) {
    // Do nothing
  }

  default void onException(Throwable throwable, WebDriver driver) {
      throwable.printStackTrace();
  }
}