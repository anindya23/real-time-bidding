package com.eskimi.entities

case class BidRequest(id: String,
    imp: Option[List[Impression]],
    site: Site,
    user: Option[User],
    device: Option[Device])