package org.example.futures


import java.util.concurrent.{Executors, ThreadPoolExecutor}
import scala.concurrent.{Await, ExecutionContext, Future}

// with no import its, each Future will require executionContext to set
//import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.{Duration, DurationInt, FiniteDuration}

object AwaitExample {

  val MAX_TIME_TO_WAIT: FiniteDuration = 30.seconds

  // managing executions manually
  implicit val executionContext: ExecutionContext =
    ExecutionContext.fromExecutor(Executors.newFixedThreadPool(10))

  /**
   * Blocks main thread to receive a result
   */
  def main(args: Array[String]): Unit = {
    val sumF = Future[Long] {
      (1L to 50).sum
    }

    // first param is a function to wait
    // second param is max time to wait
    val result = Await.result(sumF, MAX_TIME_TO_WAIT)
    println(result)
  }

}
