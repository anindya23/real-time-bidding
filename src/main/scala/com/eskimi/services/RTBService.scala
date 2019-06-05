package com.eskimi.services

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}

import scala.util.Try
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import com.eskimi.entities._
import scala.collection.mutable.MutableList

class RTBService {

  val campaigns = Seq(
    Campaign(101, 201, "Bangladesh", Set(TimeRange(1000, 2000)), Targeting(List("Dhaka", "Chittagong", "Sylhet"), List(1,2,3,4)), List(Banner(1, "Source1", 100, 50), Banner(2, "Source2", 50, 100)), .70),
    Campaign(102, 202, "Bhutan", Set(TimeRange(3000, 4000)), Targeting(List("Thimphu", "Paro", "Punakha"), List(5,6,7,8)), List(Banner(3, "Source3", 80, 40), Banner(4, "Source4", 40, 80)), 8.50),
    Campaign(103, 203, "Bangladesh", Set(TimeRange(1000, 2000)), Targeting(List("Rajshahi", "Chittagong", "Sylhet"), List(1,2,3,4)), List(Banner(5, "Source5", 70, 30), Banner(6, "Source6", 30, 70)), .50),
  )

  def processRequest(request: BidRequest): Future[BidResponse] = Future {
      val response: BidResponse = getResponseFromDSP(request)
      if (response.isInstanceOf[BidResponse]) {
        response
      } else {
        throw new IllegalStateException("Boom!")
      }
  }

  def getResponseFromDSP(request: BidRequest): BidResponse = {
    val winningCampaign = getWinningCampaign(request)
    BidResponse("1001", request.id, winningCampaign.bid, Some("Adid Done"), Some(Banner(1, "Source1", 100, 50)))
  }
  
  def getWinningCampaign(request: BidRequest): Campaign = {
    val campaignList = getRegionBasedCampaigns(request)
    getHighestBidCampaign(campaignList)
  }
  
  def getRegionBasedCampaigns(request: BidRequest): MutableList[Campaign] = {
    val campaignList = MutableList[Campaign]()
    var userCity = ""
    var deviceCity = ""
    
    request.user.foreach { user =>
      user.geo.foreach { geo =>
        userCity = geo.city.getOrElse("")
      }
    }
    
    request.device.foreach { device =>
      device.geo.foreach { geo =>
        deviceCity = geo.city.getOrElse("")
      }
    }

    campaigns.foreach { campaign =>
      if (campaign.targeting.cities.contains(userCity) || campaign.targeting.cities.contains(deviceCity)) {
        campaignList += campaign
      }
    }
    campaignList
  }
  
  def getHighestBidCampaign(camps: MutableList[Campaign]): Campaign = {
    var highestPrice = 0.0
    var index = 0
    for (i <- 0 until camps.size) {
      if (camps(i).bid > highestPrice) {
        highestPrice = camps(i).bid
        index = i
      }
    }
    camps(index)
  }

  def tryFetchEmployees(): Try[HttpResponse] = Try {
    throw new IllegalStateException("Boom!")
  }

  def defaultResponse(): HttpResponse =
    HttpResponse(
      status = StatusCodes.NotFound,
      entity = "An unexpected error occurred. Please try again.")
  
}