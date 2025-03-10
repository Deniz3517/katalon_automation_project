import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject


RequestObject request = findTestObject('AuthorsApi/PutAuthorsId')


int idAuthors = 1  


request.setRestUrl("https://fakerestapi.azurewebsites.net/api/v1/Authors/" + idAuthors)


def response = WS.sendRequest(request)


WS.verifyResponseStatusCode(response, 200)


def jsonResponse = new groovy.json.JsonSlurper().parseText(response.getResponseText())


assert jsonResponse.id == 0
assert jsonResponse.idBook == 0
assert jsonResponse.firstName == "string"
assert jsonResponse.lastName == "string"
