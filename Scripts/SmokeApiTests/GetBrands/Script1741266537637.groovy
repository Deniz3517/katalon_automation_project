import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ObjectRepository
import groovy.json.JsonSlurper


def response = WS.sendRequestAndVerify(ObjectRepository.findTestObject('Object Repository/RestReqServices/BrandList'))



WS.verifyResponseStatusCode(response, 200)


def jsonResponse = response.getResponseText()


assert jsonResponse != null


assert jsonResponse.contains('brands')

def jsonResponseObject = new JsonSlurper().parseText(jsonResponse)


