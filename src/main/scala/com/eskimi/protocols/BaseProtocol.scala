package com.eskimi.protocols

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

trait BaseProtocol extends SprayJsonSupport with DefaultJsonProtocol {
  import spray.json._
  implicit val printer = PrettyPrinter
}