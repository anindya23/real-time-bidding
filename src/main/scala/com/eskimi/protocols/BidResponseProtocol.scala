package com.eskimi.protocols

import com.eskimi.entities._

trait BidResponseProtocol extends BaseProtocol {
  implicit val bannerFormat = jsonFormat4(Banner)
  implicit val bidResponseFormat = jsonFormat5(BidResponse)  
}