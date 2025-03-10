import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import groovy.json.JsonSlurper

int idBook = 1

RequestObject request = findTestObject('AuthorsApi/GetAuthorsByBook')
request.setRestUrl("https://fakerestapi.azurewebsites.net/api/v1/Authors/authors/books/" + idBook)

def response = WS.sendRequest(request)

WS.verifyResponseStatusCode(response, 200)

def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

assert jsonResponse.size() > 0
WS.verifyElementPropertyValue(response, '[0].idBook', idBook)
