package myprojects.automation.assignment3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class AdminCategoriesPage extends Page {
    @CacheLookup
    @FindBy(id = "page-header-desc-category-new_category")
    private WebElement newCategoryLink;

    @CacheLookup
    @FindBy(name = "categoryFilter_name")
    private WebElement categoryName;

    @CacheLookup
    @FindBy(id = "submitFilterButtoncategory")
    private WebElement submitFilter;

    @CacheLookup
    @FindBy(xpath = "//*[@class = 'alert alert-success']")
    private WebElement statusMessage;

    public AdminCategoriesPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public AdminCategoriesPage waitLoadFinished() {
        waitPageLoader();
        return this;
    }
    
    public AddCategoryPage openAddCategoryForm() {
        newCategoryLink.click();
        return PageFactory.initElements(getDriver(), AddCategoryPage.class);
    }

    public AdminCategoriesPage fillCategoryName(final String name) {
        categoryName.sendKeys(name);
        return this;
    }

    public AdminCategoriesPage performSearch() {
        submitFilter.click();
        return this;
    }

    public boolean hasFoundCategory(final String categoryName) {
        String expr = String.format("//*/td[@class = 'pointer' and contains(text(),'%s')]", categoryName);
        WebElement filteredCategory = getDriver().findElement(By.xpath(expr));
        return filteredCategory.isDisplayed();
    }

    public boolean containsStatusMessage(final String msg) {
        getWait().until(visibilityOf(statusMessage));
        return statusMessage.getText().contains(msg);
    }

}