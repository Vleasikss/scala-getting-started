package org.example

object Main {

  def main(args: Array[String]): Unit = {
    val richIterator = new RichIteratorImpl
    richIterator.forEach(print)
  }
}
