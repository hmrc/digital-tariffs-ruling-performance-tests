#!/bin/bash

sbt -Dperftest.runSmokeTest=false -DrunLocal=true Gatling/test
