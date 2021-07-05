package org.example.producer_consumer

class Producer[+T] {
  def read: T = ???
}

object Demo extends App {
  def f(src: Producer[Object]): Unit = {
    val x: Object
     = src.read
  }
  f(new Producer[String])
}
