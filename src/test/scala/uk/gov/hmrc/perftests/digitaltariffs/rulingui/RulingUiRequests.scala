/*
 * Copyright 2022 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
