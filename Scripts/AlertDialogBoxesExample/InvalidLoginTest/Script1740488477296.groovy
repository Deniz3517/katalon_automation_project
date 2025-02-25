import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()


WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.siteURL)


WebUI.comment("opened page: " + GlobalVariable.siteURL)


WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/p_Consent'), FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/a_Signup  Login'), FailureHandling.STOP_ON_FAILURE)


WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_Login to your account_email'),
	'deniz1231@hotmail.net', FailureHandling.STOP_ON_FAILURE)


WebUI.setEncryptedText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_Login to your account_password'),
	'CSt51UwWECc=', FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/button_Login'), FailureHandling.STOP_ON_FAILURE)

// **1. Check if an alert appears**
if (WebUI.waitForAlert(3, FailureHandling.OPTIONAL)) {
	// **2. Get the alert text**
	String alertText = WebUI.getAlertText()

	// **3. Verify the alert message**
	WebUI.verifyMatch(alertText, 'Your email or password is incorrect!', false, FailureHandling.STOP_ON_FAILURE)

	// **4. Close the alert**
	WebUI.acceptAlert()
} else {
	WebUI.comment('❌ No alert appeared, checking for on-screen error message...')
}

// **Verify error message on the page**
WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/p_Your email or password is incorrect'),
	'Your email or password is incorrect!', FailureHandling.STOP_ON_FAILURE)


WebUI.closeBrowser()


