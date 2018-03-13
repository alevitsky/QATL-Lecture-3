package myprojects.automation.assignment3.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AddCategoryPage extends Page {
    @CacheLookup
    @FindBy(id = "name_1")
    private WebElement categoryName;

    @CacheLookup
    @FindBy(id = "category_form_submit_btn")
    private WebElement saveButton;

    public AddCategoryPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AddCategoryPage waitLoadFinished() {
        waitPageLoader();
        return this;
    }

    public AddCategoryPage fillCategoryName(final String name) {
        categoryName.sendKeys(name);
        return this;
    }

    public AdminCategoriesPage clickSaveCategory() {
        getWait().until(elementToBeClickable(saveButton));
        scrollToElement(saveButton);
        saveButton.click();
        return PageFactory.initElements(getDriver(), AdminCategoriesPage.class);
    }

    private void scrollToElement(final WebElement element) {
        int y = element.getLocation().getY();
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        String expr = String.format("window.scrollTo(0, %s)", y);
        executor.executeScript(expr);
    }

}