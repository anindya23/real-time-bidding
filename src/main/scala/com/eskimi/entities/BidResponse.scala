package com.eskimi.entities

case class BidResponse(id: String,
    bidRequestId: String,
    price: Double,
    adid: Option[String],
    banner: Option[Banner])