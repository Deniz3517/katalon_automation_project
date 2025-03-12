import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable as GlobalVariable


WebUI.openBrowser('')
WebUI.maximizeWindow()

// Navigate to the site URL
WebUI.navigateToUrl(GlobalVariable.siteURL, FailureHandling.STOP_ON_FAILURE)
WebUI.comment("Opened page: " + GlobalVariable.siteURL)

// Navigate to another page
WebUI.navigateToUrl('https://www.automationexercise.com/', FailureHandling.STOP_ON_FAILURE)

// Click the Consent button
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/p_Consent'), FailureHandling.STOP_ON_FAILURE)

// Click on the page header
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/h1_AutomationExercise'), FailureHandling.STOP_ON_FAILURE)

// Verify the text of the header
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise/h1_AutomationExercise'), 'AutomationExercise', FailureHandling.STOP_ON_FAILURE)

// If the code reaches this point, it means the test passed
WebUI.comment('Test completed successfully!')

// Close the browser
WebUI.closeBrowser()