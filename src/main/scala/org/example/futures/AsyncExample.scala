package org.example.futures

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object AsyncExample {

  def main(args: Array[String]): Unit = {
    val sumF = Future[Long] {(1L to 50).sum}

    // when asynchronous function will be proceed, this method will be called
    // main thread won't be blocked
    sumF.onComplete {
      case Success(value: Long) => println(value)
      case Failure(exception) => println("An error has occured: " + exception.getMessage)
    } // 1275

    // requires to call the async method, otherwise they won't be called
    Thread.sleep(1000) // otherwise


  }

}
