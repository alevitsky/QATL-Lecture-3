package myprojects.automation.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

/**
 * Place for the common behavior
 */
public abstract class Page {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @CacheLookup
    @FindBy(xpath = "//*[@class = 'icon-refresh icon-spin icon-fw']")
    private WebElement loader;

    public Page(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(getDriver(), 10);
        PageFactory.initElements(driver, this);
    }

    public abstract Page waitLoadFinished();

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait() {
        return wait;
    }

    protected WebElement getLoader() {
        return loader;
    }

    public void waitPageLoader() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(visibilityOf(loader));
        if (loader.isDisplayed()) {
            wait.until(not(visibilityOf(loader)));
        }
    }

}