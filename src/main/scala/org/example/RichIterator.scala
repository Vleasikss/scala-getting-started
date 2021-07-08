package org.example

trait RichIterator extends AbsIterator {

  /**
   * Calls a function while the iterator contains the elements
   *
   *  - Gives into a function f next element param
   *
   * @param f function
   */
  def forEach(f: T => Unit): Unit =
    while (hasNext) f(next())

}
