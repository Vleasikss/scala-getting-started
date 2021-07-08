package org.example

/**
 * Примеси (Mixin) - это трейты, которые используются для создания класса.
 *
 * Difference between inheritance:
 *  - mixins is more about dynamically adding a set of methods into an object
 *
 *  1. Inheritance used for inheriting properties
 *  1. Mixin used for inheriting functionality
 */
object Main {

  def main(args: Array[String]): Unit = {
    val richIterator = new RichIteratorImpl
    richIterator.forEach(print)
  }
}
