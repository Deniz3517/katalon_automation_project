import static org.assertj.core.api.Assertions.*
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.ObjectRepository


RequestObject request = ObjectRepository.findTestObject('RestReqServices/UpdateBooking')

String bookingId = "1" 
String url = "https://restful-booker.herokuapp.com/booking/" + bookingId
request.setRestUrl(url)


def response = WS.sendRequest(request)

WS.verifyResponseStatusCode(response, 200)


WS.verifyElementPropertyValue(response, 'firstname', 'James')
WS.verifyElementPropertyValue(response, 'lastname', 'Brown')
