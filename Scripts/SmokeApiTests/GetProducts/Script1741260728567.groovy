import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ObjectRepository  
import groovy.json.JsonSlurper

def response = WS.sendRequestAndVerify(ObjectRepository.findTestObject('Object Repository/RestReqServices/ProductsList'))


WS.verifyResponseStatusCode(response, 200)


def jsonResponse = response.getResponseText()


assert jsonResponse != null
assert jsonResponse.contains('products')


def jsonResponseObject = new JsonSlurper().parseText(jsonResponse)


assert jsonResponseObject.products.size() > 0
assert jsonResponseObject.products[0].name != null

println('API test passed!')
