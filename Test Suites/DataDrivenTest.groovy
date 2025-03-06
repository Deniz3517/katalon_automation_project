import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

import com.kms.katalon.core.annotation.SetUp
import com.kms.katalon.core.annotation.SetupTestCase
import com.kms.katalon.core.annotation.TearDown
import com.kms.katalon.core.annotation.TearDownTestCase
import com.kms.katalon.core.webui.driver.DriverFactory

/**
 * Setup test suite environment - Open browser and navigate to the site
 */
@SetUp(skipped = false) // Set skipped = false to activate this method
def setUp() {
	WebUI.comment("===== TEST STARTING: Opening Browser =====")
	
	WebUI.openBrowser('')
	WebUI.maximizeWindow()
	
	// Navigate to the site URL from Global Variable
	WebUI.navigateToUrl(GlobalVariable.siteURL)
	
	WebUI.comment("===== Navigated to: " + GlobalVariable.siteURL + " =====")
}

/**
 * Clean up test suite environment - Close the browser after the test suite completes
 */
@TearDown(skipped = false)
def tearDown() {
	WebUI.comment("===== TEST COMPLETED: Closing Browser =====")
	
	// Close the browser if it is still open
	if (DriverFactory.getWebDriver() != null) {
		WebUI.closeBrowser()
	}
}

/**
 * Run before each test case starts - Setup for each test case
 */
@SetupTestCase(skipped = false)
def setupTestCase() {
	WebUI.comment("===== Starting New Test Case =====")
}

/**
 * Run after each test case ends - Actions after each test case
 */
@TearDownTestCase(skipped = false)
def tearDownTestCase() {
	// If the test fails, take a screenshot and stop the test
	if (WebUI.getLastCheckpointStatus() == FailureHandling.STOP_ON_FAILURE) {
		WebUI.comment("️ Test Failed! Taking Screenshot...")
		WebUI.takeScreenshot()
		throw new AssertionError("Test Case Failed, Stopping Execution!")
	}
	
	WebUI.comment("===== Test Case Completed =====")
}
