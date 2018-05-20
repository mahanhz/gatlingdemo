package com.example.gatlingdemo

import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration._

class LoadTestSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://localhost:8080")

  val scn = scenario("MySimulation")
    .exec(http("request1")
      .get("/hello"))
  setUp(scn.inject(atOnceUsers(1)).protocols(httpConf))
}