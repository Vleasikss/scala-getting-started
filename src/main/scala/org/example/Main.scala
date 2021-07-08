package org.example

/**
 * Примеси (Mixin) - это трейты, которые используются для создания класса.
 */
object Main {

  def main(args: Array[String]): Unit = {
    val richIterator = new RichIteratorImpl
    richIterator.forEach(print)
  }
}
