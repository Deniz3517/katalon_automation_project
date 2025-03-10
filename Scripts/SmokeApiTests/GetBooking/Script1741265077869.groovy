import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static org.assertj.core.api.Assertions.*
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository


def response = WS.sendRequestAndVerify(ObjectRepository.findTestObject('null'))

WS.verifyResponseStatusCode(response, 200)


def jsonResponse = response.getResponseText()


assert jsonResponse != null


def jsonResponseObject = new JsonSlurper().parseText(jsonResponse)


assert jsonResponseObject.size() > 0  


assert jsonResponseObject[0].bookingid != null


jsonResponseObject.each { booking ->
	assert booking.bookingid != null
}

println('API test for booking list passed!')
