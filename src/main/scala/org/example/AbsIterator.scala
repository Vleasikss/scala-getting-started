package org.example

abstract class AbsIterator {

  /**
   * similar to AbsIterator[T], but its a variable, so it can overrides
   */
  type T

  def hasNext: Boolean

  def next(): T
}
