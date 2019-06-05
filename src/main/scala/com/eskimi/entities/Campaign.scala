package com.eskimi.entities

case class Campaign(id: Int,
    userId: Int,
    country: String,
    runningTimes: Set[TimeRange],
    targeting: Targeting,
    banners: List[Banner],
    bid: Double)