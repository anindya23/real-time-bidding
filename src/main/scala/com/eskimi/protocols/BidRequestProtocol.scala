package com.eskimi.protocols

import com.eskimi.entities._

trait BidRequestProtocol extends BaseProtocol {
  implicit val geoFormat = jsonFormat4(Geo)
  implicit val siteFormat = jsonFormat2(Site)
  implicit val impFormat = jsonFormat8(Impression)
  implicit val deviceFormat = jsonFormat2(Device)
  implicit val userFormat = jsonFormat2(User)
  implicit val bidRequestFormat = jsonFormat5(BidRequest)
}