package com.example.gatlingdemo

import com.example.gatlingdemo.CustomerService

object DataProvider {

  def customerService: CustomerService = new CustomerService()

  def customerId(): String = {
    val custId = customerService.customerId().block()

    custId match {
      case null => throw new RuntimeException("No customer id exists")
      case id => id
    }
  }
}