package myprojects.automation.assignment3;

import myprojects.automation.assignment3.pages.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.String.format;

/**
 * Contains main script actions that may be used in scripts.
 */
public class GeneralActions {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private AdminLoginPage loginPage;
    private AdminDashboardPage dashboardPage;
    private AdminCategoriesPage categoriesPage;
    private AddCategoryPage addCategoryPage;

    public GeneralActions(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    /**
     * Logs in to Admin Panel.
     * 
     * @param login
     * @param password
     */
    public AdminDashboardPage login(final String login, final String password) {
        loginPage = new AdminLoginPage(driver);
        dashboardPage =
                loginPage.open()
                         .fillEmail(login)
                         .fillPassword(password)
                         .clickLoginButton();
        return dashboardPage;
    }

    /**
     * Adds new category in Admin Panel.
     * 
     * @param categoryName
     */
    public AdminCategoriesPage createCategory(final String categoryName) {
        checkIfAuthenticated();
        categoriesPage =
                dashboardPage.openCategoriesPage()
                             .waitLoadFinished()
                             .openAddCategoryForm()
                             .waitLoadFinished()
                             .fillCategoryName(categoryName)
                             .clickSaveCategory();
        return categoriesPage;
    }

    /**
     * Filters categories by name in the categories table.
     * @param categoryName
     */
    public AdminCategoriesPage filterByName(final String categoryName) {
        checkIfCategoriesPageOpened();
        categoriesPage.fillCategoryName(categoryName)
                      .performSearch();
        return categoriesPage;
    }

    /**
     * Asserts presence of the category creation message on the AddCategoryPage.
     * @param msg
     */
    public void assertStatusMessage(final String msg) {
        checkIfCategoriesPageOpened();
        if (!categoriesPage.containsStatusMessage(msg)) {
            String formattedMessage = format("The \"%s\" status message wasn't displayed", msg);
            throw new AssertionError(formattedMessage);
        }
    }

    /**
     * Asserts the presence of the category by name in the categories table.
     * @param categoryName
     */
    public void assertCategoryPresence(final String categoryName) {
        checkIfCategoriesPageOpened();
        if (!categoriesPage.hasFoundCategory(categoryName)) {
            String formattedMessage = format("The %s category wasn't found among the search results", categoryName);
            throw new AssertionError(formattedMessage);
        }
    }

    /**
     * Waits until page loader disappears from the page
     */
    public void waitForContentLoad(final Page page) {
        page.waitPageLoader();
    }

    private void checkIfAuthenticated() {
        if (dashboardPage == null) {
            throw new IllegalStateException("Please login before trying to create a new category.");
        }
    }

    private void checkIfCategoriesPageOpened() {
        if (categoriesPage == null) {
            throw new IllegalStateException("Please open Admin Categories Page before proceding any further.");
        }
    }

}
