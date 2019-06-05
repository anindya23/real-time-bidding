package com.eskimi.entities

case class Geo(country: Option[String],
    city: Option[String],
    lat: Option[Double],
    lon: Option[Double])