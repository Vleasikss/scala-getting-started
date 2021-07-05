package org.example.producer_consumer

class Consumer[-T] {
  def write(arg: T):Unit = ??? // (T) => ()

}


object Demo extends App {
  def f(sink: Consumer[String]): Unit = {
    sink.write("hello!")
  }
  f(new Consumer[Object])
}