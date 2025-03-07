import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static org.assertj.core.api.Assertions.*
import groovy.json.JsonSlurper
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository


def response = WS.sendRequest(ObjectRepository.findTestObject('Object Repository/RestReqServices/CreateBooking'))


WS.verifyResponseStatusCode(response, 201)


def jsonResponse = response.getResponseText()
assert jsonResponse != null


def jsonResponseObject = new JsonSlurper().parseText(jsonResponse)


assert jsonResponseObject.bookingid != null


assert jsonResponseObject.booking.firstname == "Jim"
assert jsonResponseObject.booking.lastname == "Brown"
assert jsonResponseObject.booking.totalprice == 111
assert jsonResponseObject.booking.depositpaid == true
assert jsonResponseObject.booking.bookingdates.checkin == "2018-01-01"
assert jsonResponseObject.booking.bookingdates.checkout == "2019-01-01"
assert jsonResponseObject.booking.additionalneeds == "Breakfast"


println('✅ Booking successful: ' + jsonResponseObject.bookingid)
