package myprojects.automation.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class AdminDashboardPage extends Page {
    @CacheLookup
    @FindBy(id = "subtab-AdminCatalog")
    private WebElement catalogMenuItem;
    
    @CacheLookup
    @FindBy(id = "subtab-AdminCategories")
    private WebElement categoriesMenuItem;

    public AdminDashboardPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AdminDashboardPage waitLoadFinished() {
        waitPageLoader();
        return this;
    }

    public AdminCategoriesPage openCategoriesPage() {
        getWait().until(elementToBeClickable(catalogMenuItem));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(catalogMenuItem).click(categoriesMenuItem).build().perform();
        return PageFactory.initElements(getDriver(), AdminCategoriesPage.class);
    }
}