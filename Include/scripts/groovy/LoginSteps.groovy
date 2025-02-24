import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import cucumber.api.java.en.Given
import cucumber.api.java.en.When
import cucumber.api.java.en.Then

class LoginSteps {

	@Given("The user navigates to the login page")
	def navigateToLoginPage() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://www.automationexercise.com/')
		WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/p_Consent'))
		WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/a_Signup  Login'))
	}

	@When("The user logs in with {string} and the correct password")
	def loginUser(String email) {
		WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_Login to your account_email'), email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_Login to your account_password'), 'tzH6RvlfSTg=')
		WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/button_Login'))
	}

	@Then("The user is redirected to the homepage")
	def verifyHomePage() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Automation Exercise/homepage_element'), 10)
		WebUI.closeBrowser()
	}
}
