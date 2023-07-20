resolvers += MavenRepository("HMRC-open-artefacts-maven2", "https://open.artefacts.tax.service.gov.uk/maven2")
resolvers += Resolver.url("HMRC-open-artefacts-ivy2", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(
  Resolver.ivyStylePatterns
)

addSbtPlugin("uk.gov.hmrc"         % "sbt-auto-build" % "3.9.0")
addSbtPlugin("io.gatling"          % "gatling-sbt"    % "4.1.5")
addSbtPlugin("com.timushev.sbt"    % "sbt-updates"    % "0.6.3")
addSbtPlugin("org.scalameta"       % "sbt-scalafmt"   % "2.5.0")
addSbtPlugin("com.beautiful-scala" % "sbt-scalastyle" % "1.5.1")
