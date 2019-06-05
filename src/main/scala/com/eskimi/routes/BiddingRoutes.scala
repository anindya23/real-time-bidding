package com.eskimi.routes

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshaller.identityUnmarshaller
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

import com.eskimi.protocols._
import com.eskimi.entities._
import com.eskimi.services._

class BiddingRoutes extends BidRequestProtocol with HttpServerProtocol with BidResponseProtocol with LazyLogging {
  
  val service = new RTBService()
  
  def route(): Route = {
    path("bidding") {
      post {
        entity(as[BidRequest]) { bidRquest =>
          logger.info(s"Sending Bid Request = $bidRquest")
          onComplete(service.processRequest(bidRquest)) {
            case Success(response) => complete(StatusCodes.OK, response)
            case Failure(ex) => complete(StatusCodes.NoContent, s"${ex.getMessage}")
          }
        }
      } ~ delete {
        complete(StatusCodes.MethodNotAllowed, "The HTTP DELETE operation is not allowed for the create-employee path.")
      }
    } ~ path("complete-with-http-response") {
      get {
        complete(HttpResponse(status = StatusCodes.OK, entity = "Using an HttpResponse object"))
      }
    } ~ path("akka-http-failwith") {
      get {
        failWith(new RuntimeException("Boom"))
      }
    } ~ path("akka-http-getresource") {
      getFromResource("error-page.html")
    }
  }
}