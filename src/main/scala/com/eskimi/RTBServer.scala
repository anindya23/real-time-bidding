package com.eskimi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.stream.ActorMaterializer

import scala.io.StdIn
import scala.util.{Failure, Success}

import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.LazyLogging

import com.eskimi.routes.{BiddingRoutes, ServerVersionRoutes}
import com.eskimi.routes.ServerVersionRoutes
import com.eskimi.routes.BiddingRoutes

object RTBServer extends App with LazyLogging {
  
  val config: Config = ConfigFactory.load()
  val host: String = config.getString("http.host")
  val port: Int = config.getInt("http.port")
  
  implicit val actorSystem = ActorSystem("real-time-bidding")
  implicit val materializer = ActorMaterializer()
  implicit val ec = actorSystem.dispatcher

  val serverVersion = new ServerVersionRoutes()
  val serverVersionRoute = serverVersion.route()
  val serverVersionRouteAsJson = serverVersion.routeAsJson()
  val serverVersionJsonEncoding = serverVersion.routeAsJsonEncoding()
  val biddingRoutes = new BiddingRoutes().route()
  
  val routes: Route =  biddingRoutes ~ serverVersionRoute ~ serverVersionRouteAsJson ~ serverVersionJsonEncoding

  val httpServerFuture = Http().bindAndHandle(routes, host, port)
  
  httpServerFuture.onComplete {
    case Success(binding) =>
      logger.info(s"RTB Http Server is UP and is bound to ${binding.localAddress}")

    case Failure(e) =>
      logger.error(s"Akka Http server failed to start", e)
      actorSystem.terminate()
  }
}
