package com.eskimi.protocols

import com.eskimi.entities._

trait HttpServerProtocol extends BaseProtocol {
  implicit val serverFormat = jsonFormat2(HttpServer)
}