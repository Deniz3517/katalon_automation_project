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

// Navigate to the site URL
WebUI.navigateToUrl(GlobalVariable.siteURL, FailureHandling.STOP_ON_FAILURE)
WebUI.comment("Opened page: " + GlobalVariable.siteURL)

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/p_Consent'))

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/a_Contact us'))

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_name'), 'de')
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_email'), 'de@mail.com')
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_subject'), '111')
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/textarea_Get In Touch_message'), '123')

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_submit'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/div_Success Your details have been submitte_fc584e'),
	'Success! Your details have been submitted successfully.')

boolean isAlertPresent = WebUI.waitForAlert(3, FailureHandling.OPTIONAL)
if (isAlertPresent) {
	String alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Success! Your details have been submitted successfully.', false, FailureHandling.STOP_ON_FAILURE)
	WebUI.acceptAlert()
} else {
	WebUI.comment('❌ No alert appeared, checking for on-screen success message...')
}

WebUI.closeBrowser()

