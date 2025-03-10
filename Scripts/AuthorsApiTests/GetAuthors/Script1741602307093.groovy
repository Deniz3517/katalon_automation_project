import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def response = WS.sendRequest(findTestObject('AuthorsApi/GetAuthors'))

WS.verifyResponseStatusCode(response, 200)

WS.verifyElementPropertyValue(response, '[0].id', 1)

WS.verifyElementPropertyValue(response, '[0].firstName', 'First Name 1')

assert response.getResponseText() != null

