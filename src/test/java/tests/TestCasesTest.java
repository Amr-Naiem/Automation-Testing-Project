package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestCasesPage;

public class TestCasesTest extends BaseTest {
    
    TestCasesPage testCasesPage;

    @Test
    public void testVerifyTestCasesPage() {
    	// Step 1: Initialize the TestCasesPage object
        testCasesPage = new TestCasesPage(driver);
        
        // Step 2: Verify that the home page is visible successfully
        String homePageTitle = driver.getTitle();
        Assert.assertTrue(homePageTitle.contains("Automation Exercise"), "Home page is not visible");

        // Step 3: Click on the 'Test Cases' button
        testCasesPage.testCasesTittleClick();

        // Step 4: Verify that the user is navigated to the Test Cases page successfully
        Assert.assertTrue(testCasesPage.isTestCasesPageVisible(), "User is not navigated to the test cases page successfully");
    }
}
