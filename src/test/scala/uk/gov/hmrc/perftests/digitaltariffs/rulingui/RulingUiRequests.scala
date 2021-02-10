package uk.gov.hmrc.perftests.digitaltariffs.rulingui

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.perftests.digitaltariffs.DigitalTariffsPerformanceTestRunner

object RulingUiRequests extends DigitalTariffsPerformanceTestRunner {

  private val homePage = s"$rulingUiBaseUrl/search?enableTrackingConsent=true"

  def getStartPage: HttpRequestBuilder = {
    http("Start Page")
      .get(s"$rulingUiBaseUrl/search?enableTrackingConsent=true")
      .check(status.is(200))
      .check(currentLocation.is(homePage))
  }

  def getQueryResultPage: HttpRequestBuilder = {
    http("Search Results")
      .get(s"$rulingUiBaseUrl/search?query=laptop")
      .check(status.is(200))
  }

}
