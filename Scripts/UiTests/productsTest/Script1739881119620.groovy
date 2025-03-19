import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()


WebUI.openBrowser('')
WebUI.navigateToUrl(GlobalVariable.siteURL)


WebUI.comment("opened page: " + GlobalVariable.siteURL)


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Automation Exercise/p_Consent'), 10)
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/p_Consent'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Automation Exercise/a_Products'), 10)
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/a_Products'))


WebUI.scrollToElement(findTestObject('Page_Automation Exercise - HM Products/a_View Product'), 10)
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - HM Products/a_View Product'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Automation Exercise - Product Details/input_Quantity_quantity'), 10)
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Product Details/input_Quantity_quantity'), '2')


WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Product Details/button_Add to cart'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Automation Exercise - Product Details/button_Continue Shopping'), 10)
WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Product Details/button_Continue Shopping'))
