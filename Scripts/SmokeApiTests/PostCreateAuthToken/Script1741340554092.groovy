import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository


def authResponse = WS.sendRequest(ObjectRepository.findTestObject('Object Repository/RestReqServices/AuthToken'))



WS.verifyResponseStatusCode(authResponse, 200)


def jsonResponse = new JsonSlurper().parseText(authResponse.getResponseText())


assert jsonResponse.token != null
println("Generated Token: " + jsonResponse.token)
