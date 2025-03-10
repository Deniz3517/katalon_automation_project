import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

def response = WS.sendRequest(findTestObject('AuthorsApi/PostAuthors'))

WS.verifyResponseStatusCode(response, 200)
WS.verifyElementPropertyValue(response, 'id', 1) // 
WS.verifyElementPropertyValue(response, 'idBook', 1)
WS.verifyElementPropertyValue(response, 'firstName', 'string')
WS.verifyElementPropertyValue(response, 'lastName', 'string')

assert response.getResponseText() != null
