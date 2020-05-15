package uk.gov.hmrc.perftests.digitaltariffs.rulingui

import io.gatling.core.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.digitaltariffs.DigitalTariffsPerformanceTestRunner
import uk.gov.hmrc.perftests.digitaltariffs.rulingui.RulingUiRequests._

class RulingUiSimulation extends PerformanceTestRunner with DigitalTariffsPerformanceTestRunner {

  override val httpProtocol: HttpProtocolBuilder = {
    buildHttpProtocol(url = externalBaseUrl)
  }
    setup("rulingUI", "Trader searches for rulings") withRequests(
      getStartPage,
      searchPage,
      getQueryResultPage
  )

  runSimulation()

}
