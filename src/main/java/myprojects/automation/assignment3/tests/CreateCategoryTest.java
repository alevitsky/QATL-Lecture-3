package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;

import org.openqa.selenium.WebDriver;

import static myprojects.automation.assignment3.utils.Properties.getLogin;
import static myprojects.automation.assignment3.utils.Properties.getPassword;

public class CreateCategoryTest extends BaseScript {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getConfiguredDriver();        
        GeneralActions actions = new GeneralActions(driver);
        String categoryName = getCategoryName();

        try {
            // login
            actions.login(getLogin(), getPassword());

            // create category
            actions.waitForContentLoad(actions.createCategory(categoryName));

            // check the presence of "Created" message
            actions.assertStatusMessage("Создано");

            // filter Categories table by name
            actions.filterByName(categoryName);
            
            // check that new category appears in Categories table
            actions.assertCategoryPresence(categoryName);
        } finally {
            // finish script
            driver.quit();
        }

    }
}
