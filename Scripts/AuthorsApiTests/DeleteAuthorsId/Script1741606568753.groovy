import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject // Burada import işlemini ekliyoruz


RequestObject request = findTestObject('AuthorsApi/DeleteAuthorsId')


int idAuthors = 1
request.setRestUrl("https://fakerestapi.azurewebsites.net/api/v1/Authors/" + idAuthors)


def response = WS.sendRequest(request)


WS.verifyResponseStatusCode(response, 200)


assert response.getResponseText() == ''
