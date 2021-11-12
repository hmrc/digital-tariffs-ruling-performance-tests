/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.digitaltariffs

import io.gatling.core.Predef._
import io.gatling.core.controller.inject.open.OpenInjectionStep
import io.gatling.http.Predef.http
import io.gatling.http.protocol.HttpProtocolBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner

import scala.concurrent.duration._

trait DigitalTariffsPerformanceTestRunner extends PerformanceTestRunner with ServicesConfiguration {

  protected def buildHttpProtocol(url: String): HttpProtocolBuilder = {
    http
      .userAgentHeader("DigitalTariffs-PerformanceTests")
      .connectionHeader("close")
      .baseUrl(url)
  }

  protected val externalBaseUrl = "https://www.staging.tax.service.gov.uk"

  protected val rulingUiBaseUrl = baseUrlFor("binding-tariff-ruling-frontend") + "/search-for-advance-tariff-rulings"

  protected val rate = 0.5D
  protected val rampInterval = 1.minute  // 5.seconds
  protected val mainInterval = 8.minutes // 15.seconds

  protected def simulationSteps: Seq[OpenInjectionStep] =
    Seq(
      rampUsersPerSec(0).to(rate).during(rampInterval), // growth
      constantUsersPerSec(rate).during(mainInterval),          // constant
      rampUsersPerSec(rate).to(0).during(rampInterval)  // shutting down
    )

  protected def simulationAssertion: Seq[Assertion] =
    Seq(
      global.successfulRequests.percent.gte(99.0)
    )

}
