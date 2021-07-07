package org.example.promise

import org.example.promise.Main.PromiseStatuses
import org.example.promise.Main.PromiseStatuses.PromiseStatus

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future, Promise}

object Main {


  implicit val executionContext:ExecutionContext = ExecutionContext.fromExecutor(
    Executors.newFixedThreadPool(10))

  object PromiseStatuses extends Enumeration {
    type PromiseStatus = Value

    val OK, ERROR = Value
  }

  val value: PromiseStatuses.Value = PromiseStatuses.OK

  def main(args: Array[String]): Unit = {
    val promise = Promise[PromiseStatus]()

    val producer = Future {
      println("Producer called")
      // on dealing with its, promise value will be set
      if (value == PromiseStatuses.OK) {
        promise.success(value)
      } else if (value == PromiseStatuses.ERROR) {
        promise.failure(new InterruptedException("Status is error"))
      }
      println("Producer quit")
    }
    val consumer = Future {
      println("Consumer called")
      // on setting the value to promise, this method will be called
      promise.future.foreach(value => println(value))

      for (exc <- promise.future.failed) println(exc)

      println("Consumer quit")
    }

    Thread.sleep(1000)
  }

}
